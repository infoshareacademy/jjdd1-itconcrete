package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;

import java.util.List;

public class BusLineIndex {

    public boolean checkAddingToList(List<BusLineSet> busLineSets, BusLine foundFirstBusLine, BusLine foundSecondBusLine) {

        int indexFirst = -1;

        for (int i = 0; i < busLineSets.size(); i++) {

            if (foundFirstBusLine.getLineNumber() == busLineSets.get(i).getFirstBusLine().getLineNumber()) {
                indexFirst = i;
            }
        }

        int indexSecond = -1;

        for (int i = 0; i < busLineSets.size(); i++) {

            if (foundSecondBusLine.getLineNumber() == busLineSets.get(i).getSecondBusLine().getLineNumber()) {
                indexSecond = i;
            }
        }

        boolean condition1 = (foundFirstBusLine.getLineNumber() != foundSecondBusLine.getLineNumber());
        boolean condition2 = indexFirst != indexSecond;

        boolean addsToList = condition1 && condition2;

        return addsToList;
    }
}
