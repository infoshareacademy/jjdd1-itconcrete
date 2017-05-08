package isacademy.jjdd1.itconcrete.smartconnect.displayer;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.CompleteResult;
import isacademy.jjdd1.itconcrete.smartconnect.analyzer.ResultConnection;
import isacademy.jjdd1.itconcrete.smartconnect.transfers.TransferGetter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class CompleteResultDisplayer {

    public void displayCompleteResult(List<CompleteResult> completeResultList, int maxAmountOfResults) throws IOException, URISyntaxException, NoSuchFieldException, IllegalAccessException {

        DisplayConnection displayConnection = new DisplayConnection();

        for (int i = 0; i < completeResultList.size(); i++) {

            System.out.println("\nJourney number " + (i + 1) + ": ");

            String textForEachEvent = displayConnection.displayEventHeader(completeResultList.get(i));
            System.out.println(textForEachEvent);

            List<ResultConnection> resultConnections = completeResultList.get(i).getResultConnectionList();

            for (ResultConnection resultConnection : resultConnections) {
                String textForEachResult = displayConnection.displayingConnection(resultConnection);
                System.out.println(textForEachResult);
            }

            TransferGetter transferGetter = new TransferGetter();
            int transferResultListSize = transferGetter.getTransfers(maxAmountOfResults, i);

            boolean noResultsForBothMethods = (resultConnections.size() == 0) && (transferResultListSize == 0);

            if (noResultsForBothMethods) {

                System.out.println("Sorry, there is no connection for this event.");
            }
        }
    }
}
