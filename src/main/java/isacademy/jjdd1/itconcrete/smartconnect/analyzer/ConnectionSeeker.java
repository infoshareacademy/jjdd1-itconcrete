package isacademy.jjdd1.itconcrete.smartconnect.analyzer;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.Minutes;
import java.util.ArrayList;
import java.util.List;

public class ConnectionSeeker {

    public List<ResultConnection> seekConnection(List<LineRideTime> lineRideTimes, Journey journey) {

        List<ResultConnection> resultConnections = new ArrayList<>();

        String startBusStop = journey.getStartBusStop();
        String endBusStop = journey.getEndBusStop();
        DateTime startOfDestinedEvent = journey.getStartOfDestinedEvent();

        for (LineRideTime currentlyCheckedLine:lineRideTimes) {

            List<LocalTime> departures = currentlyCheckedLine.getBusLine().getDepartures();

            int timeToReachStartBusStop = currentlyCheckedLine.getTimeToReachStartBusStop();
            int timeToReachEndBusStop = currentlyCheckedLine.getTimeToReachEndBusStop();

            for (int i = departures.size() -1; i >= 0; i--) {

                LocalTime departureFromEndBusStop = departures.get(i).plusMinutes(timeToReachEndBusStop);

                LocalTime startOfDestinedEventTimeOnly = DateAndTimeConverter.dateTimeToLocalTime(startOfDestinedEvent);

                int deltaMinutes = Minutes.minutesBetween(departureFromEndBusStop, startOfDestinedEventTimeOnly).getMinutes();

                if ( deltaMinutes >= 0) {

                    LocalTime departureFromStartBusStop = departures.get(i).plusMinutes(timeToReachStartBusStop);

                    ResultConnection resultConnection = new ResultConnection(currentlyCheckedLine.getLineNumber(),
                            departureFromStartBusStop, departureFromEndBusStop, startBusStop, endBusStop);

                    resultConnections.add(resultConnection);
                    break;
                }
            }
        }

        return resultConnections;
    }
}
