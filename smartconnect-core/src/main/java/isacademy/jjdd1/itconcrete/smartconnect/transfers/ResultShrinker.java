package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import java.util.List;

class ResultShrinker {

    public List<TransferResultConnection> shrinkResults(List<TransferResultConnection> transferResultConnectionList, int maxAmountOfResults) {

        int size = transferResultConnectionList.size();
        if (size > maxAmountOfResults) {
            for (int i = size-maxAmountOfResults-1; i > 0; i--) {
                transferResultConnectionList.remove(i);
            }
        }
        return transferResultConnectionList;
    }
}
