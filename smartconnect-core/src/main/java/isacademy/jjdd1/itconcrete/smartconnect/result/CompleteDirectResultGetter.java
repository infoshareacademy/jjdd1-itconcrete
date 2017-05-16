package isacademy.jjdd1.itconcrete.smartconnect.result;

import isacademy.jjdd1.itconcrete.smartconnect.App;
import isacademy.jjdd1.itconcrete.smartconnect.analyzer_direct.BusLineSeeker;
import isacademy.jjdd1.itconcrete.smartconnect.analyzer_direct.ConnectionSeeker;
import isacademy.jjdd1.itconcrete.smartconnect.analyzer_direct.LineRideTime;
import isacademy.jjdd1.itconcrete.smartconnect.analyzer_direct.MinutesToBusStops;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarParser;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.database.BusLineStatistics;
import isacademy.jjdd1.itconcrete.smartconnect.database.BusStop;
import isacademy.jjdd1.itconcrete.smartconnect.database.HomeBusStop;
import isacademy.jjdd1.itconcrete.smartconnect.database.PromotedLine;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.LinePromoter;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.StatisticsCollector;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.StatisticsData;
import isacademy.jjdd1.itconcrete.smartconnect.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CompleteDirectResultGetter {

    private Logger LOGGER = LoggerFactory.getLogger(App.class);
    private static org.hibernate.Session session;


        public List<CompleteDirectResult> getCompleteResult (String homeBusStop, String timeOfLeavingHome, String
        timeOfArrivingHome, ArrayList < BusLine > allBusLines) throws IOException, URISyntaxException {

            MinutesToBusStops minutesToBusStops = new MinutesToBusStops();
            ConnectionSeeker connectionSeeker = new ConnectionSeeker();
            CalendarParser calendarParser = new CalendarParser();
            BusLineSeeker busLineSeeker = new BusLineSeeker();
            LinkedList<Journey> journeys = calendarParser.parseFileSortEventsAddHome(homeBusStop, timeOfLeavingHome, timeOfArrivingHome);

            List<CompleteDirectResult> completeDirectResultList = new ArrayList<>();

            for (int i = 0; i < journeys.size(); i++) {

                List<BusLine> foundBusLines = busLineSeeker.seekBusLine(journeys.get(i), allBusLines);
                List<LineRideTime> lineRideTimes = minutesToBusStops.calculateMinutesToBusStops(foundBusLines, journeys.get(i));
                List<DirectResultConnection> directResultConnectionList = connectionSeeker.seekConnection(lineRideTimes, journeys.get(i));
                directResultConnectionList = new LinePromoter(directResultConnectionList).putPromotedLinesFirstInAList();

                completeDirectResultList.add(new CompleteDirectResult(journeys.get(i).getStartLocation(),
                        journeys.get(i).getEndLocation(), journeys.get(i).getStartBusStop(),
                        journeys.get(i).getEndBusStop(), directResultConnectionList));
            }

            StatisticsCollector statisticsCollector = new StatisticsCollector();
            List<StatisticsData> stats = statisticsCollector.getStatisticsData(completeDirectResultList);

            LOGGER.trace("collected statistics {}", stats);
            session = HibernateUtil.getSessionFactory().openSession();

            for (int i = 0; i < journeys.size(); i++) {
                session.beginTransaction();
                session.save(new BusStop(journeys.get(i).getStartBusStop()));
                session.getTransaction().commit();
            }
            session.beginTransaction();
            session.save(new BusStop(journeys.get(journeys.size() - 1).getEndBusStop()));
            session.getTransaction().commit();

            for (StatisticsData currentStatisticData : stats) {
                session.beginTransaction();
                session.save(new BusLineStatistics(currentStatisticData.getLineNumber(), currentStatisticData.getCountedTimes()));
                session.getTransaction().commit();
            }
            session.beginTransaction();
            session.save(new HomeBusStop(homeBusStop));
            session.getTransaction().commit();


            return completeDirectResultList;
        }
    }

