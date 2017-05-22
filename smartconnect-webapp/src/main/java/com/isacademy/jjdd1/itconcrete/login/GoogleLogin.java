package com.isacademy.jjdd1.itconcrete.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Path("/")
public class GoogleLogin {

    private static final String GOOGLE_CLIENT_ID = "1092866121133-5hu5u791n1op9qanolt6nshutoibja0u.apps.googleusercontent.com";
    private static final String GOOGLE_CLIENT_SECRET = "yP79txaYKwrHzah_eKuGUwTD";
    private static final String PROTECTED_RESOURCE_URL = "https://www.googleapis.com/oauth2/v2/userinfo";
    private static final String CALLBACK_URL = "http://localhost:8080/google/callback";
    private static final String FORM_PAGE = "http://localhost:8080/form";
    private static final String LOGIN_PAGE = "http://localhost:8080/login";

    private OAuth20Service service = new ServiceBuilder()
            .apiKey(GOOGLE_CLIENT_ID)
            .apiSecret(GOOGLE_CLIENT_SECRET)
            .scope("profile")
            .scope("email")
            .callback(CALLBACK_URL)
            .build(GoogleApi20.instance());

    @Inject
    SessionData sessionData;

    @GET
    @Path("/login")
    public Response login() {
        final Map<String, String> additionalParams = new HashMap<>();
        additionalParams.put("access_type", "offline");
        additionalParams.put("prompt", "consent");
        String authorizationUrl = service.getAuthorizationUrl(additionalParams);
        return Response.seeOther(URI.create(authorizationUrl)).build();
    }

    @GET
    @Path("/callback")
    public Response callback(@QueryParam("code") String code) {

        try {
            OAuth2AccessToken accessToken = service.getAccessToken(code);
            OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
            service.signRequest(accessToken, request);

            String responseBody = service.execute(request).getBody();
            GoogleUser googleUser = new ObjectMapper().readValue(responseBody, GoogleUser.class);
            sessionData.logUser(googleUser);
            return Response.temporaryRedirect(URI.create(FORM_PAGE)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.temporaryRedirect(URI.create(FORM_PAGE)).build();
        }
    }

    @GET
    @Path("/logout")
    public Response logout() {
        sessionData.logout();
        return Response.temporaryRedirect(URI.create(LOGIN_PAGE)).build();
    }
}
