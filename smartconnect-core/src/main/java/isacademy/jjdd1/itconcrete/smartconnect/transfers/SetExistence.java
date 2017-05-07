package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;

import java.util.List;

class SetExistence {

    public boolean checkSetExists(List<BusLineSet> busLineSets, BusLine foundFirstBusLine, BusLine foundSecondBusLine) {

        boolean setExists = false;

        for (int i = 0; i < busLineSets.size(); i++) {

            if (foundFirstBusLine.getLineNumber() == busLineSets.get(i).getFirstBusLine().getLineNumber()) {

                for (i = 0; i < busLineSets.size(); i++) {

                    if (foundSecondBusLine.getLineNumber() == busLineSets.get(i).getSecondBusLine().getLineNumber()) {

                        setExists = true;
                    }
                }
            }
        }

        return setExists;
    }
}
