package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;

import java.util.List;

class DirectLineChecker {

    public boolean checkIfLineIsDirect(BusLine currentlyCheckedBusLine, String busStopFromAnotherPart) {

        boolean directLine = false;

        List<BusStopDeltas> deltasList = currentlyCheckedBusLine.getRoute().getDeltasList();

        for (BusStopDeltas currentlyCheckedBusStopDelta : deltasList) {

            boolean drivesThroughBusStop = currentlyCheckedBusStopDelta.getTimeDifference() >= 0;

            if (drivesThroughBusStop) {
                directLine = currentlyCheckedBusStopDelta.getBusStopName().toLowerCase().equals(busStopFromAnotherPart.toLowerCase());
            }

            if (directLine) {
                break;
            }
        }
        return directLine;
    }

}
