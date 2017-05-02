package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;
import java.util.ArrayList;
import java.util.List;

public class PartBusLineSeeker {

    public List<BusLine> seekPartBusLine(ArrayList<BusLine> busLinesForSeeking, String busStop) {

        List<BusLine> foundPartBusLines = new ArrayList<>();

        for (BusLine currentlyCheckedBusLine : busLinesForSeeking) {
            List<BusStopDeltas> deltasList = currentlyCheckedBusLine.getRoute().getDeltasList();
            for (BusStopDeltas currentlyCheckedBusStopDelta : deltasList) {
                if (currentlyCheckedBusStopDelta.getBusStopName().toLowerCase().equals(busStop.toLowerCase())
                        && (currentlyCheckedBusStopDelta.getTimeDifference() >= 0)) {
                    foundPartBusLines.add(currentlyCheckedBusLine);
                }
            }
        }
        return foundPartBusLines;
    }
}