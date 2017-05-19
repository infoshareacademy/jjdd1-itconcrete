package isacademy.jjdd1.itconcrete.smartconnect.statistics;

import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteTransferResult;
import isacademy.jjdd1.itconcrete.smartconnect.result.TransferResultConnection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticCollectorForTransfer {

    public List<StatisticsData> getStatisticsDataTransfer(List<CompleteTransferResult> completeDirectResultList) {

        Map<Integer, StatisticsData> statisticsCollection = new HashMap<>();

        for (CompleteTransferResult currentlyAnalyzedResult : completeDirectResultList) {
            List<TransferResultConnection> directResultConnectionList = currentlyAnalyzedResult.getTransferResultConnectionList();

            for (TransferResultConnection currentlyAnalyzedConnection :
                    directResultConnectionList) {

                Integer lineNumber = currentlyAnalyzedConnection.getFirstLineNumber();

                addLine(statisticsCollection, lineNumber);

                Integer lineNumber2 = currentlyAnalyzedConnection.getSecondLineNumber();

                addLine(statisticsCollection, lineNumber2);
            }
        }

        List<StatisticsData> statisticsDataList = new ArrayList<>(statisticsCollection.values());

        statisticsDataList.sort((o1, o2) -> o2.getCountedTimes() - o1.getCountedTimes());

        return statisticsDataList;
    }

    public Map<Integer, StatisticsData> addLine(Map<Integer, StatisticsData> statisticsCollection,Integer lineNumber) {

        if (statisticsCollection.containsKey(lineNumber)) {

            StatisticsData statisticsData = statisticsCollection.get(lineNumber);
            statisticsData.setCountedTimes(statisticsData.getCountedTimes() + 1);
            statisticsCollection.put(lineNumber, statisticsData);

        } else {
            statisticsCollection.put(lineNumber, new StatisticsData(lineNumber, 1));
        }
        return statisticsCollection;
    }
}