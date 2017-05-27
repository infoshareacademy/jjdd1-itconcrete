package com.isacademy.jjdd1.itconcrete;

import isacademy.jjdd1.itconcrete.smartconnect.map.Coordinates;
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
import java.util.Set;

@WebServlet(urlPatterns = "/map")
public class MapServlet extends HttpServlet {

    @Inject
    CoordinatesSetter coordinatesSetter;

    @Inject
    LocationExistence locationExistence;

    @Inject
    CoordinatesGetter coordinatesGetter;

    Set<Coordinates> coordinates;

    @Override
    public void init() throws ServletException {

        coordinates = coordinatesSetter.setCoordinates();

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
        boolean correctBusStop = locationExistence.checkLocationExistence(busStopName, coordinates);

        if (!correctBusStop) {
            request.setAttribute("busStopError", "Wrong data, try again. ");
            request.setAttribute("hasError", "has-error");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/map.jsp");
            dispatcher.forward(request, response);

        } else {
            Coordinates coordinates = coordinatesGetter.getCoordinates(busStopName, this.coordinates);
            request.setAttribute("correctBusStop", correctBusStop);
            request.setAttribute("coordinates", coordinates);
            request.setAttribute("busStop", busStopName);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/map");
            dispatcher.forward(request, response);
        }


    }

}
