package com.isacademy.jjdd1.itconcrete;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.ResultConnection;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.CompleteResultDisplayer;
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

    List<ResultConnection> resultConnections;

    @Inject
    CompleteResultDisplayer completeResultDisplayer;

    @Inject
    ScheduleParser scheduleParser;

    @Override
    public void init() throws ServletException {

        try {
            scheduleParser.loadData();
            ArrayList<BusLine> allBusLines = scheduleParser.getArrayOfBusLines();

            completeResultDisplayer.displayCompleteResult("Klonowa", "06:00", "22:00", 3, allBusLines);

            resultConnections=completeResultDisplayer.getAllResultConnections();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    req.setAttribute("resultConnections", resultConnections);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("resultConnections", resultConnections);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }


}
