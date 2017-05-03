package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;

public class TimeDifferenceSet {

    BusLine firstBusLine;
    int timeStartBusStopFirstLine;
    int timeMidBusStopFirstLine;
    BusLine secondBusLine;
    int timeToMidBusStopOnEndLine;
    int timeToEndBusStopOnEndLine;


    public TimeDifferenceSet(BusLine firstBusLine, int timeStartBusStopFirstLine, int timeMidBusStopFirstLine, BusLine secondBusLine, int timeToMidBusStopOnEndLine, int timeToEndBusStopOnEndLine) {
        this.firstBusLine = firstBusLine;
        this.timeStartBusStopFirstLine = timeStartBusStopFirstLine;
        this.timeMidBusStopFirstLine = timeMidBusStopFirstLine;
        this.secondBusLine = secondBusLine;
        this.timeToMidBusStopOnEndLine = timeToMidBusStopOnEndLine;
        this.timeToEndBusStopOnEndLine = timeToEndBusStopOnEndLine;
    }

    public BusLine getFirstBusLine() {
        return firstBusLine;
    }

    public void setFirstBusLine(BusLine firstBusLine) {
        this.firstBusLine = firstBusLine;
    }

    public int getTimeStartBusStopFirstLine() {
        return timeStartBusStopFirstLine;
    }

    public void setTimeStartBusStopFirstLine(int timeStartBusStopFirstLine) {
        this.timeStartBusStopFirstLine = timeStartBusStopFirstLine;
    }

    public int getTimeMidBusStopFirstLine() {
        return timeMidBusStopFirstLine;
    }

    public void setTimeMidBusStopFirstLine(int timeMidBusStopFirstLine) {
        this.timeMidBusStopFirstLine = timeMidBusStopFirstLine;
    }

    public BusLine getSecondBusLine() {
        return secondBusLine;
    }

    public void setSecondBusLine(BusLine secondBusLine) {
        this.secondBusLine = secondBusLine;
    }

    public int getTimeToMidBusStopOnEndLine() {
        return timeToMidBusStopOnEndLine;
    }

    public void setTimeToMidBusStopOnEndLine(int timeToMidBusStopOnEndLine) {
        this.timeToMidBusStopOnEndLine = timeToMidBusStopOnEndLine;
    }

    public int getTimeToEndBusStopOnEndLine() {
        return timeToEndBusStopOnEndLine;
    }

    public void setTimeToEndBusStopOnEndLine(int timeToEndBusStopOnEndLine) {
        this.timeToEndBusStopOnEndLine = timeToEndBusStopOnEndLine;
    }

    @Override
    public String toString() {
        return "TimeDifferenceSet{" +
                "firstBusLine=" + firstBusLine.getLineNumber() +
                ", timeStartBusStopFirstLine=" + timeStartBusStopFirstLine +
                ", timeMidBusStopFirstLine=" + timeMidBusStopFirstLine +
                ", secondBusLine=" + secondBusLine.getLineNumber() +
                ", timeToMidBusStopOnEndLine=" + timeToMidBusStopOnEndLine +
                ", timeToEndBusStopOnEndLine=" + timeToEndBusStopOnEndLine +
                '}';
    }
}
