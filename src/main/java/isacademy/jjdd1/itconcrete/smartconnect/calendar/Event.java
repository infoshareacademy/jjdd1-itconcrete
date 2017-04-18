//package isacademy.jjdd1.itconcrete.smartconnect.calendar;
//
//import org.joda.time.DateTime;
//
///**
// * Created by rekinlukasz on 03.04.17.
// */
//public class Event {
//
//    private String location;
//    private String summary;
//    private boolean confirmed;
//    private DateTime startTimeYoda;
//    private DateTime endTimeYoda;
//
//    @Override
//    public String toString() {
//        return "Event: "+ startTimeYoda + " " + endTimeYoda +  " " + location
//                + " " + summary + " " + confirmed;
//    }
//
//    public Event(DateTime startTimeYoda, DateTime endTimeYoda, String location, String summary, boolean confirmed) {
//        this.startTimeYoda = startTimeYoda;
//        this.endTimeYoda = endTimeYoda;
//        this.location = location;
//        this.summary = summary;
//        this.confirmed = confirmed;
//    }
//
//
//    public DateTime getStartTimeYoda() {
//        return startTimeYoda;
//    }
//
//    public void setStartTimeYoda(DateTime startTimeYoda) {
//        this.startTimeYoda = startTimeYoda;
//    }
//
//    public DateTime getEndTimeYoda() {
//        return endTimeYoda;
//    }
//
//    public void setEndTimeYoda(DateTime endTimeYoda) {
//        this.endTimeYoda = endTimeYoda;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getSummary() {
//        return summary;
//    }
//
//    public void setSummary(String summary) {
//        this.summary = summary;
//    }
//
//    public boolean isConfirmed() {
//        return confirmed;
//    }
//
//    public void setConfirmed(boolean confirmed) {
//        this.confirmed = confirmed;
//    }
//
//}
