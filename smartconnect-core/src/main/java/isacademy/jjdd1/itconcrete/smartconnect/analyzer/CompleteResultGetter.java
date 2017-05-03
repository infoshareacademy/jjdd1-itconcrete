package isacademy.jjdd1.itconcrete.smartconnect.analyzer;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.*;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarParser;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.LinePromoter;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.StatisticsCollector;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.StatisticsData;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CompleteResultGetter {

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
}
