package isacademy.jjdd1.itconcrete.smartconnect.analyzer_transfer;

import isacademy.jjdd1.itconcrete.smartconnect.result.TransferResultConnection;

import java.time.temporal.ChronoUnit;
import java.util.List;

class TransferSorter {

    public List<TransferResultConnection> sortTransferResultsByTravelStart(List<TransferResultConnection> transferResultConnectionList){

        transferResultConnectionList.sort((o1, o2) -> o2.getDepartureFirstLine().compareTo(o1.getDepartureFirstLine()));

        return transferResultConnectionList;
    }

    public List<TransferResultConnection> sortTransferResults(List<TransferResultConnection> transferResultConnectionList) {

        transferResultConnectionList.sort((o1, o2) -> {
            int timeTravelo1 = (int) ChronoUnit.MINUTES.between(o1.getArrivalSecondLine(), o1.getDepartureFirstLine());
            int timeTravelo2 = (int) ChronoUnit.MINUTES.between(o2.getArrivalSecondLine(), o2.getDepartureFirstLine());
            int timeTravelDiff = timeTravelo2-timeTravelo1;

            if (timeTravelDiff != 0) {
                return timeTravelDiff;

            } else {
                return o2.getArrivalSecondLine().compareTo(o1.getArrivalSecondLine());
            }

        });

        return transferResultConnectionList;
    }

}
