package isacademy.jjdd1.itconcrete.smartconnect.analyzer_transfer;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;

import java.util.List;

class SetExistence {

    public boolean checkSetExists(List<BusLineSet> busLineSets, BusLine foundFirstBusLine, BusLine foundSecondBusLine) {

        boolean setExists = false;

        for (int i = 0; i < busLineSets.size(); i++) {

            if (foundFirstBusLine == busLineSets.get(i).getFirstBusLine()) {

                for (i = 0; i < busLineSets.size(); i++) {

                    if (foundSecondBusLine == busLineSets.get(i).getSecondBusLine()) {

                        setExists = true;
                    }
                }
            }
        }

        return setExists;
    }
}
