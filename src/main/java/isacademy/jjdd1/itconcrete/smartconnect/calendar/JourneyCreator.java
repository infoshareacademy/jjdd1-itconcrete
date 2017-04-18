package isacademy.jjdd1.itconcrete.smartconnect.calendar;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.DateAndTimeConverter;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.CapitalLetter;
import org.joda.time.LocalTime;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JourneyCreator {

    private String splitLine(String line) {
        String[] arrayWithSplitedStrings = line.split(":");
        String result = arrayWithSplitedStrings[1];
        return result;
    }

    public List<Journey> getJourneysList(String homeBusStop, String timeOfLeavingHome, String timeOfArrivingHome) throws IOException, URISyntaxException {

        URI uri = JourneyCreator.class.getResource("/kalendarz.ics").toURI();
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(uri));

        homeBusStop = CapitalLetter.makeFirstLetterCapital(homeBusStop);

        String line;
        Journey journey = null;
        List<Journey> journeys = new ArrayList<>();

        final String HOME = "Home";

        String memorizedBusStop = null;
        String memorizedLocation = null;
        LocalTime memorizedEvent = null;

        while ((line = bufferedReader.readLine()) != null) {

            if (line.startsWith("BEGIN:VCALENDAR")) {
                journey = new Journey();
                journey.setStartBusStop(homeBusStop);
                journey.setStartLocation(HOME);
                journey.setEndOfFinishedEvent(DateAndTimeConverter.timeFromKeyboardParser(timeOfLeavingHome));
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


            journey = new Journey();
            journey.setStartBusStop(memorizedBusStop);
            journey.setEndBusStop(homeBusStop);
            journey.setStartLocation(memorizedLocation);
            journey.setEndLocation(HOME);
            journey.setStartOfDestinedEvent(DateAndTimeConverter.timeFromKeyboardParser(timeOfArrivingHome));
            journey.setEndOfFinishedEvent(memorizedEvent);
            journeys.add(journey);

            return journeys;
    }
}