package isacademy.jjdd1.itconcrete.smartconnect.calendar;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by katarzynadobrowolska on 01.04.2017.
 */
public class CalendarEvent {

    private String fromBusStop;
    private String toBusStop;
    private DateTime arrivalTime;

    public CalendarEvent(String fromBusStop, String toBusStop, DateTime arrivalTime){
        this.fromBusStop = fromBusStop;
        this.toBusStop = toBusStop;
        this.arrivalTime = arrivalTime;
    }

    public String getFromBusStop() {
        return fromBusStop;
    }

    public String getToBusStop() {
        return toBusStop;
    }

    public DateTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "CalendarEvent{" +
                "fromBusStop='" + fromBusStop + '\'' +
                ", toBusStop='" + toBusStop + '\'' +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}
