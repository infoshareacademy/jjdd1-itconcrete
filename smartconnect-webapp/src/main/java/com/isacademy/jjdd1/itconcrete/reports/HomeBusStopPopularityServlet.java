package com.isacademy.jjdd1.itconcrete.reports;

import com.isacademy.jjdd1.itconcrete.database.DBUpdater;
import com.isacademy.jjdd1.itconcrete.database.HomeBusStop;
import com.isacademy.jjdd1.itconcrete.database.HomeBusStopUpdater;
import com.isacademy.jjdd1.itconcrete.statistics.StopStatsData;
import com.isacademy.jjdd1.itconcrete.statistics.HomeBusStopStatsGetter;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/reports/home_stop_popularity")
public class HomeBusStopPopularityServlet extends HttpServlet {

    @Inject
    HomeBusStopStatsGetter homeBusStopStatsGetter;

    @Inject
    DBUpdater dbUpdater;

    private List<StopStatsData> statistics = new ArrayList<>();

    public void loadStats() {

        statistics = homeBusStopStatsGetter.getStatistics();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        this.loadStats();
        request.setAttribute("statistics", statistics);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home_stop.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        request.setAttribute("statistics", statistics);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home_stop_popularity");
        dispatcher.forward(request, response);

    }
}
