package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;

import java.util.List;

class SetRepeatChecker {

    public boolean checkIfSetRepeats(List<BusLineSet> busLineSets, BusLine foundFirstBusLine, BusLine foundSecondBusLine) {

        boolean setRepeats = false;

        for (int i = 0; i < busLineSets.size(); i++) {

            if (foundFirstBusLine.getLineNumber() == busLineSets.get(i).getFirstBusLine().getLineNumber()) {

                for (i = 0; i < busLineSets.size(); i++) {

                    if (foundSecondBusLine.getLineNumber() == busLineSets.get(i).getSecondBusLine().getLineNumber()) {

                        setRepeats = true;
                    }
                }
            }
        }

        return setRepeats;
    }
}
