package isacademy.jjdd1.itconcrete.smartconnect.analyzer;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;

public class LineRideTime {

    private int lineNumber;
    private int timeToReachStartBusStopFromFirstBusStop;
    private int timeToReachEndBusStopFromFirstBusStop;
    private BusLine busLine;

    public LineRideTime(int lineNumber, int timeToReachStartBusStopFromFirstBusStop, int timeToReachEndBusStopFromFirstBusStop, BusLine busLine) {
        this.lineNumber = lineNumber;
        this.timeToReachStartBusStopFromFirstBusStop = timeToReachStartBusStopFromFirstBusStop;
        this.timeToReachEndBusStopFromFirstBusStop = timeToReachEndBusStopFromFirstBusStop;
        this.busLine = busLine;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getTimeToReachStartBusStopFromFirstBusStop() {
        return timeToReachStartBusStopFromFirstBusStop;
    }

    public int getTimeToReachEndBusStopFromFirstBusStop() {
        return timeToReachEndBusStopFromFirstBusStop;
    }

    public BusLine getBusLine() {
        return busLine;
    }
}
