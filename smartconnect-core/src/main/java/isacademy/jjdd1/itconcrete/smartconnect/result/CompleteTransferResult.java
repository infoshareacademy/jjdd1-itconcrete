package isacademy.jjdd1.itconcrete.smartconnect.result;

import java.util.List;

public class CompleteTransferResult {

    private String startLocation;
    private String endLocation;
    private String startBusStop;
    private String endBusStop;
    List<TransferResultConnection> transferResultConnectionList;

    public CompleteTransferResult(String startLocation, String endLocation, String startBusStop, String endBusStop, List<TransferResultConnection> transferResultConnectionList) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startBusStop = startBusStop;
        this.endBusStop = endBusStop;
        this.transferResultConnectionList = transferResultConnectionList;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
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

    public List<TransferResultConnection> getTransferResultConnectionList() {
        return transferResultConnectionList;
    }

    public void setTransferResultConnectionList(List<TransferResultConnection> transferResultConnectionList) {
        this.transferResultConnectionList = transferResultConnectionList;
    }

    @Override
    public String toString() {
        return "CompleteTransferResult{" +
                "startLocation='" + startLocation + '\'' +
                ", endLocation='" + endLocation + '\'' +
                ", startBusStop='" + startBusStop + '\'' +
                ", endBusStop='" + endBusStop + '\'' +
                ", transferResultConnectionList=" + transferResultConnectionList +
                '}';
    }
}
