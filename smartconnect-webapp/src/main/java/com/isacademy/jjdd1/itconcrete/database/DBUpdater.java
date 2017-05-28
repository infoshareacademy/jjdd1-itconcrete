package com.isacademy.jjdd1.itconcrete.database;

import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.List;



@Singleton
public class DBUpdater {

    @Inject
    HomeBusStop homeBusStop;

    @Inject
    HomeBusStopUpdater homeBusStopUpdater;

    @Inject
    ResultBusStop resultBusStop;

    @Inject
    ResultBusLine resultBusLine;


    public void initialize(){

        List<String> test = homeBusStopUpdater.getListOfAllHomeBusStops();
        System.out.println(test);
        homeBusStopUpdater.updateTable("Klonowa");
        homeBusStopUpdater.updateTable("Niedźwiednik");
        int klonowaOccurences = homeBusStopUpdater.getValuForHomeBusStop("Klonowa");
        int emausOccurences = homeBusStopUpdater.getValuForHomeBusStop("Emaus");
        int niedzwiednik = homeBusStopUpdater.getValuForHomeBusStop("Niedźwiednik");
        System.out.println("Klonowa wystepuje w bazie: " + klonowaOccurences + " razy");
        System.out.println("Emaus wystepuje w bazie: " + emausOccurences + " razy");
        System.out.println("mis wystepuje w bazie: " + niedzwiednik + " razy");
        System.out.println("tralalalalala");
        System.out.println("Emaus wystepuje w bazie: " + emausOccurences + " razy");

    }
}
