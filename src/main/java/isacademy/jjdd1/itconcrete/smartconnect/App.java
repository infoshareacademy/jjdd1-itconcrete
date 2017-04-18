package isacademy.jjdd1.itconcrete.smartconnect;

import isacademy.jjdd1.itconcrete.smartconnect.displayer.CompleteResultDisplayer;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.QuestionAsker;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.*;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws Exception {

        ScheduleParser sp = new ScheduleParser();
        sp.loadData();
        ArrayList<BusLine> allBusLines = sp.getArrayOfBusLines();

        String homeBusStop = QuestionAsker.askForHome(allBusLines);
        String timeOfLeavingHome = QuestionAsker.askForTimeOfLeavingHome();
        String timeOfArrivingHome = QuestionAsker.askForTimeOfArrivingHome();

        CompleteResultDisplayer completeResultDisplayer = new CompleteResultDisplayer();
        completeResultDisplayer.displayCompleteResult(homeBusStop, timeOfLeavingHome, timeOfArrivingHome, allBusLines);

    }
}