package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import java.util.List;

public class TransferSetForSeeking {

    private String startBusStop;
    private String endBusStop;
    private List<TransferBusLineSet> transferBusLineSetList;

    public TransferSetForSeeking(String startBusStop, String endBusStop, List<TransferBusLineSet> transferBusLineSetList) {
        this.startBusStop = startBusStop;
        this.endBusStop = endBusStop;
        this.transferBusLineSetList = transferBusLineSetList;
    }

    public String getStartBusStop() {
        return startBusStop;
    }

    public void setStartBusStop(String startBusStop) {
        this.startBusStop = startBusStop;
    }

    public String getEndBusStop() {
        return endBusStop;
    }

    public void setEndBusStop(String endBusStop) {
        this.endBusStop = endBusStop;
    }

    public List<TransferBusLineSet> getTransferBusLineSetList() {
        return transferBusLineSetList;
    }

    public void setTransferBusLineSetList(List<TransferBusLineSet> transferBusLineSetList) {
        this.transferBusLineSetList = transferBusLineSetList;
    }

    @Override
    public String toString() {
        return "TransferSetForSeeking{" +
                "startBusStop='" + startBusStop + '\'' +
                ", endBusStop='" + endBusStop + '\'' +
                ", transferBusLineSetList=" + transferBusLineSetList +
                '}';
    }
}



