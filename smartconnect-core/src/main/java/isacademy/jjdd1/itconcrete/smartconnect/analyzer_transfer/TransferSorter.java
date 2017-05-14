package isacademy.jjdd1.itconcrete.smartconnect.analyzer_transfer;

import isacademy.jjdd1.itconcrete.smartconnect.result.TransferResultConnection;

import java.time.temporal.ChronoUnit;
import java.util.List;

class TransferSorter {

    public List<TransferResultConnection> sortTransferResultsByTravelStartAsc(List<TransferResultConnection> transferResultConnectionList){

        transferResultConnectionList.sort((o1, o2) -> o1.getDepartureFirstLine().compareTo(o2.getDepartureFirstLine()));

        return transferResultConnectionList;
    }

    public List<TransferResultConnection> sortTransferResults(List<TransferResultConnection> transferResultConnectionList) {

        transferResultConnectionList.sort((o1, o2) -> {
            int timeTravelo1 = (int) ChronoUnit.MINUTES.between(o1.getDepartureFirstLine(), o1.getArrivalSecondLine());
            int timeTravelo2 = (int) ChronoUnit.MINUTES.between(o2.getDepartureFirstLine(), o2.getArrivalSecondLine());
            int timeTravelDiff = timeTravelo1-timeTravelo2;

            if (timeTravelDiff != 0) {
                return timeTravelDiff;

            } else {
                return o2.getArrivalSecondLine().compareTo(o1.getArrivalSecondLine());
            }

        });

        return transferResultConnectionList;
    }

}
