package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;

public class TimeDifferenceSet {

    BusLine firstBusLine;
    int timeStartBusStopFirstLine;
    int timeMidBusStopFirstLine;
    BusLine secondBusLine;
    int timeMidBusStopOnEndLine;
    int timeEndBusStopSecondLine;

    public TimeDifferenceSet(BusLine firstBusLine, int timeStartBusStopFirstLine, int timeMidBusStopFirstLine, BusLine secondBusLine, int timeMidBusStopOnEndLine, int timeEndBusStopSecondLine) {
        this.firstBusLine = firstBusLine;
        this.timeStartBusStopFirstLine = timeStartBusStopFirstLine;
        this.timeMidBusStopFirstLine = timeMidBusStopFirstLine;
        this.secondBusLine = secondBusLine;
        this.timeMidBusStopOnEndLine = timeMidBusStopOnEndLine;
        this.timeEndBusStopSecondLine = timeEndBusStopSecondLine;
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

    public int getTimeMidBusStopOnEndLine() {
        return timeMidBusStopOnEndLine;
    }

    public void setTimeMidBusStopOnEndLine(int timeMidBusStopOnEndLine) {
        this.timeMidBusStopOnEndLine = timeMidBusStopOnEndLine;
    }

    public int getTimeEndBusStopSecondLine() {
        return timeEndBusStopSecondLine;
    }

    public void setTimeEndBusStopSecondLine(int timeEndBusStopSecondLine) {
        this.timeEndBusStopSecondLine = timeEndBusStopSecondLine;
    }

    @Override
    public String toString() {
        return "TimeDifferenceSet{" +
                "firstBusLine=" + firstBusLine +
                ", timeStartBusStopFirstLine=" + timeStartBusStopFirstLine +
                ", timeMidBusStopFirstLine=" + timeMidBusStopFirstLine +
                ", secondBusLine=" + secondBusLine +
                ", timeMidBusStopOnEndLine=" + timeMidBusStopOnEndLine +
                ", timeEndBusStopSecondLine=" + timeEndBusStopSecondLine +
                '}';
    }
}
