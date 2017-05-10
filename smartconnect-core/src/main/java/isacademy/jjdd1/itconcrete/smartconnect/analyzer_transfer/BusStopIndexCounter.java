package isacademy.jjdd1.itconcrete.smartconnect.analyzer_transfer;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;

import java.util.List;

class BusStopIndexCounter {

    public int countBusStopIndex(List<BusStopDeltas> busStopDeltas, String busStop) {

        int index = 0;

        for (int i = 0; i < busStopDeltas.size()-1; i++) {

            boolean busStopNamesIdentical = busStopDeltas.get(i).getBusStopName().toLowerCase().equals(busStop.toLowerCase());
            boolean lineRidesBus = busStopDeltas.get(i).getTimeDifference() >= 0;

            if (busStopNamesIdentical && lineRidesBus) {
                index = i;
            }
        }
        return index;
    }

}
