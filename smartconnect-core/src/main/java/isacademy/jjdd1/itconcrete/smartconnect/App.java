package isacademy.jjdd1.itconcrete.smartconnect;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;
import isacademy.jjdd1.itconcrete.smartconnect.transfers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

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


        TransferGetter transferGetter = new TransferGetter();
        transferGetter.displayTransfers( 5);

    }
}