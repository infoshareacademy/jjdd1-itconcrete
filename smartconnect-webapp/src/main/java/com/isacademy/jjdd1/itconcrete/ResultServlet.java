package com.isacademy.jjdd1.itconcrete;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.CompleteResult;
import isacademy.jjdd1.itconcrete.smartconnect.analyzer.CompleteResultGetter;
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
import javax.servlet.http.Part;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = "/smartconnect_results")
public class ResultServlet extends HttpServlet {

    List<CompleteResult> completeResultList;

    @Inject
    CompleteResultGetter completeResultGetter;

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
        request.setAttribute("completeResultList", completeResultList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String homeBusStop = request.getParameter("homeBusStop");
        String timeOfLeavingHome = request.getParameter("timeOfLeavingHome");
        String timeOfArrivingHome = request.getParameter("timeOfArrivingHome");
        String maxAmountOfResults = request.getParameter("maxAmountOfResults");


        Part calendarFile = request.getPart("calendarFile");
        InputStream fileContent = calendarFile.getInputStream();

        final Path TEMP = Paths.get(System.getProperty("java.io.tmpdir")).resolve("smartconnect").resolve("calendar.ics");

        byte[] buffer = new byte[8 * 1024];
        try {
            OutputStream outputStream = Files.newOutputStream(TEMP);
            try {
                int bytesRead;
                while ((bytesRead = fileContent.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            } finally {
                outputStream.close();
            }
        } finally {
            fileContent.close();
        }

        try {
            completeResultList = completeResultGetter.getCompleteResult(homeBusStop, timeOfLeavingHome, timeOfArrivingHome,
                    Integer.valueOf(maxAmountOfResults), allBusLines);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        request.setAttribute("completeResultList", completeResultList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

}
