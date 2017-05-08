package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.ResultConnection;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarParser;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TransferGetter {

    public void displayTransfers(int maxAmountOfResults) throws IllegalAccessException, NoSuchFieldException, IOException, URISyntaxException {

        CalendarParser calendarParser = new CalendarParser();
        LinkedList<Journey> journeys = calendarParser.parseFileSortEventsAddHome("klonowa", "08:00", "20:00");
        ScheduleParser sp = new ScheduleParser();
        sp.loadData();
        ArrayList<BusLine> allBusLines = sp.getArrayOfBusLines();

        for (int i = 0; i < journeys.size(); i++) {

            BusLinePairsSeeker busLinePairsSeeker = new BusLinePairsSeeker();
            BusLineSetExtended busLineSetExtended = busLinePairsSeeker.seekBusLinePairs(journeys.get(i), allBusLines);

            TimeDifferenceCounter timeDifferenceCounter = new TimeDifferenceCounter();
            List<TimeDifferenceSet> timeDifferenceSetList = timeDifferenceCounter.calculateTimeDifferenceSet(busLineSetExtended);

            TransferSeeker transferSeeker = new TransferSeeker();

            List<TransferResultConnection> transferResultConnectionList = new ArrayList<>();
            transferResultConnectionList = transferSeeker.seekTransfer(timeDifferenceSetList, journeys.get(i), maxAmountOfResults);


                System.out.println("\nJourney number " + (i + 1) + ": ");


                for (int j = 0; j < transferResultConnectionList.size() -1; j++) {

                    String startBusStop = transferResultConnectionList.get(j).getStartBusStop();
                    int firstLineNumber = transferResultConnectionList.get(j).getFirstLineNumber();
                    LocalTime departureFirstLine = transferResultConnectionList.get(j).getDepartureFirstLine();
                    LocalTime arrivalFirstLine = transferResultConnectionList.get(j).getArrivalFirstLine();
                    String midBusStop = transferResultConnectionList.get(j).getMidBusStop();
                    int secondLineNumber = transferResultConnectionList.get(j).getSecondLineNumber();
                    LocalTime departureSecondLine = transferResultConnectionList.get(j).getDepartureSecondLine();
                    LocalTime arrivalSecondLine = transferResultConnectionList.get(j).getArrivalSecondLine();
                    String endBusStop = transferResultConnectionList.get(j).getEndBusStop();

                    System.out.println("From " + startBusStop + " take bus line " + firstLineNumber + " at " + departureFirstLine
                            + ", you will arrive " + arrivalFirstLine + " at " + midBusStop + ", get there bus line " + secondLineNumber
                            + " at " + departureSecondLine + ", you will arrive at " + arrivalSecondLine + " to " + endBusStop);

                }

            if (transferResultConnectionList.size() == 0) {
                System.out.println("Sorry, there is no connection for this event." + "\n");
            }
        }
    }

}
