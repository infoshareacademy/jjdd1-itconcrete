package isacademy.jjdd1.itconcrete.smartconnect.result;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer_transfer.*;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarParser;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TransferResultGetter {

    public List<CompleteTransferResult> getTransfers(String homeBusStop, String timeOfLeavingHome, String timeOfArrivingHome, int maxAmountOfResults, ArrayList<BusLine> allBusLines) throws IllegalAccessException, NoSuchFieldException, IOException, URISyntaxException {


        CalendarParser calendarParser = new CalendarParser();
        LinkedList<Journey> journeys = calendarParser.parseFileSortEventsAddHome(homeBusStop, timeOfLeavingHome, timeOfArrivingHome);

        List<CompleteTransferResult> completeTransferResultList = new ArrayList<>();

        for (int i = 0; i < journeys.size(); i++) {

            String startLocation = journeys.get(i).getStartLocation();
            String endLocation = journeys.get(i).getEndLocation();
            String startBusStop = journeys.get(i).getStartBusStop();
            String endBusStop = journeys.get(i).getEndBusStop();

            BusLinePairsSeeker busLinePairsSeeker = new BusLinePairsSeeker();
            BusLineSetExtended busLineSetExtended = busLinePairsSeeker.seekBusLinePairs(journeys.get(i), allBusLines);

            TimeDifferenceCounter timeDifferenceCounter = new TimeDifferenceCounter();
            List<TimeDifferenceSet> timeDifferenceSetList = timeDifferenceCounter.calculateTimeDifferenceSet(busLineSetExtended);

            TransferSeeker transferSeeker = new TransferSeeker();

            List<TransferResultConnection> transferResultConnectionList = new ArrayList<>();
            transferResultConnectionList = transferSeeker.seekTransfer(timeDifferenceSetList, journeys.get(i), maxAmountOfResults);

            completeTransferResultList.add(new CompleteTransferResult(startLocation, endLocation, startBusStop, endBusStop, transferResultConnectionList));

        }

        return completeTransferResultList;
    }

}
