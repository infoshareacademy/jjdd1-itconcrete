package isacademy.jjdd1.itconcrete.smartconnect;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.TransferSeeker;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.CompleteResultDisplayer;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.QuestionAsker;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;


public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {

//        LOGGER.info("Starting application.");
//        LOGGER.trace("Schedules database is initialized.");

        ScheduleParser scheduleParser = new ScheduleParser();
        scheduleParser.loadData();
        ArrayList<BusLine> allBusLines = scheduleParser.getArrayOfBusLines();

//        LOGGER.info("Asking for user input in order to define home location.");

        String homeBusStop = QuestionAsker.askForHome(allBusLines);
        String timeOfLeavingHome = QuestionAsker.askForTimeOfLeavingHome();
        String timeOfArrivingHome = QuestionAsker.askForTimeOfArrivingHome();

//        LOGGER.debug("Home bus stop: " + homeBusStop);

        int maxAmountOfResultsAsInt = QuestionAsker.askForMaxAmountOfResults();

//        LOGGER.info("Chosen amount of options to show: " + maxAmountOfResultsAsInt);

        TransferSeeker transferSeeker = new TransferSeeker();
        transferSeeker.seekTransfer("Klonowa","Galeria Bałtycka");

        CompleteResultDisplayer completeResultDisplayer = new CompleteResultDisplayer();
        completeResultDisplayer.displayCompleteResult(homeBusStop, timeOfLeavingHome, timeOfArrivingHome, maxAmountOfResultsAsInt, allBusLines);

    }
}