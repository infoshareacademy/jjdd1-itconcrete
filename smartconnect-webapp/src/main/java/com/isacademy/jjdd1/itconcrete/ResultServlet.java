package com.isacademy.jjdd1.itconcrete;

import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarParser;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteDirectResult;
import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteDirectResultGetter;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.Util;
import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteTransferResult;
import isacademy.jjdd1.itconcrete.smartconnect.result.TransferResultGetter;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
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
import java.util.LinkedList;
import java.util.List;

@WebServlet(urlPatterns = "/smartconnect_results")
public class ResultServlet extends HttpServlet {

//    LinkedList<Journey> journeys;

    ArrayList<BusLine> allBusLines;

    List<CompleteDirectResult> completeDirectResultList;

    List<CompleteTransferResult> completeTransferResultList;

    final String MAX_RESULTS_AMOUNT = "5";

    @Inject
    CalendarParser calendarParser;

    @Inject
    ScheduleParser scheduleParser;

    @Inject
    CompleteDirectResultGetter completeDirectResultGetter;

    @Inject
    TransferResultGetter transferResultGetter;

    @Inject
    Util util;

    @Override
    public void init() throws ServletException {

        allBusLines = scheduleParser.getArrayOfBusLines();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("completeDirectResultList", completeDirectResultList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/results.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String homeBusStop = request.getParameter("homeBusStop");
        String timeOfLeavingHome = request.getParameter("timeOfLeavingHome");
        String timeOfArrivingHome = request.getParameter("timeOfArrivingHome");
//        String MAX_RESULTS_AMOUNT = request.getParameter("MAX_RESULTS_AMOUNT");


        Part calendarFile = request.getPart("calendarFile");
        InputStream fileContent = calendarFile.getInputStream();

        final Path path = Paths.get(System.getProperty("java.io.tmpdir")).resolve("smartconnect").resolve("calendar.ics");

        byte[] buffer = new byte[8 * 1024];
        try {
            OutputStream outputStream = Files.newOutputStream(path);
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
            completeDirectResultList = completeDirectResultGetter.getCompleteResult(homeBusStop, timeOfLeavingHome, timeOfArrivingHome,
                    Integer.valueOf(MAX_RESULTS_AMOUNT), allBusLines);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try {
            completeTransferResultList = transferResultGetter.getTransfers(homeBusStop, timeOfLeavingHome, timeOfArrivingHome, Integer.valueOf(MAX_RESULTS_AMOUNT), allBusLines);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

//        try {
//            journeys = calendarParser.parseFileSortEventsAddHome(homeBusStop, timeOfLeavingHome, timeOfArrivingHome);
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }

        request.setAttribute("completeDirectResultList", completeDirectResultList);
        request.setAttribute("completeTransferResultList", completeTransferResultList);
//        request.setAttribute("journeys", journeys);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/results.jsp");
        dispatcher.forward(request, response);
    }

}
