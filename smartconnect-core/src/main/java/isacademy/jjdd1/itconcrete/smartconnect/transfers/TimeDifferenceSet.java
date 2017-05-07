package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;

class TimeDifferenceSet {

    private BusLine firstBusLine;
    private int startBusFirstLineTime;
    private int midBusFirstLineTime;
    private String midBusStop;
    private BusLine secondBusLine;
    private int midBusSecondLineTime;
    private int endBusSecondLineTime;

    public TimeDifferenceSet(BusLine firstBusLine, int startBusFirstLineTime, int midBusFirstLineTime, String midBusStop, BusLine secondBusLine, int midBusSecondLineTime, int endBusSecondLineTime) {
        this.firstBusLine = firstBusLine;
        this.startBusFirstLineTime = startBusFirstLineTime;
        this.midBusFirstLineTime = midBusFirstLineTime;
        this.midBusStop = midBusStop;
        this.secondBusLine = secondBusLine;
        this.midBusSecondLineTime = midBusSecondLineTime;
        this.endBusSecondLineTime = endBusSecondLineTime;
    }

    public BusLine getFirstBusLine() {
        return firstBusLine;
    }

    public void setFirstBusLine(BusLine firstBusLine) {
        this.firstBusLine = firstBusLine;
    }

    public int getStartBusFirstLineTime() {
        return startBusFirstLineTime;
    }

    public void setStartBusFirstLineTime(int startBusFirstLineTime) {
        this.startBusFirstLineTime = startBusFirstLineTime;
    }

    public int getMidBusFirstLineTime() {
        return midBusFirstLineTime;
    }

    public void setMidBusFirstLineTime(int midBusFirstLineTime) {
        this.midBusFirstLineTime = midBusFirstLineTime;
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

    public int getMidBusSecondLineTime() {
        return midBusSecondLineTime;
    }

    public void setMidBusSecondLineTime(int midBusSecondLineTime) {
        this.midBusSecondLineTime = midBusSecondLineTime;
    }

    public int getEndBusSecondLineTime() {
        return endBusSecondLineTime;
    }

    public void setEndBusSecondLineTime(int endBusSecondLineTime) {
        this.endBusSecondLineTime = endBusSecondLineTime;
    }

    @Override
    public String toString() {
        return "TimeDifferenceSet{" +
                "firstBusLine=" + firstBusLine +
                ", startBusFirstLineTime=" + startBusFirstLineTime +
                ", midBusFirstLineTime=" + midBusFirstLineTime +
                ", midBusStop='" + midBusStop + '\'' +
                ", secondBusLine=" + secondBusLine +
                ", midBusSecondLineTime=" + midBusSecondLineTime +
                ", endBusSecondLineTime=" + endBusSecondLineTime +
                '}' + "\n";
    }
}
