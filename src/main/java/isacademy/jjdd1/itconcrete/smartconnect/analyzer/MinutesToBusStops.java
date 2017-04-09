package isacademy.jjdd1.itconcrete.smartconnect.analyzer;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;
import org.joda.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MinutesToBusStops {

    public List<LineRideTime> calculateMinutesToBusStops(List<BusLine> foundBusLines, String fromBusStop, String toBusStop) {

        List<LineRideTime> minutesToBusStops = new ArrayList<>();

        for (BusLine currentlyCheckedBusLines : foundBusLines) {

            List<BusStopDeltas> deltasList = currentlyCheckedBusLines.getRoute().getDeltasList();

            int timeToReachFromBusStop = 0;
            for (BusStopDeltas busStopDeltas : deltasList) {
                timeToReachFromBusStop += busStopDeltas.getTimeDifference();
                if (busStopDeltas.getBusStopName().equals(fromBusStop)) {
                    break;
                }
            }

            int timeToReachToBusStop = 0;
            for (BusStopDeltas busStopDeltas : deltasList) {
                timeToReachToBusStop += busStopDeltas.getTimeDifference();
                if (busStopDeltas.getBusStopName().equals(toBusStop)) {
                    break;
                }
            }

            minutesToBusStops.add(new LineRideTime(currentlyCheckedBusLines.getLineNumber(),
                    timeToReachFromBusStop, timeToReachToBusStop, currentlyCheckedBusLines));

        }

        return minutesToBusStops;
    }

}
