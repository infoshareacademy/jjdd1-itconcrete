package isacademy.jjdd1.itconcrete.smartconnect.analyzer;


import java.time.LocalTime;

public class ResultConnection {
    private int lineNumber;
    private LocalTime travelStartTime;
    private LocalTime travelEndTime;
    private String startBusStop;
    private String endBusStop;

    public ResultConnection(int lineNumber, LocalTime travelStartTime, LocalTime travelEndTime, String startBusStop, String endBusStop) {
        this.lineNumber = lineNumber;
        this.travelStartTime = travelStartTime;
        this.travelEndTime = travelEndTime;
        this.startBusStop = startBusStop;
        this.endBusStop = endBusStop;
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

    public String getStartBusStop() {
        return startBusStop;
    }

    public String getEndBusStop() {
        return endBusStop;
    }

    @Override
    public String toString() {
        return "ResultConnection{" +
                "lineNumber=" + lineNumber +
                ", travelStartTime=" + travelStartTime +
                ", travelEndTime=" + travelEndTime +
                ", startBusStop='" + startBusStop + '\'' +
                ", endBusStop='" + endBusStop + '\'' +
                '}';
    }
}
