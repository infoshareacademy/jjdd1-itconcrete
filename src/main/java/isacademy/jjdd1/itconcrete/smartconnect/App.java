package isacademy.jjdd1.itconcrete.smartconnect;


import isacademy.jjdd1.itconcrete.smartconnect.analyzer.ConnectionSeeker;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarEvent;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarParser;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.*;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Event;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class App
{


    public static void main( String[] args ) throws Exception {



        ScheduleParser sp = new ScheduleParser();
        //HashMap<String,ArrayList> hashMapOfBusStops = new HashMap<String,ArrayList>();
        HashMap<String, ArrayList> hashMapOfBusStops = sp.hashMapOfBusStops();

        for (String key : hashMapOfBusStops.keySet()) {
            System.out.println(key + hashMapOfBusStops.get(key));
        }

        ArrayList<String[]> oneSchedule = sp.scheduleParser("136");
        String stop = oneSchedule.get(1)[3];
        System.out.println("your stop:" + stop);



        //Dane z kalendarza
        String startBusStop = "Potokowa";
        String endBusStop = "Zabytkowa";


        //Dane z mapy
        ArrayList<String> busesAvailableOnStartBusStop = hashMapOfBusStops.get(startBusStop);
        System.out.println("start stops: " + busesAvailableOnStartBusStop);
        ArrayList<String> busesAvailableOnEndBusStop = hashMapOfBusStops.get(endBusStop);
        System.out.println("end stops: " + busesAvailableOnEndBusStop);

        ArrayList<String> possibleConnections = new ArrayList<String>();

        for (int i = 0; i < busesAvailableOnStartBusStop.size(); i++) {
            String currentBusLine = busesAvailableOnStartBusStop.get(i);
            if (busesAvailableOnEndBusStop.contains(currentBusLine)) {
                possibleConnections.add(currentBusLine);
            }
        }

        System.out.println("Possible connections: " + possibleConnections);
    }
}

//        for (String bus : possibleConnections) {
//            sp.scheduleParser(bus);
//        }
//        sp.scheduleParser("136");

        // data mock
        /*DateTimeFormatter parser = DateTimeFormat.forPattern("yyyyMMdd'T'HHmmss'Z'");
        DateTime dateTime = parser.parseDateTime("20170408T090000Z");

        CalendarEvent[] calendarEvent = {new CalendarEvent("Cygańska Góra","Suchanino", dateTime),
        new CalendarEvent("Suchanino", "Brętowo PKM", dateTime.plusHours(2))};

       // BusConnection = {new BusConnection(131, 1,  [0812, 0825, 0838, 0846, 0852, 0912, 0925, 0938, 0946, 0952)}

        List<BusStopDeltas> deltasList = new ArrayList<BusStopDeltas>();
        deltasList.add(new BusStopDeltas("Cygańska Góra", 1));
        deltasList.add(new BusStopDeltas("Nad Jarem - Zakosy", 2));
        deltasList.add(new BusStopDeltas("Suchanino", 3));
        deltasList.add(new BusStopDeltas("Kurpińskiego", 2));
        deltasList.add(new BusStopDeltas("Piecewska", 3));
        deltasList.add(new BusStopDeltas("Warneńska", 1));
        deltasList.add(new BusStopDeltas("Kolumba", 2));
        deltasList.add(new BusStopDeltas("Brętowo PKM",1 ));

        KasiaRoute route = new KasiaRoute(1, deltasList, null);

        LocalTime[] localTimes = {new LocalTime("08:12"),
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

        KasiaBusLine busLine = new KasiaBusLine(131, route, localTimes);
        KasiaBusLine[] busLines = {busLine};


        ScheduleParser sp = new ScheduleParser();
        sp.scheduleParser();

        String pathToBusConnections = "C:/aaa/bbb"; // change this to proper value
        String pathToCalendarEvents = "C:/aaa/bbb"; // change this to proper value


        ScheduleParser scheduleParser = new ScheduleParser();
        BusConnection busConnection[] = scheduleParser.parseDataFromPath(pathToBusConnections);

        CalendarParser calendarParser = new CalendarParser();
        CalendarEvent calendarEvent[] = calendarParser.parseDataFromPath(pathToCalendarEvents);

        ConnectionSeeker connectionSeeker = new ConnectionSeeker();

        for(int i=0; i<calendarEvent.length; i++) {
            CalendarEvent event = calendarEvent[i];
            int busNumber = connectionSeeker.seekConnection(event, busLines);
        }*/

