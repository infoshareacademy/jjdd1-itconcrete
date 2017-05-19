package isacademy.jjdd1.itconcrete.smartconnect;

import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarParser;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.CompleteResultDisplayer;
import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteDirectResult;
import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteDirectResultGetter;
import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteTransferResult;
import isacademy.jjdd1.itconcrete.smartconnect.result.TransferResultGetter;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {

        LOGGER.info("Starting application.");
        LOGGER.trace("Schedules database is initialized.");

        long scheduleParserStart = System.currentTimeMillis();

        ScheduleParser scheduleParser = new ScheduleParser();
        ArrayList<BusLine> allBusLines = scheduleParser.getArrayOfBusLines();

        long scheduleParserEnd = System.currentTimeMillis();
        long scheduleParserTime = scheduleParserEnd - scheduleParserStart;
        System.out.println("scheduleParserTime = " + scheduleParserTime);

        LOGGER.info("Asking for user input in order to define home location.");

        String homeBusStop = "Klonowa";//QuestionAsker.askForHome(allBusLines);
        String timeOfLeavingHome = "06:00";//QuestionAsker.askForTimeOfLeavingHome();
        String timeOfArrivingHome = "22:00";//QuestionAsker.askForTimeOfArrivingHome();

        LOGGER.debug("Home bus stop: " + homeBusStop);

        long calendarParserStart = System.currentTimeMillis();

        CalendarParser calendarParser = new CalendarParser();
        LinkedList<Journey> journeys = calendarParser.parseFileSortEventsAddHome(homeBusStop, timeOfLeavingHome, timeOfArrivingHome);

        long calendarParserEnd = System.currentTimeMillis();
        long calendarParserTime = calendarParserEnd - calendarParserStart;
        System.out.println("calendarParserTime = " + calendarParserTime);

        long directStart = System.currentTimeMillis();

        CompleteDirectResultGetter completeDirectResultGetter = new CompleteDirectResultGetter();
        List<CompleteDirectResult> completeDirectResultList = completeDirectResultGetter.getCompleteResult(homeBusStop, timeOfLeavingHome, timeOfArrivingHome, allBusLines);

        long directEnd = System.currentTimeMillis();
        long directTime = directEnd - directStart;
        System.out.println("directTime = " + directTime);

        long transferStart = System.currentTimeMillis();

        TransferResultGetter transferResultGetter = new TransferResultGetter();
        List<CompleteTransferResult> completeTransferResultList = transferResultGetter.getTransfers(homeBusStop, timeOfLeavingHome, timeOfArrivingHome, allBusLines);

        long transferEnd = System.currentTimeMillis();
        long transferTime = transferEnd - transferStart;
        System.out.println("transferTime = " + transferTime);

        long displayerStart = System.currentTimeMillis();

        CompleteResultDisplayer completeResultDisplayer = new CompleteResultDisplayer();
        completeResultDisplayer.displayCompleteResult(journeys, completeDirectResultList, completeTransferResultList);

        long displayerEnd = System.currentTimeMillis();
        long displayerTime = displayerEnd - displayerStart;
        System.out.println("displayerTime = " + displayerTime);
    }
}