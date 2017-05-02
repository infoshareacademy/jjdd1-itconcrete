package isacademy.jjdd1.itconcrete.smartconnect.analyzer;


import java.time.LocalTime;

public class ResultConnection {
    private int lineNumber;
    private LocalTime travelStartTime;
    private LocalTime travelEndTime;

    public ResultConnection(int lineNumber, LocalTime travelStartTime, LocalTime travelEndTime) {
        this.lineNumber = lineNumber;
        this.travelStartTime = travelStartTime;
        this.travelEndTime = travelEndTime;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public LocalTime getTravelStartTime() {
        return travelStartTime;
    }

    public void setTravelStartTime(LocalTime travelStartTime) {
        this.travelStartTime = travelStartTime;
    }

    public LocalTime getTravelEndTime() {
        return travelEndTime;
    }

    public void setTravelEndTime(LocalTime travelEndTime) {
        this.travelEndTime = travelEndTime;
    }

    @Override
    public String toString() {
        return "ResultConnection{" +
                "lineNumber=" + lineNumber +
                ", travelStartTime=" + travelStartTime +
                ", travelEndTime=" + travelEndTime +
                '}';
    }
}
