package isacademy.jjdd1.itconcrete.smartconnect.analyzer;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;

import java.util.ArrayList;
import java.util.List;

public class CheckingBusStopExistence {

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
