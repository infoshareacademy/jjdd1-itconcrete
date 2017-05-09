package isacademy.jjdd1.itconcrete.smartconnect.displayer;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.*;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.BusLineStatistics1;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarParser;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.StatisticsCollector;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.StatisticsData;
import isacademy.jjdd1.itconcrete.smartconnect.util.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CompleteResultGetter {

    Logger LOGGER = LoggerFactory.getLogger(CompleteResultGetter.class);
    private static Session session;


    public List<CompleteResult> getCompleteResult(String homeBusStop, String timeOfLeavingHome, String timeOfArrivingHome, int maxAmountOfResults, ArrayList<BusLine> allBusLines) throws IOException, URISyntaxException {
        LOGGER.trace("called getCompleteResult({}, {}, {}, {} , ) ", homeBusStop, timeOfLeavingHome, timeOfArrivingHome, maxAmountOfResults);


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


        }

        StatisticsCollector statisticsCollector = new StatisticsCollector();
        List<StatisticsData> stats = statisticsCollector.getStatisticsData(completeResultList);
        LOGGER.trace("collected statistics {}", stats);
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        for(StatisticsData currentStatisticData: stats) {
            session.save(new BusLineStatistics1(currentStatisticData.getLineNumber(), currentStatisticData.getCountedTimes()));
        }
        session.getTransaction().commit();
        return completeResultList;
    }
}
