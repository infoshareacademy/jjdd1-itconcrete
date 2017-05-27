package isacademy.jjdd1.itconcrete.smartconnect.statistics;

import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteDirectResult;
import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteTransferResult;
import isacademy.jjdd1.itconcrete.smartconnect.result.DirectResultConnection;
import isacademy.jjdd1.itconcrete.smartconnect.result.TransferResultConnection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineStatisticsCollector {

    public List<LineStatisticsData> getLineStatisticsData(List<CompleteDirectResult> completeDirectResultList,
                                                          List<CompleteTransferResult> completeTransferResultList) {

        Map<Integer, LineStatisticsData> statisticsCollection = new HashMap<>();

        for (CompleteDirectResult currentlyAnalyzedResult : completeDirectResultList) {
            List<DirectResultConnection> directResultConnectionList = currentlyAnalyzedResult.getDirectResultConnectionList();

            for (DirectResultConnection currentlyAnalyzedConnection :
                    directResultConnectionList) {

                Integer lineNumber = currentlyAnalyzedConnection.getLineNumber();

                if (statisticsCollection.containsKey(lineNumber)) {

                    LineStatisticsData lineStatisticsData = statisticsCollection.get(lineNumber);
                    lineStatisticsData.setCountedTimes(lineStatisticsData.getCountedTimes() + 1);
                    statisticsCollection.put(lineNumber, lineStatisticsData);

                } else {
                    statisticsCollection.put(lineNumber, new LineStatisticsData(lineNumber, 1));
                }
            }
        }

        for (CompleteTransferResult currentleAnalyzedResult : completeTransferResultList){
            List<TransferResultConnection> transferResultConnectionList = currentleAnalyzedResult.getTransferResultConnectionList();

            for(TransferResultConnection currentlyAnalyzedConnection : transferResultConnectionList){

                Integer firstLineNumber = currentlyAnalyzedConnection.getFirstLineNumber();
                Integer secondLineNumber = currentlyAnalyzedConnection.getSecondLineNumber();

                if (statisticsCollection.containsKey(firstLineNumber)){

                    LineStatisticsData lineStatisticsData = statisticsCollection.get(firstLineNumber);
                    lineStatisticsData.setCountedTimes(lineStatisticsData.getCountedTimes() + 1);
                    statisticsCollection.put(firstLineNumber, lineStatisticsData);

                } else if (statisticsCollection.containsKey(secondLineNumber)){

                    LineStatisticsData lineStatisticsData = statisticsCollection.get(secondLineNumber);
                    lineStatisticsData.setCountedTimes(lineStatisticsData.getCountedTimes() + 1);
                    statisticsCollection.put(secondLineNumber, lineStatisticsData);

                } else {

                    statisticsCollection.put(firstLineNumber,new LineStatisticsData(firstLineNumber, 1));
                    statisticsCollection.put(secondLineNumber,new LineStatisticsData(secondLineNumber, 1));
                }
            }
        }

        List<LineStatisticsData> statisticsDataList = new ArrayList<>(statisticsCollection.values());
        statisticsDataList.sort((o1, o2) -> o2.getCountedTimes() - o1.getCountedTimes());

        return statisticsDataList;
    }
}
