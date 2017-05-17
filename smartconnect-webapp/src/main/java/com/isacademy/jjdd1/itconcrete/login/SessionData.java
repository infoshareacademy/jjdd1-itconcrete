package com.isacademy.jjdd1.itconcrete.login;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class SessionData implements Serializable {

    private boolean logged = false;
    private User user;
    private String referer;

    public void logUser(User user) {
        this.user = user;
        this.logged = true;
    }

    public void logout() {
        this.logged = false;
    }

    public boolean isLogged() {
        return logged;
    }

    public User getUser() {
        return user;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }
}