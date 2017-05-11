package isacademy.jjdd1.itconcrete.smartconnect.result;


import java.time.LocalTime;

public class DirectResultConnection {
    private int lineNumber;
    private LocalTime travelStartTime;
    private LocalTime travelEndTime;

    public DirectResultConnection(int lineNumber, LocalTime travelStartTime, LocalTime travelEndTime) {
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
        return "DirectResultConnection{" +
                "lineNumber=" + lineNumber +
                ", travelStartTime=" + travelStartTime +
                ", travelEndTime=" + travelEndTime +
                '}';
    }
}
