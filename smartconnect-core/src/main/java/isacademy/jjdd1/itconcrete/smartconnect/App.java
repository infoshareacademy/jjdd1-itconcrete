package isacademy.jjdd1.itconcrete.smartconnect;

import isacademy.jjdd1.itconcrete.smartconnect.map.Stop;
import isacademy.jjdd1.itconcrete.smartconnect.map.StopsGetter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {

//        LOGGER.info("Starting application.");
//        LOGGER.trace("Schedules database is initialized.");
//
//        ScheduleParser scheduleParser = new ScheduleParser();
//        ArrayList<BusLine> allBusLines = scheduleParser.getArrayOfBusLines();
//
//
//        LOGGER.info("Asking for user input in order to define home location.");
//
//        String homeBusStop = QuestionAsker.askForHome(allBusLines);
//        String timeOfLeavingHome = QuestionAsker.askForTimeOfLeavingHome();
//        String timeOfArrivingHome = QuestionAsker.askForTimeOfArrivingHome();
//
//        LOGGER.debug("Home bus stop: " + homeBusStop);
//
//        CalendarParser calendarParser = new CalendarParser();
//        LinkedList<Journey> journeys = calendarParser.parseFileSortEventsAddHome(homeBusStop, timeOfLeavingHome, timeOfArrivingHome);
//
//        CompleteDirectResultGetter completeDirectResultGetter = new CompleteDirectResultGetter();
//        List<CompleteDirectResult> completeDirectResultList = completeDirectResultGetter.getCompleteResult(homeBusStop, timeOfLeavingHome, timeOfArrivingHome, allBusLines);
//
//        TransferResultGetter transferResultGetter = new TransferResultGetter();
//        List<CompleteTransferResult> completeTransferResultList = transferResultGetter.getTransfers(homeBusStop, timeOfLeavingHome, timeOfArrivingHome, allBusLines);
//
//
//        CompleteResultDisplayer completeResultDisplayer = new CompleteResultDisplayer();
//        completeResultDisplayer.displayCompleteResult(journeys, completeDirectResultList, completeTransferResultList);

        StopsGetter stopsGetter = new StopsGetter();
        List<Stop> stops = stopsGetter.getStops();
        System.out.println("stops = " + stops);

    }
}