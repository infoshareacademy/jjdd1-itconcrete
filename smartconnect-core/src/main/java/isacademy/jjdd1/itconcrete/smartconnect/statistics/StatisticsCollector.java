package isacademy.jjdd1.itconcrete.smartconnect.statistics;

import isacademy.jjdd1.itconcrete.smartconnect.result.DirectResultConnection;
import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteDirectResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsCollector {

    public List<StatisticsData> getStatisticsData(List<CompleteDirectResult> completeDirectResultList) {

        Map<Integer, StatisticsData> statisticsCollection = new HashMap<>();

        for (CompleteDirectResult currentlyAnalyzedResult : completeDirectResultList) {
            List<DirectResultConnection> directResultConnectionList = currentlyAnalyzedResult.getDirectResultConnectionList();

            for (DirectResultConnection currentlyAnalyzedConnection :
                    directResultConnectionList) {

                Integer lineNumber = currentlyAnalyzedConnection.getLineNumber();

                if (statisticsCollection.containsKey(lineNumber)) {

                    StatisticsData statisticsData = statisticsCollection.get(lineNumber);
                    statisticsData.setCountedTimes(statisticsData.getCountedTimes() + 1);
                    statisticsCollection.put(lineNumber, statisticsData);

                } else {
                    statisticsCollection.put(lineNumber, new StatisticsData(lineNumber, 1));
                }
            }
        }

        List<StatisticsData> statisticsDataList = new ArrayList<>(statisticsCollection.values());

        statisticsDataList.sort((o1, o2) -> o2.getCountedTimes() - o1.getCountedTimes());

        return statisticsDataList;
    }
}
