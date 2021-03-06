package com.isacademy.jjdd1.itconcrete.login;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class SessionData implements Serializable {

    private boolean logged = false;
    private GoogleUser googleUser;

    public void logUser(GoogleUser user) {
        this.googleUser = user;
        this.logged = true;
    }

    public void logout() {
        this.logged = false;
    }

    public boolean isLogged() {
        return logged;
    }

    public GoogleUser getGoogleUser() {
        return googleUser;
    }

}
