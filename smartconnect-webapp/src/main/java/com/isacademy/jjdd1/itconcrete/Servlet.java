package com.isacademy.jjdd1.itconcrete;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.CompleteResultDisplayer;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/smartconnect")
public class Servlet extends HttpServlet {

    private String test;

//    @Inject
//    // todo

    @Override
    public void init() throws ServletException {
        this.test = test;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // todo

    }

}
