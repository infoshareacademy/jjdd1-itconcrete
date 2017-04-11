package isacademy.jjdd1.itconcrete.smartconnect.analyzer;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;

public class LineRideTime {

    private int lineNumber;
    private int timeToReachStartBusStop;
    private int timeToReachEndBusStop;
    private BusLine busLine;

    public LineRideTime(int lineNumber, int timeToReachStartBusStop, int timeToReachEndBusStop, BusLine busLine) {
        this.lineNumber = lineNumber;
        this.timeToReachStartBusStop = timeToReachStartBusStop;
        this.timeToReachEndBusStop = timeToReachEndBusStop;
        this.busLine = busLine;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getTimeToReachStartBusStop() {
        return timeToReachStartBusStop;
    }

    public int getTimeToReachEndBusStop() {
        return timeToReachEndBusStop;
    }

    public BusLine getBusLine() {
        return busLine;
    }
}
