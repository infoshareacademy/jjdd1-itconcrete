package com.isacademy.jjdd1.itconcrete;


import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.FakeStatisticGenerator;
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


@WebServlet(urlPatterns = "/line_popularity")
@MultipartConfig
public class LinePopularityServlet extends HttpServlet {

    @Inject
    ScheduleParser scheduleParser;

    @Inject
    FakeStatisticGenerator fakeStatisticGenerator;


    private ArrayList<StatisticsData> statistics;


    @Override
    public void init() throws ServletException {

        statistics = fakeStatisticGenerator.getStatistics();
        statistics.sort((a, b) -> ((Integer)a.getLineNumber()).compareTo(b.getLineNumber()));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        request.setAttribute("statistics", statistics);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/line.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        request.setAttribute("statistics", statistics);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/line_popularity");
        dispatcher.forward(request, response);

    }

}
