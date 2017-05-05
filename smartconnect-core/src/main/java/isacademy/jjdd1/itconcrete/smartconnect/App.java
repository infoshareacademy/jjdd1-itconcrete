package isacademy.jjdd1.itconcrete.smartconnect;


import isacademy.jjdd1.itconcrete.smartconnect.analyzer.CompleteResult;
import isacademy.jjdd1.itconcrete.smartconnect.database.DBPromotedLine;

import isacademy.jjdd1.itconcrete.smartconnect.displayer.CompleteResultDisplayer;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.CompleteResultGetter;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.LinePromoter;
import isacademy.jjdd1.itconcrete.smartconnect.displayer.QuestionAsker;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.*;
import isacademy.jjdd1.itconcrete.smartconnect.util.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static Session session;

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);


    public static void main(String[] args) throws Exception {



        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        DBPromotedLine promotedLine = new DBPromotedLine(150);
        session.save(promotedLine);
        session.save(new DBPromotedLine(121));
        session.save(new DBPromotedLine(124));

        session.getTransaction().commit();


        LOGGER.info("Starting application.");
        LOGGER.trace("Schedules database is initialized.");

        ScheduleParser scheduleParser = new ScheduleParser();
        scheduleParser.loadData();
        ArrayList<BusLine> allBusLines = scheduleParser.getArrayOfBusLines();

        LOGGER.info("Asking for user input in order to define home location.");

        String homeBusStop = QuestionAsker.askForHome(allBusLines);
        String timeOfLeavingHome = QuestionAsker.askForTimeOfLeavingHome();
        String timeOfArrivingHome = QuestionAsker.askForTimeOfArrivingHome();

        LOGGER.debug("Home bus stop: " + homeBusStop);

        int maxAmountOfResultsAsInt = QuestionAsker.askForMaxAmountOfResults();

        LOGGER.info("Chosen amount of options to show: " + maxAmountOfResultsAsInt);

        CompleteResultDisplayer completeResultDisplayer = new CompleteResultDisplayer();
        CompleteResultGetter completeResultGetter = new CompleteResultGetter();
        List<CompleteResult> completeResultList;
        completeResultList = completeResultGetter.getCompleteResult(homeBusStop, timeOfLeavingHome, timeOfArrivingHome, maxAmountOfResultsAsInt, allBusLines);
        completeResultDisplayer.displayCompleteResult(completeResultList);





    }
}