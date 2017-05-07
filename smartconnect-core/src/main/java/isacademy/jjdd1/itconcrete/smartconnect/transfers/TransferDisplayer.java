package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransferDisplayer {

    public void displayTransfers(List<Journey> journeys, int maxAmountOfResults) throws IllegalAccessException, NoSuchFieldException, IOException {

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
