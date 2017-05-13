package isacademy.jjdd1.itconcrete.smartconnect.analyzer_transfer;

import isacademy.jjdd1.itconcrete.smartconnect.result.TransferResultConnection;

import java.util.List;

class TransferShrinker {

    public List<TransferResultConnection> shrinkTransferResults(List<TransferResultConnection> transferResultConnectionList, int maxAmountOfResults) {

        int size = transferResultConnectionList.size();
        if (size > maxAmountOfResults) {
            for (int i = size - maxAmountOfResults - 1; i >= 0; i--) {
                transferResultConnectionList.remove(i);
            }
        }
        return transferResultConnectionList;
    }
}
