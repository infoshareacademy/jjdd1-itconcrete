package com.isacademy.jjdd1.itconcrete;

import isacademy.jjdd1.itconcrete.smartconnect.map.BusStopCoordinate;
import isacademy.jjdd1.itconcrete.smartconnect.map.CoordinatesGetter;
import isacademy.jjdd1.itconcrete.smartconnect.map.CoordinatesSetter;
import isacademy.jjdd1.itconcrete.smartconnect.map.LocationExistence;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/map")
public class MapServlet extends HttpServlet {

    @Inject
    CoordinatesSetter coordinatesSetter;

    @Inject
    LocationExistence locationExistence;

    @Inject
    CoordinatesGetter coordinatesGetter;

    List<BusStopCoordinate> busStopCoordinates;

    @Override
    public void init() throws ServletException {

        busStopCoordinates = coordinatesSetter.setCoordinates();

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

        String busStopName = request.getParameter("busStop");
        boolean correctBusStop = locationExistence.checkLocationExistence(busStopName, busStopCoordinates);

        if (!correctBusStop) {
            request.setAttribute("busStopError", "Wrong data, try again. ");
            request.setAttribute("hasError", "has-error");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/map.jsp");
            dispatcher.forward(request, response);

        } else {
            BusStopCoordinate coordinates = coordinatesGetter.getCoordinates(busStopName, busStopCoordinates);
            request.setAttribute("correctBusStop", correctBusStop);
            request.setAttribute("coordinates", coordinates);
            request.setAttribute("busStop", busStopName);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/map");
            dispatcher.forward(request, response);
        }


    }

}
