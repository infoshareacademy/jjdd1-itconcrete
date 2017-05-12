package isacademy.jjdd1.itconcrete.smartconnect.analyzer_transfer;

import isacademy.jjdd1.itconcrete.smartconnect.result.TransferResultConnection;

import java.util.List;

class TransferSorter {

    public List<TransferResultConnection> sortTransferResultsByTravelStart(List<TransferResultConnection> transferResultConnectionList){

        transferResultConnectionList.sort((o1, o2) -> o2.getDepartureFirstLine().compareTo(o1.getDepartureFirstLine()));

        return transferResultConnectionList;
    }

    public List<TransferResultConnection> sortTransferResultsByTravelEnd(List<TransferResultConnection> transferResultConnectionList){

        transferResultConnectionList.sort((o1, o2) -> o2.getArrivalSecondLine().compareTo(o1.getArrivalSecondLine()));

        return transferResultConnectionList;
    }

}
