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

        homeBusStopUpdater.updateTable(home);

    }
}
