package isacademy.jjdd1.itconcrete.smartconnect.analyzer;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarEvent;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.Minutes;

import java.util.ArrayList;
import java.util.List;

public class ConnectionSeeker {

    public List<ResultConnection> seekConnection(List<LineRideTime> lineRideTimes, CalendarEvent calendarEvent) {

        List<ResultConnection> resultConnections = new ArrayList<>();

        String fromBusStop = calendarEvent.getFromBusStop();
        String toBusStop = calendarEvent.getToBusStop();
        DateTime arrivalTime = calendarEvent.getArrivalTime();

        for (LineRideTime currentlyCheckedLine:lineRideTimes) {

            LocalTime departures[] = currentlyCheckedLine.getBusLine().getDepartures();

            int timeToReachFromBusStop = currentlyCheckedLine.getTimeToReachFromBusStop();
            int timeToReachToBusStop = currentlyCheckedLine.getTimeToReachToBusStop();

            for (int i = departures.length -1; i >= 0; i--) {

                LocalTime departureFromToBusStop = departures[i].plusMinutes(timeToReachToBusStop);

                LocalTime arrivalTimeOnly = new LocalTime(arrivalTime.getHourOfDay(), arrivalTime.getMinuteOfHour());

                int deltaMinutes = Minutes.minutesBetween(departureFromToBusStop, arrivalTimeOnly).getMinutes();

                if ( deltaMinutes >= 0) {

                    LocalTime departureFromFromBusStop = departures[i].plusMinutes(timeToReachFromBusStop);

                    ResultConnection resultConnection = new ResultConnection(currentlyCheckedLine.getLineNumber(),
                            departureFromFromBusStop, departureFromToBusStop, fromBusStop, toBusStop);

                    resultConnections.add(resultConnection);
                    break;
                }
            }
        }

        return resultConnections;
    }
}
