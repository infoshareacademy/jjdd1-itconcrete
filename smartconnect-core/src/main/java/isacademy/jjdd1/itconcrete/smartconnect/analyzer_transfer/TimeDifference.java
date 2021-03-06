package isacademy.jjdd1.itconcrete.smartconnect.analyzer_transfer;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;

import java.util.List;

class TimeDifference {

    public int calculateTimeDifference(String busStop, List<BusStopDeltas> deltasList) {

        int timeDifference = 0;
        for (BusStopDeltas busStopDeltas : deltasList) {
            if (busStopDeltas.getTimeDifference() >= 0) {
                timeDifference += busStopDeltas.getTimeDifference();
            }

            if (busStopDeltas.getBusStopName().toLowerCase().equals(busStop.toLowerCase())) {
                break;
            }
        }
        return timeDifference;
    }
}
