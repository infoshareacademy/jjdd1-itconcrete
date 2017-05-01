package isacademy.jjdd1.itconcrete.smartconnect.displayer;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.*;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarParser;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.CompleteResult;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.StatisticsCollector;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.StatisticsData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CompleteResultDisplayer {

    public List<CompleteResult> getCompleteResult(String homeBusStop, String timeOfLeavingHome, String timeOfArrivingHome, int maxAmountOfResults, ArrayList<BusLine> allBusLines) throws IOException, URISyntaxException {

        MinutesToBusStops minutesToBusStops = new MinutesToBusStops();
        ConnectionSeeker connectionSeeker = new ConnectionSeeker();
        CalendarParser calendarParser = new CalendarParser();
        BusLineSeeker busLineSeeker = new BusLineSeeker();
        LinkedList<Journey> journeys = calendarParser.parseFileSortEventsAddHome(homeBusStop, timeOfLeavingHome, timeOfArrivingHome);

        List<CompleteResult> completeResultList = new ArrayList<>();

        for (int i = 0; i < journeys.size(); i++) {

            List<BusLine> foundBusLines = busLineSeeker.seekBusLine(journeys.get(i), allBusLines);
            List<LineRideTime> lineRideTimes = minutesToBusStops.calculateMinutesToBusStops(foundBusLines, journeys.get(i));
            List<ResultConnection> resultConnectionList = connectionSeeker.seekConnection(lineRideTimes, journeys.get(i), maxAmountOfResults);
            resultConnectionList = new LinePromoter(resultConnectionList).putPromotedLinesFirstInAList();

            completeResultList.add(new CompleteResult(journeys.get(i).getStartLocation(),
                    journeys.get(i).getEndLocation(), journeys.get(i).getStartBusStop(),
                    journeys.get(i).getEndBusStop(), resultConnectionList));

            StatisticsCollector statisticsCollector = new StatisticsCollector();
            List<StatisticsData> stats = statisticsCollector.getStatisticsData(completeResultList);
        }
            return completeResultList;
    }


    public void displayCompleteResult(List<CompleteResult> completeResultList) throws IOException, URISyntaxException {

        DisplayConnection displayConnection = new DisplayConnection();

        for (int i = 0; i < completeResultList.size(); i++) {

            System.out.println("\nJourney number " + (i + 1) + ": ");

            String textForEachEvent = displayConnection.displayEventHeader(completeResultList.get(i));
            System.out.println(textForEachEvent);

            List<ResultConnection> resultConnections = completeResultList.get(i).getResultConnectionList();

            for (ResultConnection resultConnection : resultConnections) {
                String textForEachResult = displayConnection.displayingConnection(resultConnection);
                System.out.println(textForEachResult);
            }

            if (resultConnections.size() == 0) {
                System.out.println("Sorry, there is no direct connection for this event." + "\n");
            }
        }
    }

}
