package isacademy.jjdd1.itconcrete.smartconnect.database;


import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteDirectResult;
import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteTransferResult;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.LineStatisticsCollector;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.LineStatisticsData;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.StopStatisticsCollector;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.StopStatisticsData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class DBUpdater {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBUpdater.class);

    private static List<CompleteDirectResult> completeDirectResultList;
    private static List<CompleteTransferResult> completeTransferResultList;

    private static List<LineStatisticsData> lineStatistics = new ArrayList<>();
    private static List<StopStatisticsData> stopStatistics = new ArrayList<>();

    public DBUpdater(List<CompleteDirectResult> completeDirectResultList,
                     List<CompleteTransferResult> completeTransferResultList) {
        this.completeDirectResultList = completeDirectResultList;
        this.completeTransferResultList = completeTransferResultList;
        LOGGER.info("Starting to generate update, results preset.");
        generate();
    }



    private static void generate (){

        LOGGER.info("I am generating - inside generate function");

        lineStatistics = new LineStatisticsCollector().getLineStatisticsData(completeDirectResultList, completeTransferResultList);
        stopStatistics = new StopStatisticsCollector().getStopStatisticsData(completeDirectResultList, completeTransferResultList);

        LOGGER.info("line stats size" + lineStatistics.size());
        LOGGER.info("stop stats size" + stopStatistics.size());

        BusLineStatisticsSaver busLineStatisticsSaver = new BusLineStatisticsSaver();

        for (LineStatisticsData lsd : lineStatistics) {
            LOGGER.info("I am in lsd ;-)");
            LOGGER.info(lsd.getLineNumber() + " " + lsd.getCountedTimes());
            busLineStatisticsSaver.updateBusLineStatistics(lsd.getLineNumber(), lsd.getCountedTimes());
        }

        BusStopStatisticsSaver busStopStatisticsSaver = new BusStopStatisticsSaver();

        for (StopStatisticsData ssd : stopStatistics) {
            LOGGER.info("I am in ssd");
            busStopStatisticsSaver.updateBusStopStatistics(ssd.getBusStopName(), ssd.getCountedTimes());
        }
    }
}
