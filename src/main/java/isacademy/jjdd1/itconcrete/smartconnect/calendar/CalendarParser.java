package isacademy.jjdd1.itconcrete.smartconnect.calendar;

import java.io.File;
import java.lang.reflect.Array;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.Integer.parseInt;


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


    // to comment-out each time before committing until prob(ekhm)challenge with running this method in App.main() is solved --->
//    public static void main(String[] args) throws Exception {
//        CalendarParser instance = new CalendarParser();
//        instance.loadDataFromFile();
//    }
    //---> until here

        private void loadDataFromFile () throws Exception {
            Path path = Paths.get("src/main/resources", "kalendarz.ics");
            List<String> lines = Files.readAllLines(path);

            int eventsNumber = 0;                           //this can be used by list of events for each day
            for (String line : lines) {                        // counting number of events today
                if (line.equals("BEGIN:VEVENT")) {
                    eventsNumber++;
                }
            }

            Event e = new Event(0, 0, 0, 0, "", "", false);

            Event[] DailyEvents = new Event[eventsNumber];  //this table stores all {events taking place during same day} separately
            //following loop declares each Event today
            for (int i = 0; i < eventsNumber; i++) {
                DailyEvents[i] = new Event(0, 0, 0, 0, "", "", false);
            }
            int eventOrder = -1; // used to tell iterator when to switch to next DailyEvents tab (DailyEvents[0]--->DailyEvents[1];

            for (String line : lines) {         //main iteration through file
                //System.out.println(line);

                if (line.substring(0, 7).equals("DTSTART")) {
                    eventOrder++;
                    DailyEvents[eventOrder].setStartDate(parseInt(line.substring(8, 16)));
                    DailyEvents[eventOrder].setStartTime(parseInt(line.substring(17, 23)));  //TODO: parseint is deleting first 0
                }

                if (line.substring(0, 5).equals("DTEND")) {
                    DailyEvents[eventOrder].setEndDate(parseInt(line.substring(6, 14)));
                    DailyEvents[eventOrder].setEndTime(parseInt(line.substring(15, 21)));
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
                    } else {
                        System.out.print("Niesprecyzowane");                          // May cause problems cause its not a boolean result
                    }


                }
            }

            for (int i = 0; i <eventsNumber ; i++) {
                System.out.println(DailyEvents[i].toString());          // just to brag about code greatness
            }

        }

    /**
     * Created by katarzynadobrowolska on 01.04.2017.
     */
    public CalendarEvent[] parseDataFromPath(String calendarPath){
        //TODO logic here
        try {
            loadDataFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new CalendarEvent[0];
    }
}
