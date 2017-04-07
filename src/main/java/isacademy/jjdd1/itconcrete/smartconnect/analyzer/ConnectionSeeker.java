package isacademy.jjdd1.itconcrete.smartconnect.analyzer;

import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarEvent;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusConnection;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.KasiaBusLine;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by katarzynadobrowolska on 01.04.2017.
 */
public class ConnectionSeeker {

    public int seekConnection(CalendarEvent calendarEvent, KasiaBusLine[] busConnections){

        String from = calendarEvent.getFromBusStop();
        String to = calendarEvent.getToBusStop();

        KasiaBusLine foundBusLine = null;

        for (KasiaBusLine busLine : busConnections) {
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
                    rideTime += busStopDeltas.getTime();
                }
                if (busStopDeltas.getName().equals(to)) {
                    rideTime += busStopDeltas.getTime();
                    break;
                }
            }
            System.out.println("Ride time: " + rideTime);
        }

        return 0;
    }

}
