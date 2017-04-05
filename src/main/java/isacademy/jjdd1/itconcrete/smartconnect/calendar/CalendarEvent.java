package isacademy.jjdd1.itconcrete.smartconnect.calendar;

/**
 * Created by katarzynadobrowolska on 01.04.2017.
 */
public class CalendarEvent {

    String fromBusStop;
    String toBusStop;
    String arrivalTime;

    public CalendarEvent(String fromBusStop, String toBusStop, String arrivalTime){
        this.fromBusStop = fromBusStop;
        this.toBusStop = toBusStop;
        this.arrivalTime = arrivalTime;
    }
}
