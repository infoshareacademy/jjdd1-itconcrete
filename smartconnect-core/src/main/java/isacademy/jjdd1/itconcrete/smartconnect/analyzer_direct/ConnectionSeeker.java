package isacademy.jjdd1.itconcrete.smartconnect.analyzer_direct;

import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.result.DirectResultConnection;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ConnectionSeeker {

    public List<DirectResultConnection> seekConnection(List<LineRideTime> lineRideTimes, Journey journey, int askForMaxAmountOfResults) {

        List<DirectResultConnection> directResultConnections = new ArrayList<>();

        String startBusStop = journey.getStartBusStop();
        String endBusStop = journey.getEndBusStop();
        LocalTime startOfDestinedEvent = journey.getStartOfDestinedEvent();
        LocalTime endOfFinishedEvent = journey.getEndOfFinishedEvent();

        for (LineRideTime currentlyCheckedLine : lineRideTimes) {

            List<LocalTime> departures = currentlyCheckedLine.getBusLine().getDeparturesWeekdays();

            int timeToReachStartBusStop = currentlyCheckedLine.getTimeToReachStartBusStopFromFirstBusStop();
            int timeToReachEndBusStop = currentlyCheckedLine.getTimeToReachEndBusStopFromFirstBusStop();

            for (int i = departures.size() - 1; i >= 0; i--) {

                LocalTime departureToEndBusStop = departures.get(i).plusMinutes(timeToReachEndBusStop);
                LocalTime departureToStartBusStop = departures.get(i).plusMinutes(timeToReachStartBusStop);

                long deltaMinutesBetweenDepartureToEndBusStopAndStartOfDestinedEvent = ChronoUnit.MINUTES.between(departureToEndBusStop, startOfDestinedEvent);
                long deltaMinutesBetweenDepartureToStartBusStopAndEndOfPreviousEvent = ChronoUnit.MINUTES.between(endOfFinishedEvent, departureToStartBusStop);

                if (deltaMinutesBetweenDepartureToEndBusStopAndStartOfDestinedEvent >= 0 && deltaMinutesBetweenDepartureToStartBusStopAndEndOfPreviousEvent >= 0) {

                    DirectResultConnection directResultConnection = new DirectResultConnection(currentlyCheckedLine.getLineNumber(),
                            departureToStartBusStop, departureToEndBusStop);

                    directResultConnections.add(directResultConnection);
                    break;
                }
            }
        }

        DirectSorter directSorter = new DirectSorter();
        DirectShrinker directShrinker = new DirectShrinker();

        directResultConnections = directSorter.sortDirectResultsByTravelEnd(directResultConnections);
        directResultConnections = directShrinker.shrinkDirectResults(directResultConnections, askForMaxAmountOfResults);


        return directResultConnections;
    }
}