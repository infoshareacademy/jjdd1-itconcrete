package isacademy.jjdd1.itconcrete.smartconnect;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.*;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarEvent;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarParser;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarParserKasia;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.DisplayConnection;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.*;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App {


    public static void main(String[] args) throws Exception {


        ScheduleParser sp = new ScheduleParser();
        sp.loadData();

        ArrayList<Route> allRoutes = new ArrayList<Route>();
        allRoutes = sp.getArrayOfRoutes();

        ArrayList<BusLine> allBusLines = new ArrayList<BusLine>();
        allBusLines = sp.getArrayOfBusLines();

//        for (BusLine bl : allBusLines){
//            System.out.println("Departures for busline"+bl.getLineNumber()+"\n");
//            System.out.println(bl.getDepartures());
//        }
//
//
//        String startBusStop = "Niedźwiednik";
//        String endBusStop = "Potokowa";
//
//        for (Route route : allRoutes) {
//            if (route.containsStops(startBusStop, endBusStop)) {
//                int lenghtOfRoute = route.getAmountOfStops();
//                System.out.println(route.getLineNumber() + " direction of: " + route.getDirection() + " - " +
//                        route.getArrayOfStops().get(lenghtOfRoute - 1));
//            }
//        }


        BusLineSeeker busLineSeeker = new BusLineSeeker();
        MinutesToBusStops minutesToBusStops = new MinutesToBusStops();
        ConnectionSeeker connectionSeeker = new ConnectionSeeker();
        DisplayConnection displayConnection = new DisplayConnection();

        CalendarParserKasia calendarParserKasia = new CalendarParserKasia();
        List<CalendarEvent> calendarEventsList = calendarParserKasia.getEventList();
        // System.out.println(calendarEventsList);

        for (int i = 0; i < calendarEventsList.size(); i++) {

            System.out.println( "Connections for event number " + (i+1) + ": ");

            List<BusLine> busLineList = busLineSeeker.seekBusLine(calendarEventsList.get(i), allBusLines);

            List<LineRideTime> lineRideTimes = minutesToBusStops.calculateMinutesToBusStops(busLineList,
                    calendarEventsList.get(i).getFromBusStop(), calendarEventsList.get(i).getToBusStop());

            List<ResultConnection> resultConnections = connectionSeeker.seekConnection(lineRideTimes, calendarEventsList.get(i));

            for (ResultConnection resultConnection : resultConnections) {

                String textForEachResult = displayConnection.displayingConnection(resultConnection);
                System.out.println(textForEachResult);

            }

            if (resultConnections.size() == 0) {
                System.out.println("Sorry, there is no direct connection for this event. \n");
            }
        }


    }
}

