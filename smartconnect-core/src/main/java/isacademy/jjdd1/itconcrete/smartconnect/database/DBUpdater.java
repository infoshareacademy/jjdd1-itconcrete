package isacademy.jjdd1.itconcrete.smartconnect.database;


import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteDirectResult;
import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteTransferResult;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.LineStatisticsCollector;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.LineStatisticsData;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.StopStatisticsCollector;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.StopStatisticsData;

import java.util.ArrayList;
import java.util.List;

public class DBUpdater {

    private static List<CompleteDirectResult> completeDirectResultList;
    private static List<CompleteTransferResult> completeTransferResultList;

    private List<LineStatisticsData> lineStatistics = new ArrayList<>();
    private List<StopStatisticsData> stopStatistics = new ArrayList<>();

    public DBUpdater(List<CompleteDirectResult> completeDirectResultList,
                     List<CompleteTransferResult> completeTransferResultList) {
        this.completeDirectResultList = completeDirectResultList;
        this.completeTransferResultList = completeTransferResultList;
        generate();

    }

    private void generate (){

        lineStatistics = new LineStatisticsCollector().getLineStatisticsData(completeDirectResultList, completeTransferResultList);
        stopStatistics = new StopStatisticsCollector().getStopStatisticsData(completeDirectResultList, completeTransferResultList);

        BusLineStatisticsSaver busLineStatisticsSaver = new BusLineStatisticsSaver();

        for (LineStatisticsData lsd : lineStatistics) {
            busLineStatisticsSaver.updateBusLineStatistics(lsd.getLineNumber(), lsd.getCountedTimes());
        }

        BusStopStatisticsSaver busStopStatisticsSaver = new BusStopStatisticsSaver();

        for (StopStatisticsData ssd : stopStatistics) {
            busStopStatisticsSaver.updateBusStopStatistics(ssd.getBusStopName(), ssd.getCountedTimes());
        }
    }
}
