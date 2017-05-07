package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;

import java.util.ArrayList;
import java.util.List;

public class PartBusLineSeeker {

    public List<BusLine> seekPartBusLine(ArrayList<BusLine> busLinesForSeeking, String busStopFromCheckedPart, String busStopFromAnotherPart) {

        List<BusLine> foundPartBusLines = new ArrayList<>();

        for (BusLine currentlyCheckedBusLine : busLinesForSeeking) {

            StraightLineChecker straightLineChecker = new StraightLineChecker();

            boolean straightLine = straightLineChecker.checkIfIsStraightLine(currentlyCheckedBusLine, busStopFromAnotherPart);

            if (straightLine) {

                continue;

            } else {

                List<BusStopDeltas> deltasList = currentlyCheckedBusLine.getRoute().getDeltasList();
                for (BusStopDeltas currentlyCheckedBusStopDelta : deltasList) {

                    boolean sameBusStopName = currentlyCheckedBusStopDelta.getBusStopName().toLowerCase().equals(busStopFromCheckedPart.toLowerCase());
                    boolean drivesThroughBusStop = currentlyCheckedBusStopDelta.getTimeDifference() >= 0;

                    if (sameBusStopName && drivesThroughBusStop){
                        foundPartBusLines.add(currentlyCheckedBusLine);
                    }
                }
            }
        }
        return foundPartBusLines;
    }

}