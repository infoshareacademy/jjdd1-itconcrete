package com.isacademy.jjdd1.itconcrete.database;

import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteDirectResult;
import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteTransferResult;

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


    public void initialize(String home, List<CompleteDirectResult> direct, List<CompleteTransferResult> transfer){


        List<String> test = homeBusStopUpdater.getListOfAllHomeBusStops();
        System.out.println(test);
        homeBusStopUpdater.updateTable(home);

        int homeocc = homeBusStopUpdater.getValuForHomeBusStop(home);
        int bazy = homeBusStopUpdater.getValuForHomeBusStop("Bażyńskiego");
        int podk = homeBusStopUpdater.getValuForHomeBusStop("Podkarpacka");

        System.out.println("tralalalalala");
        System.out.println(home + " wystepuje w bazie: " + homeocc + " razy");
        System.out.println("Bazy wystepuje w bazie: " + bazy + " razy");
        System.out.println("Podk wystepuje w bazie: " + podk + " razy");

    }
}
