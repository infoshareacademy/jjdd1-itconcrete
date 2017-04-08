package isacademy.jjdd1.itconcrete.smartconnect.analyzer;

import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarEvent;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;

import java.util.List;

/**
 * Created by katarzynadobrowolska on 01.04.2017.
 */
public class ConnectionSeeker {

    public int seekConnection(CalendarEvent calendarEvent, BusLine[] busConnections){

        String from = calendarEvent.getFromBusStop();
        String to = calendarEvent.getToBusStop();

        BusLine foundBusLine = null;

        for (BusLine busLine : busConnections) {
            boolean foundFrom = false, foundTo = false;
            List<BusStopDeltas> deltasList = busLine.getRoute().getDeltasList();
            for (BusStopDeltas busStopDeltas : deltasList) {
                if (busStopDeltas.getName().equals(from)) {
                    foundFrom = true;
                }
                if (busStopDeltas.getName().equals(to)) {
                    foundTo = true;
                }
            }
            if (foundFrom && foundTo) {
                foundBusLine = busLine;
            }
        }


        if (foundBusLine != null) {
            System.out.println("Found bus line: " + foundBusLine.getLineNumber());

            List<BusStopDeltas> deltasList = foundBusLine.getRoute().getDeltasList();
            int rideTime = 0;
            boolean foundStationFrom = false;
            for (BusStopDeltas busStopDeltas : deltasList) {
                if (busStopDeltas.getName().equals(from)) {
                    foundStationFrom = true;
                }
                if (foundStationFrom) {
                    rideTime += busStopDeltas.getTimeDifference();
                }
                if (busStopDeltas.getName().equals(to)) {
                    rideTime += busStopDeltas.getTimeDifference();
                    break;
                }
            }
            System.out.println("Ride time: " + rideTime);
        }

        return 0;
    }

}
