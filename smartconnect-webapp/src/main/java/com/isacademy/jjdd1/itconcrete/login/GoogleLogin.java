package com.isacademy.jjdd1.itconcrete.login;

import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;


@WebServlet(urlPatterns = "/login")
public class GoogleLogin extends HttpServlet {

    final String CLIENT_ID = "1092866121133-5hu5u791n1op9qanolt6nshutoibja0u.apps.googleusercontent.com";
    final String CLIENT_SECRET = "yP79txaYKwrHzah_eKuGUwTD";
    private static final String PROTECTED_RESOURCE_URL = "https://www.googleapis.com/oauth2/v2/userinfo";
    private static final String CALLBACK_URL = "http://localhost:8080/smartconnect_form";

    private OAuth20Service service = new ServiceBuilder()
            .apiKey(CLIENT_ID)
            .apiSecret(CLIENT_SECRET)
            .scope("profile")
            .scope("email")
            .callback(CALLBACK_URL)
            .build(GoogleApi20.instance());

    @Inject
    SessionData sessionData;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        final String token = req.getParameter("token");
        if (token != null) {
            OAuth2AccessToken accessToken = null;

            try {
                accessToken = service.getAccessToken(token);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
            service.signRequest(accessToken, request);
        }

        User user = new User();

        Map<String, String> userMap = new HashMap<>();
        userMap.put("name", user.getName());
        userMap.put("surname", user.getSurname());
        userMap.put("email", user.getEmail());

        req.setAttribute("oauth", userMap);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("login").equals("1")) {
            final Map<String, String> additionalParams = new HashMap<>();
            additionalParams.put("access_type", "offline");
            additionalParams.put("prompt", "consent");
            resp.sendRedirect(service.getAuthorizationUrl(additionalParams));
            RequestDispatcher dispatcher = req.getRequestDispatcher("/form.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
