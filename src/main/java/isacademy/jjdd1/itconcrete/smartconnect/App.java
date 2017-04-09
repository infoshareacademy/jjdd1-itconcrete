package isacademy.jjdd1.itconcrete.smartconnect;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.*;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarEvent;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.DisplayConnection;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.*;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class App {


    public static void main(String[] args) throws Exception {

//        ScheduleParser sp = new ScheduleParser();
//        //HashMap<String,ArrayList> hashMapOfBusStops = new HashMap<String,ArrayList>();
//        HashMap<String, ArrayList> hashMapOfBusStops = sp.hashMapOfBusStops();
//
//        for (String key : hashMapOfBusStops.keySet()) {
//            System.out.println(key + hashMapOfBusStops.get(key));
//        }
//
//        ArrayList<String[]> oneSchedule = sp.scheduleParser("136");
//        String stop = oneSchedule.get(1)[3];
//        System.out.println("your stop:" + stop);
//
//        //Dane z kalendarza
//        String startBusStop = "Niedźwiednik";
//        String endBusStop = "Zabytkowa";
//
//
//        //Dane z mapy
//        ArrayList<String> busesAvailableOnStartBusStop = hashMapOfBusStops.get(startBusStop);
//        System.out.println("start stops: " + busesAvailableOnStartBusStop);
//        ArrayList<String> busesAvailableOnEndBusStop = hashMapOfBusStops.get(endBusStop);
//        System.out.println("end stops: " + busesAvailableOnEndBusStop);
//
//        ArrayList<String> possibleConnections = new ArrayList<String>();
//
//        for (int i = 0; i < busesAvailableOnStartBusStop.size(); i++) {
//            String currentBusLine = busesAvailableOnStartBusStop.get(i);
//            if (busesAvailableOnEndBusStop.contains(currentBusLine)) {
//                possibleConnections.add(currentBusLine);
//            }
//        }
//
//        System.out.println("Possible connections: " + possibleConnections);
//
//
////---------------------------------------How to use CalendarParser
//        CalendarParser cp = new CalendarParser();
//        cp.getConnectionData(1); // EventsConnectionNumber can be either 0 or 1, cause there are only 2 connections in a sampled Calendar file
//
//        System.out.println(cp.getConnectionData(0).getFromBusStop());
//        System.out.println(cp.getConnectionData(0).getToBusStop());
//        System.out.println(cp.getConnectionData(0).getArrivalTime());
//
//        System.out.println(cp.getConnectionData(1).getFromBusStop());
//        System.out.println(cp.getConnectionData(1).getToBusStop());
//        System.out.println(cp.getConnectionData(1).getArrivalTime());
//
////----------------------------------------


//        for (String bus : possibleConnections) {
//            sp.scheduleParser(bus);
//        }
//        sp.scheduleParser("136");

        //data mock

        DateTimeFormatter parser = DateTimeFormat.forPattern("yyyyMMdd'T'HHmmss'Z'");
        DateTime dateTime = parser.parseDateTime("20170408T090000Z");

        CalendarEvent[] calendarEvent = {new CalendarEvent("Cygańska Góra", "Suchanino", dateTime),
                new CalendarEvent("Suchanino", "Brętowo PKM", dateTime.plusHours(2))};

        List<BusStopDeltas> deltasList = new ArrayList<BusStopDeltas>();
        deltasList.add(new BusStopDeltas("Cygańska Góra", 0));
        deltasList.add(new BusStopDeltas("Nad Jarem - Zakosy", 2));
        deltasList.add(new BusStopDeltas("Suchanino", 3));
        deltasList.add(new BusStopDeltas("Kurpińskiego", 2));
        deltasList.add(new BusStopDeltas("Piecewska", 3));
        deltasList.add(new BusStopDeltas("Warneńska", 1));
        deltasList.add(new BusStopDeltas("Kolumba", 2));
        deltasList.add(new BusStopDeltas("Brętowo PKM", 1));

        Route route = new Route(1, deltasList, null);

        LocalTime[] departuresByBus = {
                new LocalTime("08:12"),
                new LocalTime("08:12"),
                new LocalTime("08:46"),
                new LocalTime("08:52"),
                new LocalTime("09:12"),
                new LocalTime("09:25"),
                new LocalTime("09:38"),
                new LocalTime("09:46"),
                new LocalTime("10:38"),
                new LocalTime("10:46"),
                new LocalTime("11:38"),
                new LocalTime("11:46"),
                new LocalTime("12:38"),
                new LocalTime("12:46")};


        BusLine busLine1 = new BusLine(131, route, departuresByBus);
        BusLine busLine2 = new BusLine(131, route, departuresByBus);

        BusLine[] busLines = {busLine1, busLine2};

        // end of data mock

        BusLineSeeker busLineSeeker = new BusLineSeeker();
        MinutesToBusStops minutesToBusStops = new MinutesToBusStops();
        ConnectionSeeker connectionSeeker = new ConnectionSeeker();
        DisplayConnection displayConnection = new DisplayConnection();

        for (int i = 0; i < calendarEvent.length; i++) {

            List<BusLine> busLineList = busLineSeeker.seekBusLine(calendarEvent[i], busLines);

            List<LineRideTime> lineRideTimes = minutesToBusStops.calculateMinutesToBusStops(busLineList,
                    calendarEvent[i].getFromBusStop(), calendarEvent[i].getToBusStop());

            List<ResultConnection> resultConnections = connectionSeeker.seekConnection(lineRideTimes, calendarEvent[i]);

            for (ResultConnection resultConnection : resultConnections) {

                String textForEachResult = displayConnection.displayingConnection(resultConnection);
                System.out.println(textForEachResult);

            }
        }
    }
}

