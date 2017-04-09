package isacademy.jjdd1.itconcrete.smartconnect.calendar;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CalendarParserKasia {

    public List<CalendarEvent> getEventList() throws IOException {

        FileReader fileReader = new FileReader("src/main/resources/kalendarz.ics");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        CalendarEvent calendarEvent = null;
        List<CalendarEvent> calendarEvents = new ArrayList<>();
        final String HOME = "Cygańska Góra";


        while ((line = bufferedReader.readLine()) != null) {

            if (line.startsWith("BEGIN:VEVENT")) {

                if (calendarEvent == null) {
                    calendarEvent = new CalendarEvent();
                    calendarEvent.setFromBusStop(HOME);
                } else {
                    String toBusStopFromPreviousEvent = calendarEvent.getToBusStop();
                    calendarEvent = new CalendarEvent();
                    calendarEvent.setFromBusStop(toBusStopFromPreviousEvent);
                }

            } else if (line.startsWith("END:VEVENT")) {

                calendarEvents.add(calendarEvent);
            }

            if (line.startsWith("DTSTART")) {
                String[] strings = line.split(":");
                DateTimeFormatter parser = DateTimeFormat.forPattern("yyyyMMdd'T'HHmmss'Z'");
                DateTime dateTime = parser.parseDateTime(strings[1]);
                calendarEvent.setArrivalTime(dateTime);
            }

            if (line.startsWith("LOCATION")) {
                String[] strings = line.split(":");
                calendarEvent.setToBusStop(strings[1]);
            }

        }
        fileReader.close();
        return calendarEvents;
    }
}
