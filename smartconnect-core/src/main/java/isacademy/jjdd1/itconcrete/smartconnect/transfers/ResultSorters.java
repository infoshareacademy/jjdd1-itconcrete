package isacademy.jjdd1.itconcrete.smartconnect.transfers;
import java.util.Collections;
import java.util.List;

public class ResultSorters {

    public List<TransferResultConnection> sortResultsByTravelStart(List<TransferResultConnection> transferResultConnectionList){

        Collections.sort(transferResultConnectionList, (o1, o2) -> o2.getDepartureFirstLine().compareTo(o1.getDepartureFirstLine()));

        return transferResultConnectionList;
    }

    public List<TransferResultConnection> sortResultsByTravelEnd(List<TransferResultConnection> transferResultConnectionList){

        Collections.sort(transferResultConnectionList, (o1, o2) -> o2.getArrivalSecondLine().compareTo(o1.getArrivalSecondLine()));

        return transferResultConnectionList;
    }

}
