package com.isacademy.jjdd1.itconcrete.reports;



import com.isacademy.jjdd1.itconcrete.reports.statistics.FakeBusStopStatisticGenerator;
import com.isacademy.jjdd1.itconcrete.reports.statistics.StopStatisticsData;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/reports/stop_popularity")
@MultipartConfig
public class BusStopPopularityServlet extends HttpServlet {


    @Inject
    FakeBusStopStatisticGenerator fakeBusStopStatisticGenerator;

    private List<StopStatisticsData> statistics;

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("stop.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        request.setAttribute("statistics", statistics);
        RequestDispatcher dispatcher = request.getRequestDispatcher("stop_popularity");
        dispatcher.forward(request, response);

    }

}
