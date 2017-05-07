package isacademy.jjdd1.itconcrete.smartconnect.calendar;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table
public class Event {

    @Column
    private String location;
    @Column
    private String summary;
    @Column
    private boolean confirmed;
    @Column
    @Id
    private LocalDateTime startTime;
    @Column
    private LocalDateTime endTime;

    @Override
    public String toString() {
        return "Event: "+ startTime + " " + endTime +  " " + location
                + " " + summary + " " + confirmed;
    }

    public Event() {}

    public Event(LocalDateTime startTime, LocalDateTime endTime, String location, String summary, boolean confirmed) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.summary = summary;
        this.confirmed = confirmed;
    }


    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTimeYoda) {
        this.startTime = startTimeYoda;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTimeYoda) {
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
