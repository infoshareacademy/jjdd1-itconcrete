package isacademy.jjdd1.itconcrete.smartconnect.parser;

import isacademy.jjdd1.itconcrete.smartconnect.data.CalendarEvent;

/**
 * Created by katarzynadobrowolska on 01.04.2017.
 */
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

    //---values used by application
    String dtstart;      //format yyyymmddT000000Z date and time of event start
    String dtend;        //format yyyymmddT000000Z date and time of event end
    String location;
    String summary;





    public CalendarEvent[] parseDataFromPath(String calendarPath){
        //TODO logic here
        return new CalendarEvent[0];
    }
}
