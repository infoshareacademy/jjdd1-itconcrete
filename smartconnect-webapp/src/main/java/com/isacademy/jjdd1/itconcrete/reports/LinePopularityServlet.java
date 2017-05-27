package com.isacademy.jjdd1.itconcrete.reports;

import isacademy.jjdd1.itconcrete.smartconnect.database.BusLineStatisticsSaver;
import isacademy.jjdd1.itconcrete.smartconnect.database.BusStopStatisticsSaver;
import isacademy.jjdd1.itconcrete.smartconnect.database.DBUpdater;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.FakeLineStatisticGenerator;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.LineStatisticsData;
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


@WebServlet(urlPatterns = "/reports/line_popularity")
@MultipartConfig
public class LinePopularityServlet extends HttpServlet {


    @Inject
    FakeLineStatisticGenerator fakeLineStatisticGenerator;

    @Inject
    DBUpdater dbUpdater;

    @Inject
    BusLineStatisticsSaver busLineStatisticsSaver;


    private ArrayList<StatisticsData> statistics;
    private List<LineStatisticsData> statistics2;

    public void loadStats() {
        try {
            fakeLineStatisticGenerator.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        statistics2 = busLineStatisticsSaver.getConvertedBusLineStatistics();
        statistics = fakeLineStatisticGenerator.getStatistics();
        statistics.sort((a, b) -> ((Integer)a.getLineNumber()).compareTo(b.getLineNumber()));
        statistics2.sort((a, b) -> ((Integer)a.getLineNumber()).compareTo(b.getLineNumber()));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        this.loadStats();
        request.setAttribute("statistics", statistics);
        RequestDispatcher dispatcher = request.getRequestDispatcher("line.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        request.setAttribute("statistics", statistics);
        RequestDispatcher dispatcher = request.getRequestDispatcher("line_popularity");
        dispatcher.forward(request, response);

    }

}
