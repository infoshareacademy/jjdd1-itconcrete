package isacademy.jjdd1.itconcrete.smartconnect;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.*;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarParser;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Event;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarParserAlternative;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.DisplayConnection;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        ScheduleParser sp = new ScheduleParser();
        sp.loadData();
        ArrayList<BusLine> allBusLines = sp.getArrayOfBusLines();

        BusLineSeeker busLineSeeker = new BusLineSeeker();
        MinutesToBusStops minutesToBusStops = new MinutesToBusStops();
        ConnectionSeeker connectionSeeker = new ConnectionSeeker();
        DisplayConnection displayConnection = new DisplayConnection();

        CalendarParserAlternative calendarParserAlternative = new CalendarParserAlternative();

        List<Journey> calendarEventsList = calendarParserAlternative.getEventList();

        for (int i = 0; i < calendarEventsList.size(); i++) {

            System.out.println("Event number " + (i+1) + ": ");

            String textForEachEvent = displayConnection.displayEventHeader(calendarEventsList.get(i));
            System.out.println(textForEachEvent);

            List<BusLine> foundBusLines = busLineSeeker.seekBusLine(calendarEventsList.get(i), allBusLines);

            List<LineRideTime> lineRideTimes = minutesToBusStops.calculateMinutesToBusStops(foundBusLines, calendarEventsList.get(i));

            List<ResultConnection> resultConnections = connectionSeeker.seekConnection(lineRideTimes, calendarEventsList.get(i));

            for (ResultConnection resultConnection : resultConnections) {
                String textForEachResult = displayConnection.displayingConnection(resultConnection);
                System.out.println(textForEachResult);
            }

            if (resultConnections.size() == 0) {
                System.out.println("Sorry, there is no direct connection for this event.");
            }

            System.out.println("");
        }
// How to use CalendarParser
//        CalendarParser cp = new CalendarParser();
//        System.out.println(cp.parseFileSortEventsAddHome("src/main/resources/kalendarz.ics"));


    }
}

