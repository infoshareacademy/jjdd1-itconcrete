package isacademy.jjdd1.itconcrete.smartconnect.displayer;

import isacademy.jjdd1.itconcrete.smartconnect.result.DirectResultConnection;

import java.util.ArrayList;
import java.util.List;


public class LinePromoter {

    private ArrayList<Integer> promotedLines;
    private List<DirectResultConnection> directResultConnections;

    public LinePromoter(List<DirectResultConnection> directResultConnections) {
        promotedLines = new ArrayList<>();
        this.directResultConnections = directResultConnections;
    }

    public List<DirectResultConnection> putPromotedLinesFirstInAList(){
        promotedLines.add(157);
        promotedLines.add(116);

        List<DirectResultConnection> convertedList = new ArrayList<DirectResultConnection>();

        for (int i = 0; i < directResultConnections.size(); i++){
            int currentLineNumber = directResultConnections.get(i).getLineNumber();
            DirectResultConnection currentConnection = directResultConnections.get(i);
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

