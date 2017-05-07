package isacademy.jjdd1.itconcrete.smartconnect.transfers;

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

                            transferResultConnectionList.add(new TransferResultConnection(firstBusLine.getLineNumber(), departureFirstLine, arrivalFirstLine, secondBusLine.getLineNumber(), departureSecondLine, arrivalSecondLine));

//                            System.out.println(endOfFinishedEvent + " " + startOfDestinedEvent + " " + departureFirstLine + " " + arrivalFirstLine + " " + departureSecondLine + " " + arrivalSecondLine);

                        }
                    }
                }
            }
        }

//        transferResultConnectionList = sortResultsByTravelStart(transferResultConnectionList); //todo how?

        transferResultConnectionList = sortResultsByTravelEnd(transferResultConnectionList);
        transferResultConnectionList = shrinkResults(transferResultConnectionList, maxAmountOfResults);

        return transferResultConnectionList;
    }

    private List<TransferResultConnection> sortResultsByTravelStart(List<TransferResultConnection> transferResultConnectionList){

        Collections.sort(transferResultConnectionList, new Comparator<TransferResultConnection>() {

            public int compare(TransferResultConnection o2, TransferResultConnection o1) {
                return o1.getDepartureFirstLine().compareTo(o2.getDepartureFirstLine());
            }
        });
        return transferResultConnectionList;
    }

    private List<TransferResultConnection> sortResultsByTravelEnd(List<TransferResultConnection> transferResultConnectionList){

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
