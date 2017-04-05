package isacademy.jjdd1.itconcrete.smartconnect.parser.CalendarParser;

/**
 * Created by rekinlukasz on 03.04.17.
 */
public class Event {


    private int startDate;      //format yyyymmdd
    private int startTime;      //format 000000
    private int endDate;        //format yyyymmdd
    private int endTime;        //format 000000
    private String location;
    private String summary;
    private boolean confirmed;

    Event(int startDate, int startTime, int endDate, int endTime, String location, String summary, boolean confirmed) {
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.location = location;
        this.summary = summary;
        this.confirmed = confirmed;


    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
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
