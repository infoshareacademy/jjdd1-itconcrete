package isacademy.jjdd1.itconcrete.smartconnect.calendar;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.DateAndTimeConverter;
import org.joda.time.LocalTime;
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

    public List<Journey> getEventList() throws IOException {

        FileReader fileReader = new FileReader("src/main/resources/SmartConnectTest.ics");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        Journey journey = null;
        List<Journey> journeys = new ArrayList<>();

        final String HOME_BUS_STOP = "Klonowa";
        final String HOME = "Home";
        final LocalTime TIME_OF_LEAVING_HOME = DateAndTimeConverter.timeParser("20170408T063000Z");
        final LocalTime TIME_OF_ARRIVING_HOME = DateAndTimeConverter.timeParser("20170408T180000Z");

        String memorizedBusStop = null;
        String memorizedLocation = null;
        LocalTime memorizedEvent = null;

        while ((line = bufferedReader.readLine()) != null) {

            if (line.startsWith("BEGIN:VCALENDAR")) {
                journey = new Journey();
                journey.setStartBusStop(HOME_BUS_STOP);
                journey.setStartLocation(HOME);
                journey.setEndOfFinishedEvent(TIME_OF_LEAVING_HOME);
                continue;

            } else {

                if (journeys.size() == 0) {

                    if (line.startsWith("DTSTART")) {
                        journey.setStartOfDestinedEvent(DateAndTimeConverter.timeParser(splitLine(line)));
                    }

                    if (line.startsWith("DTEND")) {
                        memorizedEvent = DateAndTimeConverter.timeParser(splitLine(line));
                    }

                    if (line.startsWith("LOCATION")) {
                        memorizedBusStop = splitLine(line);
                        journey.setEndBusStop(memorizedBusStop);
                    }

                    if (line.startsWith("SUMMARY")) {
                        memorizedLocation = splitLine(line);
                        journey.setEndLocation(memorizedLocation);
                    }

                    if (line.startsWith("END:VEVENT")) {
                        journeys.add(journey);
                    }

                } else {

                    if (line.startsWith("BEGIN:VEVENT")) {
                        journey = new Journey();
                        journey.setStartBusStop(memorizedBusStop);
                        journey.setStartLocation(memorizedLocation);
                        journey.setEndOfFinishedEvent(memorizedEvent);
                    }

                    if (line.startsWith("DTSTART")) {
                        journey.setStartOfDestinedEvent(DateAndTimeConverter.timeParser(splitLine(line)));
                    }

                    if (line.startsWith("DTEND")) {
                        memorizedEvent = DateAndTimeConverter.timeParser(splitLine(line));
                    }

                    if (line.startsWith("LOCATION")) {
                        memorizedBusStop = splitLine(line);
                        journey.setEndBusStop(memorizedBusStop);
                    }

                    if (line.startsWith("SUMMARY")) {
                        memorizedLocation = splitLine(line);
                        journey.setEndLocation(memorizedLocation);
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
            journey.setStartLocation(memorizedLocation);
            journey.setEndLocation(HOME);
            journey.setStartOfDestinedEvent(TIME_OF_ARRIVING_HOME);
            journey.setEndOfFinishedEvent(memorizedEvent);
            journeys.add(journey);

            return journeys;
    }
}