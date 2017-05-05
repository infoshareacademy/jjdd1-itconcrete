package com.isacademy.jjdd1.itconcrete;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LinePopularityServlet extends HttpServlet {

    @WebServlet(urlPatterns = "/line_popularity")
    @MultipartConfig
    public class FormServlet extends HttpServlet {

        @Override
        public void init() throws ServletException {

            System.out.println("Abra kadabra");

        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/line.jsp");
            dispatcher.forward(request, response);
        }
    }
}
