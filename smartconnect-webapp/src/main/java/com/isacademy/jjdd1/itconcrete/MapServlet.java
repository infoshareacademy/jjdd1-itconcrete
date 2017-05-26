package com.isacademy.jjdd1.itconcrete;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/map")
public class MapServlet extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/map.jsp");
            dispatcher.forward(request, response);
        }
}
