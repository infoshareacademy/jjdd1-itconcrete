package isacademy.jjdd1.itconcrete.smartconnect.analyzer;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import org.joda.time.LocalTime;
import org.joda.time.Minutes;
import java.util.ArrayList;
import java.util.List;

public class ConnectionSeeker {

    public List<ResultConnection> seekConnection(List<LineRideTime> lineRideTimes, Journey journey) {

        List<ResultConnection> resultConnections = new ArrayList<>();

        String startBusStop = journey.getStartBusStop();
        String endBusStop = journey.getEndBusStop();
        LocalTime startOfDestinedEvent = journey.getStartOfDestinedEvent();
        LocalTime endOfFinishedEvent = journey.getEndOfFinishedEvent();

        for (LineRideTime currentlyCheckedLine:lineRideTimes) {

            List<LocalTime> departures = currentlyCheckedLine.getBusLine().getDepartures();

            int timeToReachStartBusStop = currentlyCheckedLine.getTimeToReachStartBusStopFromFirstBusStop();
            int timeToReachEndBusStop = currentlyCheckedLine.getTimeToReachEndBusStopFromFirstBusStop();

            for (int i = departures.size() -1; i >= 0; i--) {

                LocalTime departureToEndBusStop = departures.get(i).plusMinutes(timeToReachEndBusStop);
                LocalTime departureToStartBusStop = departures.get(i).plusMinutes(timeToReachStartBusStop);

                int deltaMinutesBetweenDepartureToEndBusStopAndStartOfDestinedEvent = Minutes.minutesBetween(departureToEndBusStop, startOfDestinedEvent).getMinutes();
                int deltaMinutesBetweenDepartureToStartBusStopAndEndOfPreviousEvent = Minutes.minutesBetween(endOfFinishedEvent, departureToStartBusStop).getMinutes();

                if ( deltaMinutesBetweenDepartureToEndBusStopAndStartOfDestinedEvent >= 0 && deltaMinutesBetweenDepartureToStartBusStopAndEndOfPreviousEvent>= 0) {

                    ResultConnection resultConnection = new ResultConnection(currentlyCheckedLine.getLineNumber(),
                            departureToStartBusStop, departureToEndBusStop, startBusStop, endBusStop);

                    resultConnections.add(resultConnection);
                    break;
                }
            }
        }
        return resultConnections;
    }
}
