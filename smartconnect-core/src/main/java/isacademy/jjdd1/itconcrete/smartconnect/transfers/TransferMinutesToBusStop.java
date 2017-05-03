package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;

public class TransferMinutesToBusStop {

    BusLine startBusLine;
    int timeToStartBusStopOnStartLine;
    int timeToMidBusStopOnStartLine;
    BusLine endBusLine;
    int timeToMidBusStopOnEndLine;
    int timeToEndBusStopOnEndLine;


    public TransferMinutesToBusStop(BusLine startBusLine, int timeToStartBusStopOnStartLine, int timeToMidBusStopOnStartLine, BusLine endBusLine, int timeToMidBusStopOnEndLine, int timeToEndBusStopOnEndLine) {
        this.startBusLine = startBusLine;
        this.timeToStartBusStopOnStartLine = timeToStartBusStopOnStartLine;
        this.timeToMidBusStopOnStartLine = timeToMidBusStopOnStartLine;
        this.endBusLine = endBusLine;
        this.timeToMidBusStopOnEndLine = timeToMidBusStopOnEndLine;
        this.timeToEndBusStopOnEndLine = timeToEndBusStopOnEndLine;
    }

    public BusLine getStartBusLine() {
        return startBusLine;
    }

    public void setStartBusLine(BusLine startBusLine) {
        this.startBusLine = startBusLine;
    }

    public int getTimeToStartBusStopOnStartLine() {
        return timeToStartBusStopOnStartLine;
    }

    public void setTimeToStartBusStopOnStartLine(int timeToStartBusStopOnStartLine) {
        this.timeToStartBusStopOnStartLine = timeToStartBusStopOnStartLine;
    }

    public int getTimeToMidBusStopOnStartLine() {
        return timeToMidBusStopOnStartLine;
    }

    public void setTimeToMidBusStopOnStartLine(int timeToMidBusStopOnStartLine) {
        this.timeToMidBusStopOnStartLine = timeToMidBusStopOnStartLine;
    }

    public BusLine getEndBusLine() {
        return endBusLine;
    }

    public void setEndBusLine(BusLine endBusLine) {
        this.endBusLine = endBusLine;
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
        return "TransferMinutesToBusStop{" +
                "startBusLine=" + startBusLine.getLineNumber() +
                ", timeToStartBusStopOnStartLine=" + timeToStartBusStopOnStartLine +
                ", timeToMidBusStopOnStartLine=" + timeToMidBusStopOnStartLine +
                ", endBusLine=" + endBusLine.getLineNumber() +
                ", timeToMidBusStopOnEndLine=" + timeToMidBusStopOnEndLine +
                ", timeToEndBusStopOnEndLine=" + timeToEndBusStopOnEndLine +
                '}';
    }
}
