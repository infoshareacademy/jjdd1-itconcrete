package isacademy.jjdd1.itconcrete.smartconnect.calendar;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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


    final static int WillILearnHowToUseArraysNope = 99;
    CalendarEvent[] EventsConnection = new CalendarEvent[WillILearnHowToUseArraysNope];


    @Override
    public String toString() {
        return EventsConnection[1].toString();         //this toString has [0]/[1] hardcoded and is for test only
    }                                                  //EventsConnection[0] is the first connection between two stops and EventsConnection[1] is second one

    public CalendarEvent getConnectionData(int EventsConnectionNumber) throws Exception {
        Path path = Paths.get("src/main/resources", "kalendarz.ics");
        List<String> lines = Files.readAllLines(path);
        int eventsNumber = 0;                                       //this can be used by list of events for each day
        DateTime constructorDate0 = DateTime.parse("00000000T00");
        DateTimeFormat.forPattern("yyyyMMdd'T'HH");

        for (String line : lines) {                                 // counting number of events today
            if (line.equals("BEGIN:VEVENT")) {
                eventsNumber++;
            }
        }

        Event[] DailyEvents = new Event[eventsNumber];               //this table stores all {events taking place during same day} separately
        //CalendarEvent[] EventsConnection = new CalendarEvent[eventsNumber - 1];


// following loops declares each Event today
        for (int i = 0; i < eventsNumber; i++) {
            DailyEvents[i] = new Event(constructorDate0, constructorDate0, "", "", false);
        }
        for (int i = 0; i < eventsNumber; i++) {
            EventsConnection[0] = new CalendarEvent(" ", " ", constructorDate0);
            new CalendarEvent(" ", " ", constructorDate0);
        }


        int eventOrder = -1; // used to tell iterator when to switch to next DailyEvents tab (DailyEvents[0]--->DailyEvents[1];

        for (String line : lines) {         //main iteration through file

            if (line.substring(0, 7).equals("DTSTART")) {
                eventOrder++;
                DateTime date = DateTime.parse(line.substring(8, 23),
                        DateTimeFormat.forPattern("yyyyMMdd'T'HHmmss"));
                DailyEvents[eventOrder].setStartTimeYoda(date);
            }
            if (line.substring(0, 5).equals("DTEND")) {
                DateTime date = DateTime.parse(line.substring(6, 21),
                        DateTimeFormat.forPattern("yyyyMMdd'T'HHmmss"));
                DailyEvents[eventOrder].setEndTimeYoda(date);
            }
            if (line.substring(0, 8).equals("LOCATION")) {
                DailyEvents[eventOrder].setLocation(line.substring(9, line.length()));
            }
            if (line.substring(0, 7).equals("SUMMARY")) {
                DailyEvents[eventOrder].setSummary(line.substring(8, line.length()));
            }
            if (line.substring(0, 6).equals("STATUS")) {
                if (line.substring(7, line.length()).equals("CONFIRMED")) {
                    DailyEvents[eventOrder].setConfirmed(true);
                } else if (line.substring(7, line.length()).equals("UNCONFIRMED")) {       //TODO: check real STATUS of non-confirmed events
                    DailyEvents[eventOrder].setConfirmed(false);
                }
            }
            for (int i = 0; i < eventsNumber - 1; i++) {
                EventsConnection[i] = new CalendarEvent(DailyEvents[i].getLocation(), DailyEvents[i + 1].getLocation(), DailyEvents[i + 1].getStartTimeYoda());
            }


        }
        return EventsConnection[EventsConnectionNumber];

    }

    public void DrugaMetodaLOLNaCoToKomuKomuToPotrzebne() {
    }


}

