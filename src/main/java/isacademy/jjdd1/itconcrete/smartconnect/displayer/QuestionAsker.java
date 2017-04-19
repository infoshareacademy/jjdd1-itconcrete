package isacademy.jjdd1.itconcrete.smartconnect.displayer;
import isacademy.jjdd1.itconcrete.smartconnect.analyzer.BusLineSeeker;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionAsker {

    public static String askForInfo() {

        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        return info;
    }

    public static int askForIntInfo() {

        Scanner scanner = new Scanner(System.in);
        int info = scanner.nextInt();
        return info;
    }

    public static String askForHome(ArrayList<BusLine> allBusLines) {

        BusLineSeeker busLineSeeker = new BusLineSeeker();

        System.out.println("Hello! What is your home bus stop?");
        String homeBusStop = QuestionAsker.askForInfo();

        while (!busLineSeeker.busStopExistence(homeBusStop, allBusLines)) {
            System.out.println("Sorry, there is no '" + homeBusStop + "' bus stop, try again");
            homeBusStop = QuestionAsker.askForInfo();
        }
        return homeBusStop;
    }


    public static String askForTimeOfLeavingHome() {

        System.out.println("What time do you want to leave home? (Time Format HH:MM)");

        String timeOfLeavingHome = QuestionAsker.askForInfo();

        while (!timeOfLeavingHome.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
            System.out.println("Sorry, wrong time format, try again");
            timeOfLeavingHome = QuestionAsker.askForInfo();
        }
        return timeOfLeavingHome;
    }


    public static String askForTimeOfArrivingHome() {

        System.out.println("What time do you want to get back home? (Time Format HH:MM)");

        String timeOfArrivingHome = QuestionAsker.askForInfo();

        while (!timeOfArrivingHome.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
            System.out.println("Sorry, wrong time format, try again");
            timeOfArrivingHome = QuestionAsker.askForInfo();
        }
        return timeOfArrivingHome;
    }

    public static int askForMaxAmountOfResults() {

        System.out.println("What is the maximum amount of results you want to see? [1-10]");

        int maxResultsAmount = QuestionAsker.askForIntInfo();

        while (!Integer.toString(maxResultsAmount).matches("([1-9]|10)")) {
            System.out.println("Sorry, wrong time format, try again");
            maxResultsAmount = QuestionAsker.askForIntInfo();
        }
        return maxResultsAmount;
    }
}