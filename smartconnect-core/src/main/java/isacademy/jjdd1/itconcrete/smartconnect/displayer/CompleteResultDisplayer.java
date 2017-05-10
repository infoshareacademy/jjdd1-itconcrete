package isacademy.jjdd1.itconcrete.smartconnect.displayer;

import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteDirectResult;
import isacademy.jjdd1.itconcrete.smartconnect.result.DirectResultConnection;
import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteTransferResult;
import isacademy.jjdd1.itconcrete.smartconnect.result.TransferResultConnection;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class CompleteResultDisplayer {

    public void displayCompleteResult(List<Journey> journeys, List<CompleteDirectResult> completeDirectResultList, List<CompleteTransferResult> completeTransferResultList) throws IOException, URISyntaxException, NoSuchFieldException, IllegalAccessException {

        DisplayConnection displayConnection = new DisplayConnection();

        for (int i = 0; i < journeys.size(); i++) {

            System.out.println(displayConnection.displayEventHeader(journeys.get(i)));


            CompleteDirectResult completeDirectResult = completeDirectResultList.get(i);

            List<DirectResultConnection> directResultConnectionList = completeDirectResult.getDirectResultConnectionList();

            for (DirectResultConnection directResultConnection : directResultConnectionList) {
                System.out.println(displayConnection.displayingDirectConnection(directResultConnection));
            }

            CompleteTransferResult completeTransferResult = completeTransferResultList.get(i);

            List<TransferResultConnection> transferResultConnectionList = completeTransferResult.getTransferResultConnectionList();

            for (TransferResultConnection transferResultConnection : transferResultConnectionList) {

                System.out.println(displayConnection.displayingTransferConnection(transferResultConnection));
            }

            System.out.println(displayConnection.displayNoResultInfo(directResultConnectionList, transferResultConnectionList));

            System.out.println("");


        }
    }
}
