package com.isacademy.jjdd1.itconcrete;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.BusLineSeeker;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.Util;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/smartconnect_form")
@MultipartConfig
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/form.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        boolean isError = false;

        if (!validateHomeBusStop(request)) {
            request.setAttribute("homeBusStopError", "Wrong data, try again. ");
            request.setAttribute("hasError1", "has-error");
            isError = true;
        } else {
            setCorrectParameter(request, "homeBusStop");
        }

        if (!validateTimeOfLeavingHome(request)) {
            request.setAttribute("timeOfLeavingError", "Wrong data, try again. ");
            request.setAttribute("hasError2", "has-error");
            isError = true;
        } else {
            setCorrectParameter(request, "timeOfLeavingHome");
        }

        if (!validateTimeOfArrivingHome(request)) {
            request.setAttribute("timeOfArrivingError", "Wrong data, try again. ");
            request.setAttribute("hasError3", "has-error");
            isError = true;
        } else {
            setCorrectParameter(request, "timeOfArrivingHome");
        }

        if (!validateMaxResults(request)) {
            request.setAttribute("maxResultsError", "Wrong data, try again. ");
            request.setAttribute("hasError4", "has-error");
            isError = true;
        } else {
            setCorrectParameter(request, "maxAmountOfResults");
        }

        if (!validateCalendarFile(request)) {
            request.setAttribute("calendarFileError", "Wrong file format, try again");
            request.setAttribute("hasError5", "has-error");
            isError = true;
        }

        if (isError) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/form.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/smartconnect_results");
            dispatcher.forward(request, response);
        }
    }

    private boolean validateHomeBusStop(HttpServletRequest request) {
        String homeBusStop = request.getParameter("homeBusStop");
        boolean correctHomeBusStop = util.busStopExistence(homeBusStop, busLinesForSeeking);
        return correctHomeBusStop;
    }


    private boolean validateTimeOfLeavingHome(HttpServletRequest request) {
        String timeOfLeavingHome = request.getParameter("timeOfLeavingHome");
        boolean correctTimeOfLeavingHome = timeOfLeavingHome.matches("^([01][0-9]|2[0-3]):[0-5][0-9]$");
        return correctTimeOfLeavingHome;
    }


    private boolean validateTimeOfArrivingHome(HttpServletRequest request) {
        String timeOfArrivingHome = request.getParameter("timeOfArrivingHome");
        boolean correctTimeOfArrivingHome = timeOfArrivingHome.matches("^([01][0-9]|2[0-3]):[0-5][0-9]$");
        return correctTimeOfArrivingHome;
    }


    private boolean validateMaxResults(HttpServletRequest request) {
        String maxAmountOfResults = request.getParameter("maxAmountOfResults");
        boolean correctMaxAmountOfResults = maxAmountOfResults.matches("(10|[1-9])");
        return correctMaxAmountOfResults;
    }

    private boolean validateCalendarFile(HttpServletRequest request) throws IOException, ServletException {
        Part calendarFile = request.getPart("calendarFile");
        boolean correctCalendarFile = calendarFile.getSubmittedFileName().endsWith("ics");
        return correctCalendarFile;
    }

    private void setCorrectParameter(HttpServletRequest request, String placeholder) {
        String value = request.getParameter(placeholder);
        request.setAttribute(placeholder, value);
    }
}