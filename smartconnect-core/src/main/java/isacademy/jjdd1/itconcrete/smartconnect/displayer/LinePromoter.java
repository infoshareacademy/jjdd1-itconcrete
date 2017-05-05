package isacademy.jjdd1.itconcrete.smartconnect.displayer;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.ResultConnection;


import java.util.ArrayList;
import java.util.List;


public class LinePromoter {


    public ArrayList<Integer> promotedLines;
    private List<ResultConnection> resultConnections;

    public LinePromoter(List<ResultConnection> resultConnections) {


        promotedLines = new ArrayList<>();
        this.resultConnections = resultConnections;
    }

    public List<ResultConnection> putPromotedLinesFirstInAList(){
        promotedLines.add(157);
        promotedLines.add(116);


        List<ResultConnection> convertedList = new ArrayList<ResultConnection>();

        for (int i = 0; i < resultConnections.size(); i++){
            int currentLineNumber = resultConnections.get(i).getLineNumber();
            ResultConnection currentConnection = resultConnections.get(i);
            if (promotedLines.contains(currentLineNumber) && !convertedList.contains(currentConnection)){
                convertedList.add(0, currentConnection);
            } else {
                convertedList.add(currentConnection);
            }
        }
        return convertedList;
    }
    //TODO Function to get the list of promoted lines, now the type of source is unknown and values are given manually
}

