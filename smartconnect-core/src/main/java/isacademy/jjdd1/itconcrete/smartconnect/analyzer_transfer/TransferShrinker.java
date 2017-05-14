package isacademy.jjdd1.itconcrete.smartconnect.analyzer_transfer;

import isacademy.jjdd1.itconcrete.smartconnect.result.TransferResultConnection;

import java.util.List;

class TransferShrinker {

    private final int MAX_RESULTS_AMOUNT = 3;

    public List<TransferResultConnection> shrinkTransferResults(List<TransferResultConnection> transferResultConnectionList) {

        int size = transferResultConnectionList.size();
        if (size > MAX_RESULTS_AMOUNT) {
            for (int i = size - 1; i >= MAX_RESULTS_AMOUNT; i--) {
                transferResultConnectionList.remove(i);
            }
        }
        return transferResultConnectionList;
    }
}
