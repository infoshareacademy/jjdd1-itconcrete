package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarParser;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TransferGetter {

    public int getTransfers(int maxAmountOfResults, int i) throws IllegalAccessException, NoSuchFieldException, IOException, URISyntaxException {

        CalendarParser calendarParser = new CalendarParser();
        LinkedList<Journey> journeys = calendarParser.parseFileSortEventsAddHome("klonowa", "08:00", "20:00");
        ScheduleParser sp = new ScheduleParser();
        sp.loadData();
        ArrayList<BusLine> allBusLines = sp.getArrayOfBusLines();

        BusLinePairsSeeker busLinePairsSeeker = new BusLinePairsSeeker();
        BusLineSetExtended busLineSetExtended = busLinePairsSeeker.seekBusLinePairs(journeys.get(i), allBusLines);

        TimeDifferenceCounter timeDifferenceCounter = new TimeDifferenceCounter();
        List<TimeDifferenceSet> timeDifferenceSetList = timeDifferenceCounter.calculateTimeDifferenceSet(busLineSetExtended);

        TransferSeeker transferSeeker = new TransferSeeker();

        List<TransferResultConnection> transferResultConnectionList = new ArrayList<>();
        transferResultConnectionList = transferSeeker.seekTransfer(timeDifferenceSetList, journeys.get(i), maxAmountOfResults);

        TransferDisplayer transferDisplayer = new TransferDisplayer();
        transferDisplayer.displayTransfer(transferResultConnectionList);

        int transferResultListSize = transferResultConnectionList.size();

        return transferResultListSize;
    }

}
