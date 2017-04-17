package isacademy.jjdd1.itconcrete.smartconnect.displayer;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.*;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.JourneyCreator;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompleteResultDisplayer {

    public void displayCompleteResult(String homeBusStop, String timeOfLeavingHome, String timeOfArrivingHome, ArrayList<BusLine> allBusLines) throws IOException {

        MinutesToBusStops minutesToBusStops = new MinutesToBusStops();
        ConnectionSeeker connectionSeeker = new ConnectionSeeker();
        DisplayConnection displayConnection = new DisplayConnection();

        BusLineSeeker busLineSeeker = new BusLineSeeker();
        JourneyCreator journeyCreator = new JourneyCreator();
        List<Journey> journeys = journeyCreator.getJourneysList(homeBusStop, timeOfLeavingHome, timeOfArrivingHome);

        for (int i = 0; i < journeys.size(); i++) {

            System.out.println("");

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
