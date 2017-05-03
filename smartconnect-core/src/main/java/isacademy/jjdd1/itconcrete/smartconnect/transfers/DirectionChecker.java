package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;

import java.util.List;

public class DirectionChecker {

    public boolean checkDirection(List<BusStopDeltas> startDeltasList, List<BusStopDeltas> endDeltasList,
                                  BusStopDeltas currentStartDeltasList, BusStopDeltas currentEndDeltasList, String startBusStop, String endBusStop) {

        BusStopIndex busStopIndex = new BusStopIndex();

        boolean finalCondition = false;

        int startBusStopIndexInCurrentStartDeltasList = busStopIndex.checkBusStopIndex(startDeltasList, startBusStop);
//        System.out.println("startBusStopIndexInCurrentStartDeltasList = " + startBusStopIndexInCurrentStartDeltasList);
        int midBusStopIndexInCurrentStartDeltasList = busStopIndex.checkBusStopIndex(startDeltasList, currentStartDeltasList.getBusStopName());
//        System.out.println("midBusStopIndexInCurrentStartDeltasList = " + midBusStopIndexInCurrentStartDeltasList);

        boolean startStopBeforeMidStopInCurrentStartDeltasList = startBusStopIndexInCurrentStartDeltasList < midBusStopIndexInCurrentStartDeltasList;
//        System.out.println("startStopBeforeMidStopInCurrentStartDeltasList = " + startStopBeforeMidStopInCurrentStartDeltasList);

        int midBusStopIndexInCurrentEndDeltasList = busStopIndex.checkBusStopIndex(endDeltasList, currentEndDeltasList.getBusStopName());
//        System.out.println("midBusStopIndexInCurrentEndDeltasList = " + midBusStopIndexInCurrentEndDeltasList);
        int endBusStopIndexInCurrentEndDeltasList = busStopIndex.checkBusStopIndex(endDeltasList, endBusStop);
//        System.out.println("endBusStopIndexInCurrentEndDeltasList = " + endBusStopIndexInCurrentEndDeltasList);

        boolean midStopBeforeEndStopInCurrentEndDeltasList = midBusStopIndexInCurrentEndDeltasList < endBusStopIndexInCurrentEndDeltasList;
//        System.out.println("midStopBeforeEndStopInCurrentEndDeltasList = " + midStopBeforeEndStopInCurrentEndDeltasList);

        finalCondition = startStopBeforeMidStopInCurrentStartDeltasList && midStopBeforeEndStopInCurrentEndDeltasList;

        return finalCondition;

    }
}