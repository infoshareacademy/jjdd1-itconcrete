package isacademy.jjdd1.itconcrete.smartconnect.displayer;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class QuestionAsker {

    private static final Marker QUESTION_ASKER_MARKER = MarkerFactory.getMarker("QUESTION ASKER");
    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionAsker.class);

    public static String askForInfo() {

        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        return info;
    }

    public static String askForHome(ArrayList<BusLine> allBusLines) {

        Util util = new Util();

        LOGGER.trace(QUESTION_ASKER_MARKER, "Hello! What is your home bus stop?");
        String homeBusStop = QuestionAsker.askForInfo();

        while (!util.busStopExistence(homeBusStop, allBusLines)) {
            LOGGER.warn(QUESTION_ASKER_MARKER, "Sorry, there is no '" + homeBusStop + "' bus stop, try again");
            homeBusStop = QuestionAsker.askForInfo();
        }
        return homeBusStop;
    }


    public static String askForTimeOfLeavingHome() {

        LOGGER.trace(QUESTION_ASKER_MARKER,"What time do you want to leave home? (Time Format HH:MM)");

        String timeOfLeavingHome = QuestionAsker.askForInfo();

        while (!timeOfLeavingHome.matches("^([01][0-9]|2[0-3]):[0-5][0-9]$")) {
            LOGGER.warn(QUESTION_ASKER_MARKER,"Sorry, wrong time format, try again");
            timeOfLeavingHome = QuestionAsker.askForInfo();
        }
        return timeOfLeavingHome;
    }


    public static String askForTimeOfArrivingHome() {

        LOGGER.trace(QUESTION_ASKER_MARKER,"What time do you want to get back home? (Time Format HH:MM)");

        String timeOfArrivingHome = QuestionAsker.askForInfo();

        while (!timeOfArrivingHome.matches("^([01][0-9]|2[0-3]):[0-5][0-9]$")) {
            LOGGER.warn(QUESTION_ASKER_MARKER,"Sorry, wrong time format, try again");
            timeOfArrivingHome = QuestionAsker.askForInfo();
        }
        return timeOfArrivingHome;
    }

    public static int askForMaxAmountOfResults() {

        LOGGER.trace(QUESTION_ASKER_MARKER,"What is the maximum amount of results you want to see? [1-10]");

        String maxResultsAmount = QuestionAsker.askForInfo();

        while (!maxResultsAmount.matches("(10|[1-9])")) {

            LOGGER.warn(QUESTION_ASKER_MARKER, "Sorry, wrong number, try again");

            maxResultsAmount = QuestionAsker.askForInfo();
        }

        int maxResultAmountAsInt = Integer.valueOf(maxResultsAmount);

        return maxResultAmountAsInt;
    }
}