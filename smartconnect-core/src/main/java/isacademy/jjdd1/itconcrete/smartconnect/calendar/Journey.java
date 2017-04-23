package isacademy.jjdd1.itconcrete.smartconnect.calendar;
import java.time.LocalTime;

public class Journey {

    private String startBusStop;
    private String endBusStop;
    private String startLocation;
    private String endLocation;
    private LocalTime startOfDestinedEvent;
    private LocalTime endOfFinishedEvent;

    public Journey(String startBusStop, String endBusStop, String startLocation,
                   String endLocation, LocalTime startOfDestinedEvent, LocalTime endOfFinishedEvent) {
        this.startBusStop = startBusStop;
        this.endBusStop = endBusStop;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startOfDestinedEvent = startOfDestinedEvent;
        this.endOfFinishedEvent = endOfFinishedEvent;
    }

    public Journey(){

    }

    public String getStartBusStop() {
        return startBusStop;
    }

    public String getEndBusStop() {
        return endBusStop;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public LocalTime getStartOfDestinedEvent() {
        return startOfDestinedEvent;
    }

    public LocalTime getEndOfFinishedEvent() {
        return endOfFinishedEvent;
    }

    public void setStartBusStop(String startBusStop) {
        this.startBusStop = startBusStop;
    }

    public void setEndBusStop(String endBusStop) {
        this.endBusStop = endBusStop;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public void setStartOfDestinedEvent(LocalTime startOfDestinedEvent) {
        this.startOfDestinedEvent = startOfDestinedEvent;
    }

    public void setEndOfFinishedEvent(LocalTime endOfFinishedEvent) {
        this.endOfFinishedEvent = endOfFinishedEvent;
    }

    @Override
    public String toString() {
        return "Journey{" +
                "startBusStop='" + startBusStop + '\'' +
                ", endBusStop='" + endBusStop + '\'' +
                ", startLocation='" + startLocation + '\'' +
                ", endLocation='" + endLocation + '\'' +
                ", startOfDestinedEvent=" + startOfDestinedEvent +
                ", endOfFinishedEvent=" + endOfFinishedEvent +
                '}';
    }
}


