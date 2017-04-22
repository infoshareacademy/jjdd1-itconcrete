package isacademy.jjdd1.itconcrete.smartconnect.calendar;


import isacademy.jjdd1.itconcrete.smartconnect.analyzer.DateAndTimeConverter;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.CapitalLetter;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;


public class CalendarParser {

    DateTimeFormatter parser = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss");
    DateTimeFormatter parserWithZAtTheEnd = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'");

    LinkedList<Event> events = new LinkedList<>();
    LinkedList<Event> sortedEvents;
    LinkedList<Journey> journeys = new LinkedList<>();
    Event event = new Event();


    LocalDateTime eightAm =LocalDateTime.from(parser.parse("20170101T080000"));


    public LinkedList<Journey> parseFileSortEventsAddHome(String homeBusStop, String timeOfLeavingHome, String timeOfArrivingHome) throws IOException, URISyntaxException {
        sortedEvents = sortEvents(readEvents());
        journeys = connectEventsIntoJourneys(HomeAsFirstAndLastEvent(sortedEvents, homeBusStop, timeOfLeavingHome, timeOfArrivingHome));
        return journeys;
    }

    public LinkedList<Event> readEvents() throws IOException, URISyntaxException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream("/kalendarz.ics")));

        String line;

        while ((line = bufferedReader.readLine()) != null) {

            if (line.startsWith("BEGIN:VEVENT")) {
                event = new Event();
            }
            if (line.startsWith("DTSTART")) {
                setStartDate(line, event);
            }
            if (line.startsWith("DTEND")) {
                setEndDate(line, event);
            }
            if (line.startsWith("LOCATION")) {
                setLocation(line, event);
            }
            if (line.startsWith("SUMMARY")) {
                setSummary(line, event);
            }
            if (line.startsWith("STATUS")) {
                setStatus(line,event);
            }
            if (line.startsWith("END:VEVENT")) {
                events.add(event);
            }
        }

        return events;
    }

    public Event setStartDate(String line, Event event) {

        LocalDateTime date =LocalDateTime.from(parser.parse(line.substring(8, 23)));
        event.setStartTime(date);
        return event;
    }
    public Event setEndDate(String line, Event event) {

        LocalDateTime date =LocalDateTime.from(parser.parse(line.substring(6, 21)));
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

    public LinkedList<Event> sortEvents(LinkedList<Event> events) {
        events.sort((e1,e2) -> e1.getStartTime().compareTo(e2.getStartTime()));
        return events;
    }

    public LinkedList<Event> HomeAsFirstAndLastEvent(LinkedList<Event> events, String homeBusStop, String timeOfLeavingHome, String timeOfArrivingHome ) {

        events.push(new Event(eightAm, DateAndTimeConverter.timeFromKeyboardParser(timeOfLeavingHome).atDate(LocalDate.now()), CapitalLetter.makeFirstLetterCapital(homeBusStop),"dom",true));
        events.add(new Event(DateAndTimeConverter.timeFromKeyboardParser(timeOfArrivingHome).atDate(LocalDate.now()),eightAm,CapitalLetter.makeFirstLetterCapital(homeBusStop),"dom",true));
        return events;
    }

    public LinkedList<Journey> connectEventsIntoJourneys(LinkedList<Event> events) {

        for (int i = 0; i <events.size()-1 ; i++) {

            String location0 = events.get(i).getLocation();
            String location1 = events.get(i+1).getLocation();
            String summary0 = events.get(i).getSummary();
            String summary1 = events.get(i+1).getSummary();
            LocalTime czas = events.get(i+1).getStartTime().toLocalTime();
            LocalTime czas1 = events.get(i).getEndTime().toLocalTime();

            Journey journey = new Journey(location0, location1,summary0,summary1,czas, czas1);

            journeys.add(journey);
        }
        return journeys;
    }

}