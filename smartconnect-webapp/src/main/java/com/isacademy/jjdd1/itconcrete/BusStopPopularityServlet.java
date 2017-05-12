package com.isacademy.jjdd1.itconcrete;

import isacademy.jjdd1.itconcrete.smartconnect.statistics.FakeBusStopStatisticGenerator;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.StopStatisticsData;

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


@WebServlet(urlPatterns = "/stop_popularity")
@MultipartConfig
public class BusStopPopularityServlet extends HttpServlet {


    @Inject
    FakeBusStopStatisticGenerator fakeBusStopStatisticGenerator;

    private ArrayList<StopStatisticsData> statistics;

    public void loadStats() {
        try {
            fakeBusStopStatisticGenerator.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        statistics = fakeBusStopStatisticGenerator.getStatistics();
        statistics.sort((a, b) -> (a.getBusStopName()).compareTo(b.getBusStopName()));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        this.loadStats();
        request.setAttribute("statistics", statistics);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/stop.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        request.setAttribute("statistics", statistics);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/stop_popularity");
        dispatcher.forward(request, response);

    }

}
