package isacademy.jjdd1.itconcrete.smartconnect.calendar;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JourneyCreator {

    private String splitLine(String line) {
        String[] arrayWithSplitedStrings = line.split(":");
        String result = arrayWithSplitedStrings[1];
        return result;
    }

    private DateTime timeParser(String timeInString) {
        DateTimeFormatter parser = DateTimeFormat.forPattern("yyyyMMdd'T'HHmmss'Z'");
        DateTime dateTime = parser.parseDateTime(timeInString);
        return dateTime;
    }

    public List<Journey> getEventList() throws IOException {

        FileReader fileReader = new FileReader("src/main/resources/kalendarz.ics");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        Journey journey = null;
        List<Journey> journeys = new ArrayList<>();

        final String HOME_BUS_STOP = "Klonowa";
        final String HOME = "Dom";
        final String TIME_OF_LEAVING_HOME = "20170408T060000Z";
        final String TIME_OF_ARRIVING_HOME = "20170408T180000Z";

        String memorizedBusStop = null;
        String memorizedEndLocation = null;
        DateTime memorizedEndOfPreviousEvent = null;

        while ((line = bufferedReader.readLine()) != null) {

            if (line.startsWith("BEGIN:VCALENDAR")) {
                journey = new Journey();
                journey.setStartBusStop(HOME_BUS_STOP);
                journey.setStartLocation(HOME);
                journey.setEndOfFinishedEvent(timeParser(TIME_OF_LEAVING_HOME));
                continue;

            } else {

                if (journeys.size() == 0) {

                    if (line.startsWith("DTSTART")) {
                        journey.setStartOfDestinedEvent(timeParser(splitLine(line)));
                    }

                    if (line.startsWith("DTEND")) {
                        memorizedEndOfPreviousEvent = timeParser(splitLine(line));
                    }

                    if (line.startsWith("LOCATION")) {
                        memorizedBusStop = splitLine(line);
                        journey.setEndBusStop(memorizedBusStop);
                    }

                    if (line.startsWith("SUMMARY")) {
                        memorizedEndLocation = splitLine(line);
                        journey.setEndLocation(memorizedEndLocation);
                    }

                    if (line.startsWith("END:VEVENT")) {
                        journeys.add(journey);
                    }

                } else {

                    if (line.startsWith("BEGIN:VEVENT")) {
                        journey = new Journey();
                        journey.setStartBusStop(memorizedBusStop);
                        journey.setStartLocation(memorizedEndLocation);
                        journey.setEndOfFinishedEvent(memorizedEndOfPreviousEvent);
                    }

                    if (line.startsWith("DTSTART")) {
                        journey.setStartOfDestinedEvent(timeParser(splitLine(line)));
                    }

                    if (line.startsWith("DTEND")) {
                        memorizedEndOfPreviousEvent = timeParser(splitLine(line));
                    }

                    if (line.startsWith("LOCATION")) {
                        memorizedBusStop = splitLine(line);
                        journey.setEndBusStop(memorizedBusStop);
                    }

                    if (line.startsWith("SUMMARY")) {
                        memorizedEndLocation = splitLine(line);
                        journey.setEndLocation(memorizedEndLocation);
                    }

                    if (line.startsWith("END:VEVENT")) {
                        journeys.add(journey);
                    }
                }
            }
        }
            fileReader.close();

            journey = new Journey();
            journey.setStartBusStop(memorizedBusStop);
            journey.setEndBusStop(HOME_BUS_STOP);
            journey.setStartLocation(memorizedEndLocation);
            journey.setEndLocation(HOME);
            journey.setStartOfDestinedEvent(timeParser(TIME_OF_ARRIVING_HOME));
            journey.setEndOfFinishedEvent(memorizedEndOfPreviousEvent);
            journeys.add(journey);

            return journeys;
    }
}