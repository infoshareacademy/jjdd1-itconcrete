package isacademy.jjdd1.itconcrete.smartconnect.displayer;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.*;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarParser;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;

import isacademy.jjdd1.itconcrete.smartconnect.forwebapp.ResultForWebApp;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
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

    private static final Marker RESULT_DISPLAYER_MARKER = MarkerFactory.getMarker("RESULT DISPLAYER");
    private static final Logger LOGGER = LoggerFactory.getLogger(CompleteResultDisplayer.class);
    public List<ResultForWebApp> resultForWebAppList;

    public List<ResultForWebApp> getAllResultConnections() {

        return resultForWebAppList;
    }

    public void displayCompleteResult(String homeBusStop, String timeOfLeavingHome, String timeOfArrivingHome, int maxAmountOfResults, ArrayList<BusLine> allBusLines) throws IOException, URISyntaxException {

        MinutesToBusStops minutesToBusStops = new MinutesToBusStops();
        ConnectionSeeker connectionSeeker = new ConnectionSeeker();
        DisplayConnection displayConnection = new DisplayConnection();

        BusLineSeeker busLineSeeker = new BusLineSeeker();

        CalendarParser calendarParser = new CalendarParser();
        LinkedList<Journey> journeys = calendarParser.parseFileSortEventsAddHome(homeBusStop, timeOfLeavingHome, timeOfArrivingHome);

        resultForWebAppList = new ArrayList<>();

        for (int i = 0; i < journeys.size(); i++) {

            LOGGER.trace(RESULT_DISPLAYER_MARKER, "\nJourney number " + (i+1) + ": ");

            String textForEachEvent = displayConnection.displayEventHeader(journeys.get(i));
            LOGGER.trace(RESULT_DISPLAYER_MARKER, textForEachEvent);

            List<BusLine> foundBusLines = busLineSeeker.seekBusLine(journeys.get(i), allBusLines);
            List<LineRideTime> lineRideTimes = minutesToBusStops.calculateMinutesToBusStops(foundBusLines, journeys.get(i));
            List<ResultConnection> resultConnections = connectionSeeker.seekConnection(lineRideTimes, journeys.get(i), maxAmountOfResults);
            resultConnections = new LinePromoter(resultConnections).putPromotedLinesFirstInAList();

            resultForWebAppList.add(new ResultForWebApp(journeys.get(i).getStartLocation(),
                    journeys.get(i).getEndLocation(), journeys.get(i).getStartBusStop(),
                    journeys.get(i).getEndBusStop(), resultConnections));

            for (ResultConnection resultConnection : resultConnections) {
                String textForEachResult = displayConnection.displayingConnection(resultConnection);
                LOGGER.trace(RESULT_DISPLAYER_MARKER, textForEachResult);
            }

            if (resultConnections.size() == 0) {
                LOGGER.warn(RESULT_DISPLAYER_MARKER,"Sorry, there is no direct connection for this event." + "\n");
            }
        }
    }
}
