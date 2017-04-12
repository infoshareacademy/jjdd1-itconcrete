package isacademy.jjdd1.itconcrete.smartconnect.calendar;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CalendarParserAlternative {

    public List<Journey> getEventList() throws IOException {

        FileReader fileReader = new FileReader("src/main/resources/kalendarz.ics");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        Journey journey = null;
        List<Journey> journeys = new ArrayList<>();
        final String HOME = "Klonowa";

        while ((line = bufferedReader.readLine()) != null) {

            if (line.startsWith("BEGIN:VEVENT")) {

                if (journey == null) {
                    journey = new Journey();
                    journey.setStartBusStop(HOME);
                } else {
                    String toBusStopFromPreviousEvent = journey.getEndBusStop();
                    journey = new Journey();
                    journey.setStartBusStop(toBusStopFromPreviousEvent);
                }

            } else if (line.startsWith("END:VEVENT")) {
                journeys.add(journey);
            }

            if (line.startsWith("DTSTART")) {
                String[] strings = line.split(":");
                DateTimeFormatter parser = DateTimeFormat.forPattern("yyyyMMdd'T'HHmmss'Z'");
                DateTime dateTime = parser.parseDateTime(strings[1]);
                journey.setStartOfDestinedEvent(dateTime);
            }

            if (line.startsWith("LOCATION")) {
                String[] strings = line.split(":");
                journey.setEndBusStop(strings[1]);
            }

        }
        fileReader.close();
        return journeys;
    }
}
