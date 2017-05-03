package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;

public class TransferBusLineSet {

    BusLine startBusLine;
    String midBusStop;
    BusLine endBusLine;

    public TransferBusLineSet(BusLine startBusLine, String midBusStop, BusLine endBusLine) {
        this.startBusLine = startBusLine;
        this.midBusStop = midBusStop;
        this.endBusLine = endBusLine;
    }

    public BusLine getStartBusLine() {
        return startBusLine;
    }

    public void setStartBusLine(BusLine startBusLine) {
        this.startBusLine = startBusLine;
    }

    public String getMidBusStop() {
        return midBusStop;
    }

    public void setMidBusStop(String midBusStop) {
        this.midBusStop = midBusStop;
    }

    public BusLine getEndBusLine() {
        return endBusLine;
    }

    public void setEndBusLine(BusLine endBusLine) {
        this.endBusLine = endBusLine;
    }

    @Override
    public String toString() {
        return "TransferBusLineSet{" +
                "startBusLine=" + startBusLine.getLineNumber() +
                ", midBusStop='" + midBusStop + '\'' +
                ", endBusLine=" + endBusLine.getLineNumber() +
                '}';
    }
}
