package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;

import java.util.List;

public class BusStopIndex {

    public int checkBusStopIndex(List<BusStopDeltas> busStopDeltas, String busStop) {

        int index = 0;
        int i = 0;

        for (i = 1; i < busStopDeltas.size(); i++) {

            //todo czy i=0?

            if (busStopDeltas.get(i).getBusStopName().toLowerCase().equals(busStop.toLowerCase())) {
                index = i;
            }
        }
        return index;
    }

}
