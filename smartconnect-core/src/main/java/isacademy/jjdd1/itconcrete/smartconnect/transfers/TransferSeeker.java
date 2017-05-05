package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.ResultConnection;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TransferSeeker {

    public List<TransferResultConnection> seekTransfer(List<TimeDifferenceSet> timeDifferenceSetList, Journey journey, int maxAmountOfResults) {

        List<TransferResultConnection> transferResultConnectionList = new ArrayList<>();

        String startBusStop = journey.getStartBusStop();
        String endBusStop = journey.getEndBusStop();
        LocalTime startOfDestinedEvent = journey.getStartOfDestinedEvent();
        LocalTime endOfFinishedEvent = journey.getEndOfFinishedEvent();
        final int TIME_BEETWEEN_LINES = 5;

        for (TimeDifferenceSet timeDifferenceSet : timeDifferenceSetList) {

            BusLine firstBusLine = timeDifferenceSet.getFirstBusLine();
            int timeStartBusStopFirstLine = timeDifferenceSet.getTimeStartBusStopFirstLine();
            int timeMidBusStopFirstLine = timeDifferenceSet.getTimeMidBusStopFirstLine();

            BusLine secondBusLine = timeDifferenceSet.getSecondBusLine();
            int timeMidBusStopSecondLine = timeDifferenceSet.getTimeMidBusStopOnEndLine();
            int timeEndBusStopSecondLine = timeDifferenceSet.getTimeEndBusStopSecondLine();

            List<LocalTime> departuresSecondLine = secondBusLine.getDeparturesWeekdays();
            List<LocalTime> departuresFirstLine = firstBusLine.getDeparturesWeekdays();



            for (int i = departuresSecondLine.size() - 1; i >= 0; i--) {

                LocalTime departureSecondLine = departuresSecondLine.get(i).plusMinutes(timeMidBusStopSecondLine);
                LocalTime arrivalSecondLine = departuresSecondLine.get(i).plusMinutes(timeEndBusStopSecondLine);

                long timeBetweenArrivalSecondLineAndStartEvent = ChronoUnit.MINUTES.between(arrivalSecondLine, startOfDestinedEvent);
                long timeBetweenDepartureSecondLineAndEndFinishedEvent = ChronoUnit.MINUTES.between(endOfFinishedEvent, departureSecondLine);

                if (timeBetweenArrivalSecondLineAndStartEvent >= 0 && timeBetweenDepartureSecondLineAndEndFinishedEvent >= 0) {

                    for (int j = departuresFirstLine.size() - 1; i >= 0; i--) {

                        LocalTime departureFirstLine = departuresFirstLine.get(j).plusMinutes(timeStartBusStopFirstLine);
                        LocalTime arrivalFirstLine = departuresFirstLine.get(j).plusMinutes(timeMidBusStopFirstLine);

                        long timeBetweenArrivalFirstLineAndDepartureSecondLine = ChronoUnit.MINUTES.between(arrivalFirstLine, departureSecondLine);
                        long timeBetweenEndFinishedEventAndDepartureFirstLine = ChronoUnit.MINUTES.between(endOfFinishedEvent, departureFirstLine);

                        if (timeBetweenArrivalFirstLineAndDepartureSecondLine >= TIME_BEETWEEN_LINES && timeBetweenEndFinishedEventAndDepartureFirstLine >= 0) {

                            transferResultConnectionList.add(new TransferResultConnection(firstBusLine.getLineNumber(), departureFirstLine, arrivalFirstLine, secondBusLine.getLineNumber(), departureSecondLine, arrivalSecondLine));
                        }
                    }
                }

            }
        }
        transferResultConnectionList = sortResults(transferResultConnectionList);
        transferResultConnectionList = shrinkResults(transferResultConnectionList, maxAmountOfResults);

        return transferResultConnectionList;
    }

    private List<TransferResultConnection> sortResults(List<TransferResultConnection> transferResultConnectionList){

        Collections.sort(transferResultConnectionList, new Comparator<TransferResultConnection>() {

            public int compare(TransferResultConnection o1, TransferResultConnection o2) {
                return o1.getArrivalSecondLine().compareTo(o2.getArrivalSecondLine());
            }
        });
        return transferResultConnectionList;
    }


    private List<TransferResultConnection> shrinkResults(List<TransferResultConnection> transferResultConnectionList, int maxAmountOfResults) {

        int size = transferResultConnectionList.size();
        if (size > maxAmountOfResults) {
            for (int i = size-maxAmountOfResults; i > 0; i--) {
                transferResultConnectionList.remove(i);
            }
        }
        return transferResultConnectionList;
    }
}
