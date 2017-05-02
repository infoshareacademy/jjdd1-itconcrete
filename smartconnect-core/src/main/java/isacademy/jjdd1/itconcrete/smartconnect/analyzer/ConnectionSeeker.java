package isacademy.jjdd1.itconcrete.smartconnect.analyzer;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConnectionSeeker {

    public List<ResultConnection> seekConnection(List<LineRideTime> lineRideTimes, Journey journey, int askForMaxAmountOfResults) {

        List<ResultConnection> resultConnections = new ArrayList<>();

        String startBusStop = journey.getStartBusStop();
        String endBusStop = journey.getEndBusStop();
        LocalTime startOfDestinedEvent = journey.getStartOfDestinedEvent();
        LocalTime endOfFinishedEvent = journey.getEndOfFinishedEvent();

        for (LineRideTime currentlyCheckedLine:lineRideTimes) {

            List<LocalTime> departures = currentlyCheckedLine.getBusLine().getDeparturesWeekdays();

            int timeToReachStartBusStop = currentlyCheckedLine.getTimeToReachStartBusStopFromFirstBusStop();
            int timeToReachEndBusStop = currentlyCheckedLine.getTimeToReachEndBusStopFromFirstBusStop();

            for (int i = departures.size() -1; i >= 0; i--) {

                LocalTime departureToEndBusStop = departures.get(i).plusMinutes(timeToReachEndBusStop);
                LocalTime departureToStartBusStop = departures.get(i).plusMinutes(timeToReachStartBusStop);

                long deltaMinutesBetweenDepartureToEndBusStopAndStartOfDestinedEvent = ChronoUnit.MINUTES.between(departureToEndBusStop, startOfDestinedEvent);
                long deltaMinutesBetweenDepartureToStartBusStopAndEndOfPreviousEvent = ChronoUnit.MINUTES.between(endOfFinishedEvent, departureToStartBusStop);

                if ( deltaMinutesBetweenDepartureToEndBusStopAndStartOfDestinedEvent >= 0 && deltaMinutesBetweenDepartureToStartBusStopAndEndOfPreviousEvent>= 0) {

                    ResultConnection resultConnection = new ResultConnection(currentlyCheckedLine.getLineNumber(),
                            departureToStartBusStop, departureToEndBusStop);

                    resultConnections.add(resultConnection);
                    break;
                }
            }
        }

        resultConnections = shrinkResults(sortResults(resultConnections), askForMaxAmountOfResults);

        return resultConnections;
    }

    private List<ResultConnection> sortResults(List<ResultConnection> resultConnections){

        Collections.sort(resultConnections, new Comparator<ResultConnection>() {

            public int compare(ResultConnection o1, ResultConnection o2) {
                return o1.getTravelEndTime().compareTo(o2.getTravelEndTime());
            }
        });
        return resultConnections;
    }


    private List<ResultConnection> shrinkResults(List<ResultConnection> resultConnections, int maxAmountOfResults) {

        int size = resultConnections.size();
        if (size > maxAmountOfResults) {
            for (int i = size-maxAmountOfResults; i > 0; i--) {
                resultConnections.remove(i);
            }
        }
        return resultConnections;
    }
}
