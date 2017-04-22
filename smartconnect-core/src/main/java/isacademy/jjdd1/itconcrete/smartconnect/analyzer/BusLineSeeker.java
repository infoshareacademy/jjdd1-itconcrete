package isacademy.jjdd1.itconcrete.smartconnect.analyzer;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;

import java.util.ArrayList;
import java.util.List;

public class BusLineSeeker {

    public List<BusLine> seekBusLine(Journey journeyForSeeking, ArrayList<BusLine> busLinesForSeeking) {

        List<BusLine> foundBusLines = new ArrayList<>();
        String startBusStop = journeyForSeeking.getStartBusStop();
        String endBusStop = journeyForSeeking.getEndBusStop();
        boolean foundStartBusStop;
        boolean foundEndBusStop;

        for (BusLine currentlyCheckedBusLine : busLinesForSeeking) {

            List<BusStopDeltas> deltasList = currentlyCheckedBusLine.getRoute().getDeltasList();
            foundStartBusStop = false;
            foundEndBusStop = false;

            for (BusStopDeltas currentlyCheckedBusStopDelta : deltasList) {
                if (currentlyCheckedBusStopDelta.getBusStopName().toLowerCase().equals(startBusStop.toLowerCase())
                        && currentlyCheckedBusStopDelta.getTimeDifference() >= 0) {
                    foundStartBusStop = true;
                }

                if (foundStartBusStop && currentlyCheckedBusStopDelta.getBusStopName().toLowerCase().equals(endBusStop.toLowerCase())
                        && currentlyCheckedBusStopDelta.getTimeDifference() >= 0) {
                    foundEndBusStop = true;
                }
            }
            if (foundStartBusStop && foundEndBusStop) {
                foundBusLines.add(currentlyCheckedBusLine);
            }
        }

        return foundBusLines;
    }
    public boolean busStopExistence(String busStop, ArrayList<BusLine> busLinesForSeeking) {

        boolean busStopExistence = false;

        for (BusLine currentlyCheckedBusLine : busLinesForSeeking) {

            List<BusStopDeltas> deltasList = currentlyCheckedBusLine.getRoute().getDeltasList();

            for (BusStopDeltas currentlyCheckedBusStopDelta : deltasList) {

                if (currentlyCheckedBusStopDelta.getBusStopName().toLowerCase().equals(busStop.toLowerCase())
                        && currentlyCheckedBusStopDelta.getTimeDifference() >= 0) {
                    busStopExistence = true;
                }
            }
        }
        return busStopExistence;
    }
}
