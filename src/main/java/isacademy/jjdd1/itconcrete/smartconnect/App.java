package isacademy.jjdd1.itconcrete.smartconnect;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.*;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.JourneyCreator;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.DisplayConnection;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.*;
import java.util.ArrayList;
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

        JourneyCreator journeyCreator = new JourneyCreator();

        List<Journey> journeys = journeyCreator.getEventList();

//        for (Journey journey : journeys) {
//
//            System.out.println(journey.getStartBusStop() + "       " + journey.getEndBusStop() + "       " +
//                    journey.getStartLocation() + "       " + journey.getEndLocation() + "       " +
//                    DateAndTimeConverter.prettyFormatTime(journey.getStartOfDestinedEvent()) + "       "
//                    + DateAndTimeConverter.prettyFormatTime(journey.getEndOfFinishedEvent()));
//        }

        for (int i = 0; i < journeys.size(); i++) {

            System.out.println("Event number " + (i+1) + ": ");

            String textForEachEvent = displayConnection.displayEventHeader(journeys.get(i));
            System.out.println(textForEachEvent);

            List<BusLine> foundBusLines = busLineSeeker.seekBusLine(journeys.get(i), allBusLines);

            List<LineRideTime> lineRideTimes = minutesToBusStops.calculateMinutesToBusStops(foundBusLines, journeys.get(i));

            List<ResultConnection> resultConnections = connectionSeeker.seekConnection(lineRideTimes, journeys.get(i));

            for (ResultConnection resultConnection : resultConnections) {
                String textForEachResult = displayConnection.displayingConnection(resultConnection);
                System.out.println(textForEachResult);
            }

            if (resultConnections.size() == 0) {
                System.out.println("Sorry, there is no direct connection for this event.");
            }

            System.out.println("");
        }
    }
}

