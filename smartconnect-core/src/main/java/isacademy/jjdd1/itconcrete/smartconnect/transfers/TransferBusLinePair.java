package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;

public class TransferBusLinePair {

    BusLine startBusLine;
    BusLine endBusLine;
    String midBusStop;

    public TransferBusLinePair(BusLine startBusLine, BusLine endBusLine, String midBusStop) {
        this.startBusLine = startBusLine;
        this.endBusLine = endBusLine;
        this.midBusStop = midBusStop;
    }

    public BusLine getStartBusLine() {
        return startBusLine;
    }

    public void setStartBusLine(BusLine startBusLine) {
        this.startBusLine = startBusLine;
    }

    public BusLine getEndBusLine() {
        return endBusLine;
    }

    public void setEndBusLine(BusLine endBusLine) {
        this.endBusLine = endBusLine;
    }

    public String getMidBusStop() {
        return midBusStop;
    }

    public void setMidBusStop(String midBusStop) {
        this.midBusStop = midBusStop;
    }


    @Override
    public String toString() {
        return "TransferBusLinePair{" +
                "startBusLine=" + startBusLine.getLineNumber() + "\n" +
                ", endBusLine=" + endBusLine.getLineNumber() + "\n" +
                ", midBusStop='" + midBusStop + '\'' +
                '}';
    }
}
