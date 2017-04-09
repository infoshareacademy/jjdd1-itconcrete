package isacademy.jjdd1.itconcrete.smartconnect.analyzer;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;

public class LineRideTime {

    private int lineNumber;
    private int timeToReachFromBusStop;
    private int timeToReachToBusStop;
    private BusLine busLine;

    public LineRideTime(int lineNumber, int timeToReachFromBusStop, int timeToReachToBusStop, BusLine busLine) {
        this.lineNumber = lineNumber;
        this.timeToReachFromBusStop = timeToReachFromBusStop;
        this.timeToReachToBusStop = timeToReachToBusStop;
        this.busLine = busLine;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getTimeToReachFromBusStop() {
        return timeToReachFromBusStop;
    }

    public int getTimeToReachToBusStop() {
        return timeToReachToBusStop;
    }

    public BusLine getBusLine() {
        return busLine;
    }
}
