package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarParser;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TransferGetter {

    public void displayTransfers(int maxAmountOfResults) throws IllegalAccessException, NoSuchFieldException, IOException, URISyntaxException {

        CalendarParser calendarParser = new CalendarParser();
        LinkedList<Journey> journeys = calendarParser.parseFileSortEventsAddHome("klonowa", "08:00", "17:00");

        for (Journey journey : journeys) {

            BusLinePairsSeeker busLinePairsSeeker = new BusLinePairsSeeker();
            BusLineSetExtended busLineSetExtended = busLinePairsSeeker.seekBusLinePairs(journey);

            TimeDifferenceCounter timeDifferenceCounter = new TimeDifferenceCounter();
            List<TimeDifferenceSet> timeDifferenceSetList = timeDifferenceCounter.calculateTimeDifferenceSet(busLineSetExtended);

            TransferSeeker transferSeeker = new TransferSeeker();

            List<TransferResultConnection> transferResultConnection = new ArrayList<>();
            transferResultConnection = transferSeeker.seekTransfer(timeDifferenceSetList, journey, maxAmountOfResults);
            System.out.println(transferResultConnection);

        }


    }

}
