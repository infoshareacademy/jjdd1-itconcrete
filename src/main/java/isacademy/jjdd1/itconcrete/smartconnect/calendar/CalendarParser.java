package isacademy.jjdd1.itconcrete.smartconnect.calendar;

import isacademy.jjdd1.itconcrete.smartconnect.data.CalendarEvent;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class CalendarParser {

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



    private void loadDataFromFile() throws Exception {
        URL resource = getClass().getResource("kalendarz.ics");             //TODO: import file from outer package
        List<String> lines = Files.readAllLines(Paths.get(resource.toURI()));
        for (String line: lines) {
            System.out.println(line);
        }
    }


    /**
     * Created by katarzynadobrowolska on 01.04.2017.
     */
    public CalendarEvent[] parseDataFromPath(String calendarPath){
        //TODO logic here
        return new CalendarEvent[0];
    }
}
