package isacademy.jjdd1.itconcrete.smartconnect;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.*;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.JourneyCreator;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.DisplayConnection;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.QuestionAsker;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        ScheduleParser sp = new ScheduleParser();
        sp.loadData();
        ArrayList<BusLine> allBusLines = sp.getArrayOfBusLines();

        MinutesToBusStops minutesToBusStops = new MinutesToBusStops();
        ConnectionSeeker connectionSeeker = new ConnectionSeeker();
        DisplayConnection displayConnection = new DisplayConnection();

        BusLineSeeker busLineSeeker = new BusLineSeeker();
        CheckingBusStopExistence checkingBusStopExistence = new CheckingBusStopExistence();

        // interaction with user

        System.out.println("Hello! What is your home bus stop?");
        String homeBusStop = QuestionAsker.askForInfo();

        while (!checkingBusStopExistence.busStopExistence(homeBusStop, allBusLines) ) {
            System.out.println("Sorry, there is no '"+ homeBusStop + "' bus stop, try again");
            homeBusStop = QuestionAsker.askForInfo();
        }

        System.out.println("What time do you want to leave home? (Time Format HH:MM)");

        String timeOfLeavingHome = QuestionAsker.askForInfo();

        while (!timeOfLeavingHome.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
            System.out.println("Sorry, wrong time format, try again");
            timeOfLeavingHome = QuestionAsker.askForInfo();
        }

        System.out.println("What time do you want to get back home? (Time Format HH:MM)");

        String timeOfArrivingHome = QuestionAsker.askForInfo();

        while (!timeOfArrivingHome.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
            System.out.println("Sorry, wrong time format, try again");
            timeOfArrivingHome = QuestionAsker.askForInfo();
        }

        // end of interaction with user

        JourneyCreator journeyCreator = new JourneyCreator();
        List<Journey> journeys = journeyCreator.getJourneysList(homeBusStop, timeOfLeavingHome, timeOfArrivingHome);

        for (int i = 0; i < journeys.size(); i++) {

            System.out.println("");

            System.out.println("Event number " + (i+1) + ": ");

            String textForEachEvent = displayConnection.displayEventHeader(journeys.get(i));
            System.out.println(textForEachEvent);

            List<BusLine> foundBusLines = busLineSeeker.seekBusLine(journeys.get(i), allBusLines);

            List<LineRideTime> lineRideTimes = minutesToBusStops.calculateMinutesToBusStops(foundBusLines, journeys.get(i));

            List<ResultConnection> resultConnections = connectionSeeker.seekConnection(lineRideTimes, journeys.get(i));

            for (ResultConnection resultConnection : resultConnections) {
                String textForEachResult = displayConnection.displayingConnection(resultConnection);

                    System.out.println(textForEachResult);
            }

            if (resultConnections.size() == 0) {
                System.out.println("Sorry, there is no direct connection for this event.");
            }

            System.out.println("");

        }
    }
}

