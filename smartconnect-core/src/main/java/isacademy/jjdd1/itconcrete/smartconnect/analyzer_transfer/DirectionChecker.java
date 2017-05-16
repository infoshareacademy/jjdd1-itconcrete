package isacademy.jjdd1.itconcrete.smartconnect.analyzer_transfer;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;

import java.util.List;

class DirectionChecker {

    public boolean checkDirection(List<BusStopDeltas> firstLineDeltasList, List<BusStopDeltas> secondLineDeltasList, String startBusStop, String midBusStop, String endBusStop) {

        boolean checkedDirection;

        BusStopIndexCounter busStopIndexCounter = new BusStopIndexCounter();

        int startBusStopIndexFirstLine = busStopIndexCounter.countBusStopIndex(firstLineDeltasList, startBusStop);
        int midBusStopIndexFirstLine = busStopIndexCounter.countBusStopIndex(firstLineDeltasList, midBusStop);

        if (startBusStopIndexFirstLine == -1 || midBusStopIndexFirstLine == -1) {
            checkedDirection = false;
            return checkedDirection;
        }

        boolean startStopBeforeMidStopFirstLine = startBusStopIndexFirstLine < midBusStopIndexFirstLine;

        int midBusStopIndexSecondLine = busStopIndexCounter.countBusStopIndex(secondLineDeltasList, midBusStop);
        int endBusStopIndexSecondLine = busStopIndexCounter.countBusStopIndex(secondLineDeltasList, endBusStop);

        if (midBusStopIndexSecondLine == -1 || endBusStopIndexSecondLine == -1) {
            checkedDirection = false;
            return checkedDirection;
        }

        boolean midStopBeforeEndStopSecondLine = midBusStopIndexSecondLine < endBusStopIndexSecondLine;

        checkedDirection = startStopBeforeMidStopFirstLine && midStopBeforeEndStopSecondLine;

        return checkedDirection;

    }


}