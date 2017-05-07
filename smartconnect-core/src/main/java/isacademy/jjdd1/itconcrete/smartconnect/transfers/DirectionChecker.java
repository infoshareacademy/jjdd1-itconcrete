package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;

import java.util.List;

class DirectionChecker {

    public boolean checkDirection(List<BusStopDeltas> firstLineDeltasList, List<BusStopDeltas> secondLineDeltasList,
                                  BusStopDeltas busStopDeltaFirstLine, BusStopDeltas busStopDeltaSecondLine, String startBusStop, String endBusStop) {

        boolean checkedDirection;

        BusStopIndexCounter busStopIndexCounter = new BusStopIndexCounter();

        int startBusStopIndexFirstLine = busStopIndexCounter.countBusStopIndex(firstLineDeltasList, startBusStop);
        int midBusStopIndexFirstLine = busStopIndexCounter.countBusStopIndex(firstLineDeltasList, busStopDeltaFirstLine.getBusStopName());

        boolean startStopBeforeMidStopFirstLine = startBusStopIndexFirstLine < midBusStopIndexFirstLine;

        int midBusStopIndexSecondLine = busStopIndexCounter.countBusStopIndex(secondLineDeltasList, busStopDeltaSecondLine.getBusStopName());
        int endBusStopIndexSecondLine = busStopIndexCounter.countBusStopIndex(secondLineDeltasList, endBusStop);
        boolean midStopBeforeEndStopSecondLine = midBusStopIndexSecondLine < endBusStopIndexSecondLine;

        checkedDirection = startStopBeforeMidStopFirstLine && midStopBeforeEndStopSecondLine;

        return checkedDirection;

    }






}