package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

class TransferSeeker {

    public List<TransferResultConnection> seekTransfer(List<TimeDifferenceSet> timeDifferenceSetList, Journey journey, int maxAmountOfResults) {

        List<TransferResultConnection> transferResultConnectionList = new ArrayList<>();

        LocalTime startOfDestinedEvent = journey.getStartOfDestinedEvent();
        LocalTime endOfFinishedEvent = journey.getEndOfFinishedEvent();
        final int TIME_BEETWEEN_LINES = 5;

        for (TimeDifferenceSet timeDifferenceSet : timeDifferenceSetList) {

            BusLine firstBusLine = timeDifferenceSet.getFirstBusLine();
            List<LocalTime> departuresFirstLine = firstBusLine.getDeparturesWeekdays();
            int startBusFirstLineTime = timeDifferenceSet.getStartBusFirstLineTime();
            int midBusFirstLineTime = timeDifferenceSet.getMidBusFirstLineTime();

            BusLine secondBusLine = timeDifferenceSet.getSecondBusLine();
            List<LocalTime> departuresSecondLine = secondBusLine.getDeparturesWeekdays();
            int midBusSecondLineTime = timeDifferenceSet.getMidBusSecondLineTime();
            int endBusSecondLineTime = timeDifferenceSet.getEndBusSecondLineTime();


            for (int i = departuresSecondLine.size() - 1; i >= 0; i--) {

                LocalTime departureSecondLine = departuresSecondLine.get(i).plusMinutes(midBusSecondLineTime);
                LocalTime arrivalSecondLine = departuresSecondLine.get(i).plusMinutes(endBusSecondLineTime);

                long endSecondLineStartDestinedEvent = ChronoUnit.MINUTES.between(arrivalSecondLine, startOfDestinedEvent);
                long startSecondLineFinishedEvent = ChronoUnit.MINUTES.between(endOfFinishedEvent, departureSecondLine);

                if ((endSecondLineStartDestinedEvent >= 0) && (startSecondLineFinishedEvent >= 0)) {

                    for (int j = departuresFirstLine.size() - 1; j >= 0; j--) {

                        LocalTime departureFirstLine = departuresFirstLine.get(j).plusMinutes(startBusFirstLineTime);
                        LocalTime arrivalFirstLine = departuresFirstLine.get(j).plusMinutes(midBusFirstLineTime);

                        long endFirstLineStartSecondLine = ChronoUnit.MINUTES.between(arrivalFirstLine, departureSecondLine);
                        long finishedEventStartFirstLine = ChronoUnit.MINUTES.between(endOfFinishedEvent, departureFirstLine);

                        if ((endFirstLineStartSecondLine >= TIME_BEETWEEN_LINES) && (finishedEventStartFirstLine >= 0)) {

                            String startBusStop = journey.getStartBusStop();
                            String midBusStop = timeDifferenceSet.getMidBusStop();
                            String endBusStop = journey.getEndBusStop();

                            transferResultConnectionList.add(new TransferResultConnection(startBusStop, firstBusLine.getLineNumber(), departureFirstLine, arrivalFirstLine, midBusStop, secondBusLine.getLineNumber(), departureSecondLine, arrivalSecondLine, endBusStop));
                        }
                    }
                }
            }
        }

        ResultSorters resultSorters = new ResultSorters();
        ResultShrinker resultShrinker = new ResultShrinker();

        transferResultConnectionList = resultSorters.sortResultsByTravelStart(transferResultConnectionList);
        transferResultConnectionList = resultSorters.sortResultsByTravelEnd(transferResultConnectionList);
        transferResultConnectionList = resultShrinker.shrinkResults(transferResultConnectionList, maxAmountOfResults);

        return transferResultConnectionList;
    }
}
