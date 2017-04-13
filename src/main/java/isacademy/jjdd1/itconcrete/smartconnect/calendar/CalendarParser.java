package isacademy.jjdd1.itconcrete.smartconnect.calendar;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CalendarParser {

    List<Event> events = new ArrayList<>();
    Event event = new Event();
   

    //   String path = "src/main/resources/kalendarz.ics";

    public List<Event> readEvents(String path) throws IOException {

        CalendarParser cp = new CalendarParser();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;

        while ((line = bufferedReader.readLine()) != null) {

            if (line.startsWith("BEGIN:VEVENT")) {
                event = new Event();
            }
            if (line.startsWith("DTSTART")) {
                cp.setStartDate(line, event);
            }
            if (line.startsWith("DTEND")) {
                cp.setEndDate(line, event);
            }
            if (line.startsWith("LOCATION")) {
                cp.setLocation(line, event);
            }
            if (line.startsWith("SUMMARY")) {
                cp.setSummary(line, event);
            }
            if (line.startsWith("STATUS")) {
                cp.setStatus(line,event);
            }
            if (line.startsWith("END:VEVENT")) {
                events.add(event);
            }
        }
        fileReader.close();
        return events;
    }

    public Event setStartDate(String line, Event event) {
        DateTime date = DateTime.parse(line.substring(8, 23),
                DateTimeFormat.forPattern("yyyyMMdd'T'HHmmss"));
        event.setStartTime(date);
        return event;
    }
    public Event setEndDate(String line, Event event) {
        DateTime date = DateTime.parse(line.substring(6, 21),
                DateTimeFormat.forPattern("yyyyMMdd'T'HHmmss"));
        event.setEndTime(date);
        return event;
    }
    public Event setLocation(String line, Event event) {
        event.setLocation(line.substring(9, line.length()));
        return event;
    }
    public Event setSummary(String line, Event event) {
        event.setSummary(line.substring(8, line.length()));
        return event;
    }
    public Event setStatus(String line, Event event) {
        if (line.substring(7, line.length()).equals("CONFIRMED")) {
            event.setConfirmed(true);
        } else if (line.substring(7, line.length()).equals("UNCONFIRMED")) {       //TODO: check real STATUS of non-confirmed events
            event.setConfirmed(false);
        }
        return event;
    }

    public List<Event> sortEvents(List<Event> events) {
        events.sort((e1,e2) -> e1.getStartTime().compareTo(e2.getStartTime()));
        return events;
    }

    public LinkedList<Journey> connectEventsIntoJourneys(List<Event> events) {
        LinkedList<Journey> journeys = new LinkedList<>();

        for (int i = 0; i <events.size()-1 ; i++) {
           

            String location0 = events.get(i).getLocation();
            String location1 = events.get(i+1).getLocation();
            String summary0 = events.get(i).getSummary();
            String summary1 = events.get(i+1).getSummary();
            DateTime czas = events.get(i+1).getStartTime();
            DateTime czas1 = events.get(i).getEndTime();


            Journey journey = new Journey(location0, location1,summary0,summary1,czas,czas1);
            journeys.add(journey);
        }
        return journeys;
    }

}
//---    Typical Event Values:
//    BEGIN:VEVENT
//    DTSTART:20170408T070000Z
//    DTEND:20170408T090000Z
//    DTSTAMP:20170403T000048Z
//    UID:11do5a4lnt0egk4q518gb3ukbg@google.com
//    CREATED:20170402T235327Z
//    DESCRIPTION:
//    LAST-MODIFIED:20170402T235327Z
//    LOCATION:Targ Węglowy
//    SEQUENCE:0
//    STATUS:CONFIRMED
//    SUMMARY:katownia
//    TRANSP:OPAQUE
//    END:VEVENT




