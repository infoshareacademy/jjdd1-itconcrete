package isacademy.jjdd1.itconcrete.smartconnect.database;


import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteDirectResult;
import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteTransferResult;
import isacademy.jjdd1.itconcrete.smartconnect.result.DirectResultConnection;
import isacademy.jjdd1.itconcrete.smartconnect.result.TransferResultConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchResultStatisticsExtractor {

    private List<CompleteDirectResult> completeDirectResultList;
    private List<CompleteTransferResult> completeTransferResultList;

    private List<String> busStops;
    private List<Integer> busLines;

    public SearchResultStatisticsExtractor(List<CompleteDirectResult> completeDirectResultList,
                                           List<CompleteTransferResult> completeTransferResultList) {
        this.completeDirectResultList = completeDirectResultList;
        this.completeTransferResultList = completeTransferResultList;
        busStops = extraxtListOfFoundStopNames();
        busLines = extractListOfFoundLineNumbers();
    }

    private List<String> extraxtListOfFoundStopNames(){
        List<String> direct = completeDirectResultList.stream().map(s -> s.getStartBusStop()).collect(Collectors.toList());
        List<String> transfer = completeTransferResultList.stream().map(s -> s.getStartBusStop()).collect(Collectors.toList());
        return Stream.concat(direct.stream(), transfer.stream()).collect(Collectors.toList());
    }

    private List<Integer> extractListOfFoundLineNumbers(){
        List<Integer> lineNumbers = new ArrayList<>();
        for (int i = 0; i < completeDirectResultList.size(); i++) {
            List<DirectResultConnection> directResultConnections = completeDirectResultList.get(i).getDirectResultConnectionList();
            lineNumbers.addAll(directResultConnections.stream().map(s -> s.getLineNumber()).collect(Collectors.toList()));
        }

        for (int i = 0; i < completeTransferResultList.size(); i++) {
            List<TransferResultConnection> transferResultConnections = completeTransferResultList.get(i).getTransferResultConnectionList();
            lineNumbers.addAll(transferResultConnections.stream().map(s -> s.getFirstLineNumber()).collect(Collectors.toList()));
            lineNumbers.addAll(transferResultConnections.stream().map(s -> s.getSecondLineNumber()).collect(Collectors.toList()));
        }
        return lineNumbers;
    }

    public List<String> getBusStops() {
        return busStops;
    }


    public List<Integer> getBusLines() {
        return busLines;
    }

}
