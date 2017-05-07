package com.isacademy.jjdd1.itconcrete;

import isacademy.jjdd1.itconcrete.smartconnect.statistics.StatisticsData;


import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/line_popularity")
@MultipartConfig
public class LinePopularityServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/line.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<StatisticsData> statistics = new ArrayList<>();
        statistics.add(new StatisticsData(136,12));
        statistics.add(new StatisticsData(110,6));
        statistics.add(new StatisticsData(12,28));
        statistics.add(new StatisticsData(8,5));
        statistics.add(new StatisticsData(122,3));
        statistics.add(new StatisticsData(6,23));
        request.setAttribute("statistics", statistics);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/line.jsp");
        dispatcher.forward(request, response);
    }
}
