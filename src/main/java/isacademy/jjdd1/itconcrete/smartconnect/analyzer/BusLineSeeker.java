package isacademy.jjdd1.itconcrete.smartconnect.analyzer;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarEvent;

import java.util.ArrayList;
import java.util.List;

public class BusLineSeeker {

    public List<BusLine> seekBusLine(CalendarEvent eventForSeeking, ArrayList<BusLine> busForSeeking) {

        List<BusLine> foundBusLines = new ArrayList<>();
        String fromBusStop = eventForSeeking.getFromBusStop();
        String toBusStop = eventForSeeking.getToBusStop();
        boolean foundBusStopFrom = false;
        boolean foundBusStopTo = false;

        for (BusLine currentlyChceckdBusLine : busForSeeking) {

            List<BusStopDeltas> deltasList = currentlyChceckdBusLine.getRoute().getDeltasList();
            foundBusStopFrom = false;
            foundBusStopTo = false;

            for (BusStopDeltas currentlyCheckedBusStopDelta : deltasList) {
                if (currentlyCheckedBusStopDelta.getBusStopName().equals(fromBusStop)) {
                    foundBusStopFrom = true;
                }
                if (foundBusStopFrom && currentlyCheckedBusStopDelta.getBusStopName().equals(toBusStop) ) {
                    foundBusStopTo = true;
                }
            }
            if (foundBusStopFrom && foundBusStopTo) {
                foundBusLines.add(currentlyChceckdBusLine);
            }
        }

        return foundBusLines;
    }
}
