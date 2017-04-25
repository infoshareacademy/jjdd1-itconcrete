package com.isacademy.jjdd1.itconcrete;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.ResultConnection;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.CompleteResultDisplayer;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.Util;
import isacademy.jjdd1.itconcrete.smartconnect.forwebapp.ResultForWebApp;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/smartconnect_results")
public class ResultServlet extends HttpServlet {

    List<ResultForWebApp> resultForWebAppList;

    @Inject
    CompleteResultDisplayer completeResultDisplayer;

    @Inject
    ScheduleParser scheduleParser;

    @Inject
    Util util;

    ArrayList<BusLine> allBusLines;

    @Override
    public void init() throws ServletException {

        try {
            scheduleParser.loadData();
            allBusLines = scheduleParser.getArrayOfBusLines();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("resultForWebAppList", resultForWebAppList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String homeBusStop = request.getParameter("homeBusStop");
        String timeOfLeavingHome = request.getParameter("timeOfLeavingHome");
        String timeOfArrivingHome = request.getParameter("timeOfArrivingHome");
        String maxAmountOfResults = request.getParameter("maxAmountOfResults");

        try {
            completeResultDisplayer.displayCompleteResult(homeBusStop, timeOfLeavingHome, timeOfArrivingHome,
                    Integer.valueOf(maxAmountOfResults), allBusLines);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        resultForWebAppList = completeResultDisplayer.getAllResultConnections();

        request.setAttribute("resultForWebAppList", resultForWebAppList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }


}
