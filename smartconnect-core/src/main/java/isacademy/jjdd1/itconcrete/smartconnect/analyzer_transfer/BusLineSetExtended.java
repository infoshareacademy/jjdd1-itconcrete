package isacademy.jjdd1.itconcrete.smartconnect.analyzer_transfer;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer_alternative.Transfer;

import java.util.List;


public class BusLineSetExtended {

    private String startBusStop;
    private String endBusStop;
    private List<Transfer> possibleTransfers;

    public BusLineSetExtended(String startBusStop, String endBusStop, List<Transfer> possibleTransfers) {
        this.startBusStop = startBusStop;
        this.endBusStop = endBusStop;
        this.possibleTransfers = possibleTransfers;
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

    public List<Transfer> getPossibleTransfers() {
        return possibleTransfers;
    }

    @Override
    public String toString() {
        return "BusLineSetExtended{" +
                "startBusStop='" + startBusStop + '\'' +
                ", endBusStop='" + endBusStop + '\'' +
                ", possibleTransfers=" + possibleTransfers +
                '}';
    }
}



