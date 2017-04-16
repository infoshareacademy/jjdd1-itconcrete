package isacademy.jjdd1.itconcrete.smartconnect.analyzer;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;
import java.util.ArrayList;
import java.util.List;

public class MinutesToBusStops {

    public List<LineRideTime> calculateMinutesToBusStops(List<BusLine> foundBusLines, Journey journey) {

        List<LineRideTime> minutesToBusStops = new ArrayList<>();

        String startBusStop = journey.getStartBusStop();
        String endBusStop = journey.getEndBusStop();

        for (BusLine currentlyCheckedBusLines : foundBusLines) {

//            List<BusStopDeltas> deltasList = currentlyCheckedBusLines.getRoute().getDeltasList();

//            int timeToReachStartBusStop;
//            timeToReachStartBusStop = calculateTimeToReachBusStop(startBusStop, deltasList);
//
//            int timeToReachToBusStop;
//            timeToReachToBusStop = calculateTimeToReachBusStop(endBusStop, deltasList);
//
//            minutesToBusStops.add(new LineRideTime(currentlyCheckedBusLines.getLineNumber(),
//                    timeToReachStartBusStop, timeToReachToBusStop, currentlyCheckedBusLines));
        }
        return minutesToBusStops;
    }

    private int calculateTimeToReachBusStop (String busStop, List<BusStopDeltas> deltasList) {

        int timeToReachBusStop = 0;
        for (BusStopDeltas busStopDeltas : deltasList) {
            timeToReachBusStop += busStopDeltas.getTimeDifference();
            if (busStopDeltas.getBusStopName().equals(busStop)) {
                break;
            }
        }
        return timeToReachBusStop;
    }
}
