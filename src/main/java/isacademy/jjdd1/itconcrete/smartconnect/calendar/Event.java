package isacademy.jjdd1.itconcrete.smartconnect.calendar;

import org.joda.time.DateTime;

/**
 * Created by rekinlukasz on 03.04.17.
 */
public class Event {

    private String location;
    private String summary;
    private boolean confirmed;
    private DateTime startTime;
    private DateTime endTime;

    @Override
    public String toString() {
        return "Event: "+ startTime + " " + endTime +  " " + location
                + " " + summary + " " + confirmed;
    }

    public Event() {}

    public Event(DateTime startTime, DateTime endTime, String location, String summary, boolean confirmed) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.summary = summary;
        this.confirmed = confirmed;
    }


    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTimeYoda) {
        this.startTime = startTimeYoda;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTimeYoda) {
        this.endTime = endTimeYoda;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

}
