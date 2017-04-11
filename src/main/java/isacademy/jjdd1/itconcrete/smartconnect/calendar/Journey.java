package isacademy.jjdd1.itconcrete.smartconnect.calendar;

import org.joda.time.DateTime;

public class Journey {

    private String startBusStop;
    private String endBusStop;
    private String startLocation;
    private String endLocation;
    private DateTime startOfDestinedEvent;
    private DateTime endOfFinishedEvent;

    public Journey(String startBusStop, String endBusStop, String startLocation,
                   String endLocation, DateTime startOfDestinedEvent, DateTime endOfFinishedEvent) {
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

    public DateTime getStartOfDestinedEvent() {
        return startOfDestinedEvent;
    }

    public DateTime getEndOfFinishedEvent() {
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

    public void setStartOfDestinedEvent(DateTime startOfDestinedEvent) {
        this.startOfDestinedEvent = startOfDestinedEvent;
    }

    public void setEndOfFinishedEvent(DateTime endOfFinishedEvent) {
        this.endOfFinishedEvent = endOfFinishedEvent;
    }
}
