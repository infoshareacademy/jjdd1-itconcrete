package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalTime;
import java.util.List;

public class TransferDisplayer {

    public void displayTransfer(List<TransferResultConnection> transferResultConnectionList) throws URISyntaxException, IOException, NoSuchFieldException, IllegalAccessException {

        for (int j = 0; j < transferResultConnectionList.size() - 1; j++) {

            int firstLineNumber = transferResultConnectionList.get(j).getFirstLineNumber();

            LocalTime departureFirstLine = transferResultConnectionList.get(j).getDepartureFirstLine();
            LocalTime arrivalFirstLine = transferResultConnectionList.get(j).getArrivalFirstLine();

            String midBusStop = transferResultConnectionList.get(j).getMidBusStop();

            int secondLineNumber = transferResultConnectionList.get(j).getSecondLineNumber();

            LocalTime departureSecondLine = transferResultConnectionList.get(j).getDepartureSecondLine();
            LocalTime arrivalSecondLine = transferResultConnectionList.get(j).getArrivalSecondLine();

            System.out.println(firstLineNumber + " - start journey at: " + departureFirstLine
                    + ", you will reach transfer bus stop at: " + arrivalFirstLine +
                    ". Take transfer from " + midBusStop + ", " + secondLineNumber
                    + " - start journey at: " + departureSecondLine +
                    ", you will reach destination at: " + arrivalSecondLine);
        }
    }
}
