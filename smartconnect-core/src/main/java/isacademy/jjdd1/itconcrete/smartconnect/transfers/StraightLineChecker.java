package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;

import java.util.List;

public class StraightLineChecker {

    public boolean checkIfIsStraightLine(BusLine currentlyCheckedBusLine, String busStopFromAnotherPart) {

        boolean straightLine = false;

        List<BusStopDeltas> deltasList = currentlyCheckedBusLine.getRoute().getDeltasList();

        for (BusStopDeltas currentlyCheckedBusStopDelta : deltasList) {
            straightLine = currentlyCheckedBusStopDelta.getBusStopName().toLowerCase().equals(busStopFromAnotherPart.toLowerCase());

            if (straightLine) {
                break;
            }
        }
        return false; // fixme bad condition - gives 0 results
    }

}
