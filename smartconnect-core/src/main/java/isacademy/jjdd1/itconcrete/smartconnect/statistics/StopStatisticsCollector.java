package isacademy.jjdd1.itconcrete.smartconnect.statistics;

import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteDirectResult;
import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteTransferResult;
import isacademy.jjdd1.itconcrete.smartconnect.result.DirectResultConnection;
import isacademy.jjdd1.itconcrete.smartconnect.result.TransferResultConnection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StopStatisticsCollector {

    public List<StopStatisticsData> getStopStatisticsData(List<CompleteDirectResult> completeDirectResultList,
                                                          List<CompleteTransferResult> completeTransferResultList) {

        Map<String, StopStatisticsData> statisticsCollection = new HashMap<>();

        for (CompleteDirectResult currentlyAnalyzedResult : completeDirectResultList) {

            String stopName = currentlyAnalyzedResult.getStartBusStop();

            if (statisticsCollection.containsKey(stopName)) {

                StopStatisticsData stopStatisticsData = statisticsCollection.get(stopName);
                stopStatisticsData.setCountedTimes(stopStatisticsData.getCountedTimes() + 1);
                statisticsCollection.put(stopName, stopStatisticsData);

            } else {
                statisticsCollection.put(stopName, new StopStatisticsData(stopName, 1));
            }
        }


        for (CompleteTransferResult currentleAnalyzedResult : completeTransferResultList){
            List<TransferResultConnection> transferResultConnectionList = currentleAnalyzedResult.getTransferResultConnectionList();

            for(TransferResultConnection currentlyAnalyzedConnection : transferResultConnectionList){

                String middleStopName = currentlyAnalyzedConnection.getMidBusStop();

                if (statisticsCollection.containsKey(middleStopName)){

                    StopStatisticsData stopStatisticsData = statisticsCollection.get(middleStopName);
                    stopStatisticsData.setCountedTimes(stopStatisticsData.getCountedTimes() + 1);
                    statisticsCollection.put(middleStopName, stopStatisticsData);

                } else {
                    statisticsCollection.put(middleStopName,new StopStatisticsData(middleStopName, 1));

                }
            }
        }

        List<StopStatisticsData> statisticsDataList = new ArrayList<>(statisticsCollection.values());
        statisticsDataList.sort((o1, o2) -> o2.getCountedTimes() - o1.getCountedTimes());

        return statisticsDataList;
    }
}
