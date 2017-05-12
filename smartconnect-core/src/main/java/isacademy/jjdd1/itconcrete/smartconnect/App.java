package isacademy.jjdd1.itconcrete.smartconnect;

import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarParser;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.CompleteResultDisplayer;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.QuestionAsker;
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

        ScheduleParser scheduleParser = new ScheduleParser();
        ArrayList<BusLine> allBusLines = scheduleParser.getArrayOfBusLines();


        LOGGER.info("Asking for user input in order to define home location.");

        String homeBusStop = QuestionAsker.askForHome(allBusLines);
        String timeOfLeavingHome = QuestionAsker.askForTimeOfLeavingHome();
        String timeOfArrivingHome = QuestionAsker.askForTimeOfArrivingHome();

        LOGGER.debug("Home bus stop: " + homeBusStop);

        int maxAmountOfResultsAsInt = 3; //QuestionAsker.askForMaxAmountOfResults();

        LOGGER.info("Chosen amount of options to show: " + maxAmountOfResultsAsInt);

        CalendarParser calendarParser = new CalendarParser();
        LinkedList<Journey> journeys = calendarParser.parseFileSortEventsAddHome(homeBusStop, timeOfLeavingHome, timeOfArrivingHome);

        CompleteDirectResultGetter completeDirectResultGetter = new CompleteDirectResultGetter();
        List<CompleteDirectResult> completeDirectResultList = completeDirectResultGetter.getCompleteResult(homeBusStop, timeOfLeavingHome, timeOfArrivingHome, maxAmountOfResultsAsInt, allBusLines);

        TransferResultGetter transferResultGetter = new TransferResultGetter();
        List<CompleteTransferResult> completeTransferResultList = transferResultGetter.getTransfers(homeBusStop, timeOfLeavingHome, timeOfArrivingHome, maxAmountOfResultsAsInt, allBusLines);


        CompleteResultDisplayer completeResultDisplayer = new CompleteResultDisplayer();
        completeResultDisplayer.displayCompleteResult(journeys, completeDirectResultList, completeTransferResultList);

    }
}