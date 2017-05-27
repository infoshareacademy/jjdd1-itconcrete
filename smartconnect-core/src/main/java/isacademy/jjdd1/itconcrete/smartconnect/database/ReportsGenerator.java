package isacademy.jjdd1.itconcrete.smartconnect.database;


import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteDirectResult;
import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteTransferResult;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.StatisticsData;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.StopStatisticsData;

import java.util.List;

public class ReportsGenerator {

    private static List<CompleteDirectResult> completeDirectResultList;
    private static List<CompleteTransferResult> completeTransferResultList;

    private List<StatisticsData> lineStatistics;
    private List<StopStatisticsData> stopStatistics;

    public ReportsGenerator(List<CompleteDirectResult> completeDirectResultList,
                            List<CompleteTransferResult> completeTransferResultList) {
        this.completeDirectResultList = completeDirectResultList;
        this.completeTransferResultList = completeTransferResultList;
        generate();

    }

    private static void generate (){
        SearchResultStatisticsExtractor searchResultStatisticsExtractor =
                new SearchResultStatisticsExtractor(completeDirectResultList, completeTransferResultList);
    }
}
