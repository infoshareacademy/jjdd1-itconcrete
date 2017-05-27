package com.isacademy.jjdd1.itconcrete;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer_direct.BusLineSeeker;
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
import java.util.ArrayList;

@WebServlet(urlPatterns = "/map")
public class MapServlet extends HttpServlet {

    @Inject
    ScheduleParser scheduleParser;

    @Inject
    BusLineSeeker busLineSeeker;

    @Inject
    Util util;

    private ArrayList<BusLine> busLinesForSeeking;


    @Override
    public void init() throws ServletException {

        busLinesForSeeking = scheduleParser.getArrayOfBusLines();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/map.jsp");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        if (!validateBusStop(request)) {
            request.setAttribute("busStopError", "Wrong data, try again. ");
        } else {
            setCorrectParameter(request, "busStop");
        }
    }

    private boolean validateBusStop(HttpServletRequest request) {
        String homeBusStop = request.getParameter("busStop");
        boolean correctBusStop = util.busStopExistence(homeBusStop, busLinesForSeeking);
        return correctBusStop;
    }

    private void setCorrectParameter(HttpServletRequest request, String placeholder) {
        String value = request.getParameter(placeholder);
        request.setAttribute(placeholder, value);
    }

}
