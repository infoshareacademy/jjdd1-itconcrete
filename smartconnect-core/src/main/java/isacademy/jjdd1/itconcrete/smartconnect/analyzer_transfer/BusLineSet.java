package isacademy.jjdd1.itconcrete.smartconnect.analyzer_transfer;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;

class BusLineSet {

    private BusLine firstBusLine;
    private String midBusStop;
    private BusLine secondBusLine;

    public BusLineSet(BusLine firstBusLine, String midBusStop, BusLine secondBusLine) {
        this.firstBusLine = firstBusLine;
        this.midBusStop = midBusStop;
        this.secondBusLine = secondBusLine;
    }

    public BusLine getFirstBusLine() {
        return firstBusLine;
    }

    public void setFirstBusLine(BusLine firstBusLine) {
        this.firstBusLine = firstBusLine;
    }

    public String getMidBusStop() {
        return midBusStop;
    }

    public void setMidBusStop(String midBusStop) {
        this.midBusStop = midBusStop;
    }

    public BusLine getSecondBusLine() {
        return secondBusLine;
    }

    public void setSecondBusLine(BusLine secondBusLine) {
        this.secondBusLine = secondBusLine;
    }

    @Override
    public String toString() {
        return "BusLineSet{" +
                "firstBusLine=" + firstBusLine.getLineNumber() +
                ", midBusStop='" + midBusStop + '\'' +
                ", secondBusLine=" + secondBusLine.getLineNumber() +
                '}' + "\n";
    }
}
