package isacademy.jjdd1.itconcrete.smartconnect.analyzer;

import org.joda.time.LocalTime;

public class ResultConnection {
    private int lineNumber;
    private LocalTime travelStartTime;
    private LocalTime travelEndTime;
    private String fromBusStop;
    private String toBusStop;

    public ResultConnection(int lineNumber, LocalTime travelStartTime, LocalTime travelEndTime, String fromBusStop, String toBusStop) {
        this.lineNumber = lineNumber;
        this.travelStartTime = travelStartTime;
        this.travelEndTime = travelEndTime;
        this.fromBusStop = fromBusStop;
        this.toBusStop = toBusStop;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public LocalTime getTravelStartTime() {
        return travelStartTime;
    }

    public LocalTime getTravelEndTime() {
        return travelEndTime;
    }

    public String getFromBusStop() {
        return fromBusStop;
    }

    public String getToBusStop() {
        return toBusStop;
    }
}
