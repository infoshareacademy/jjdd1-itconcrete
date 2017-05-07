package isacademy.jjdd1.itconcrete.smartconnect;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.CompleteResult;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarParser;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.CompleteResultDisplayer;
import isacademy.jjdd1.itconcrete.smartconnect.analyzer.CompleteResultGetter;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;
import isacademy.jjdd1.itconcrete.smartconnect.transfers.*;
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

        ScheduleParser scheduleParser = new ScheduleParser();
        scheduleParser.loadData();
        ArrayList<BusLine> allBusLines = scheduleParser.getArrayOfBusLines();

        LOGGER.info("Asking for user input in order to define home location.");

//        String homeBusStop = QuestionAsker.askForHome(allBusLines);
//        String timeOfLeavingHome = QuestionAsker.askForTimeOfLeavingHome();
//        String timeOfArrivingHome = QuestionAsker.askForTimeOfArrivingHome();
//
//        LOGGER.debug("Home bus stop: " + homeBusStop);
//
//        int maxAmountOfResultsAsInt = QuestionAsker.askForMaxAmountOfResults();
//
//        LOGGER.info("Chosen amount of options to show: " + maxAmountOfResultsAsInt);

//        CompleteResultDisplayer completeResultDisplayer = new CompleteResultDisplayer();
//        CompleteResultGetter completeResultGetter = new CompleteResultGetter();
//        List<CompleteResult> completeResultList;
//        completeResultList = completeResultGetter.getCompleteResult("klonowa", "06:00", "22:00", 3, allBusLines);
//        completeResultDisplayer.displayCompleteResult(completeResultList);

        CalendarParser calendarParser = new CalendarParser();
        LinkedList<Journey> journeys = calendarParser.parseFileSortEventsAddHome("klonowa", "08:00", "17:00");

        TransferDisplayer transferDisplayer = new TransferDisplayer();
        transferDisplayer.displayTransfers(journeys, 10);

    }
}