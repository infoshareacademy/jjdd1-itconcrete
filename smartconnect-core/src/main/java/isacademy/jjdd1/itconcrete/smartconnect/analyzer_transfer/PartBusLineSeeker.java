package isacademy.jjdd1.itconcrete.smartconnect.analyzer_transfer;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;

import java.util.ArrayList;
import java.util.List;

class PartBusLineSeeker {

    public List<BusLine> seekPartBusLine(List<BusLine> busLinesForSeeking, String busStopFromCheckedPart, String busStopFromAnotherPart) {

        List<BusLine> foundPartBusLines = new ArrayList<>();

        for (BusLine currentlyCheckedBusLine : busLinesForSeeking) {

            DirectLineChecker directLineChecker = new DirectLineChecker();

            boolean directLine = directLineChecker.checkIfLineIsDirect(currentlyCheckedBusLine, busStopFromAnotherPart);

            if (!directLine) {

                List<BusStopDeltas> deltasList = currentlyCheckedBusLine.getRoute().getDeltasList();
                for (BusStopDeltas currentlyCheckedBusStopDelta : deltasList) {

                    boolean sameBusStopName = currentlyCheckedBusStopDelta.getBusStopName().toLowerCase().equals(busStopFromCheckedPart.toLowerCase());
                    boolean ridesThroughBusStop = currentlyCheckedBusStopDelta.getTimeDifference() >= 0;

                    if (sameBusStopName && ridesThroughBusStop) {
                        foundPartBusLines.add(currentlyCheckedBusLine);
                    }
                }
            }
        }
        return foundPartBusLines;
    }

}