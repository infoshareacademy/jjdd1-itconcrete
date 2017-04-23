package com.isacademy.jjdd1.itconcrete;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.BusLineSeeker;
import isacademy.jjdd1.itconcrete.smartconnect.analyzer.ResultConnection;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.CompleteResultDisplayer;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.Util;
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

@WebServlet(urlPatterns = "/smartconnect_form")
public class FormServlet extends HttpServlet {

    @Inject
    ScheduleParser scheduleParser;

    @Inject
    BusLineSeeker busLineSeeker;

    @Inject
    Util util;

    private ArrayList<BusLine> busLinesForSeeking;


    @Override
    public void init() throws ServletException {

        try {
            scheduleParser.loadData();
            busLinesForSeeking = scheduleParser.getArrayOfBusLines();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/form.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (validateForm(req)) {

            RequestDispatcher dispatcher = req.getRequestDispatcher("/smartconnect_results");
            dispatcher.forward(req, resp);

        } else {

            req.setAttribute("errorMessage", "Wrong data, try again");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/form.jsp");
            dispatcher.forward(req, resp);
        }
    }

    private boolean validateForm(HttpServletRequest request) {

        String homeBusStop = request.getParameter("homeBusStop");
        String timeOfLeavingHome = request.getParameter("timeOfLeavingHome");
        String timeOfArrivingHome = request.getParameter("timeOfArrivingHome");
        String maxAmountOfResults = request.getParameter("maxAmountOfResults");

        boolean correctHomeBusStop = util.busStopExistence(homeBusStop, busLinesForSeeking);
        boolean correctTimeOfLeavingHome = timeOfLeavingHome.matches("^([01][0-9]|2[0-3]):[0-5][0-9]$");
        boolean correctTimeOfArrivingHome = timeOfArrivingHome.matches("^([01][0-9]|2[0-3]):[0-5][0-9]$");
        boolean correctMaxAmountOfResults = maxAmountOfResults.matches("(10|[1-9])");

        return (correctHomeBusStop && correctTimeOfLeavingHome && correctTimeOfArrivingHome && correctMaxAmountOfResults);
    }
}
