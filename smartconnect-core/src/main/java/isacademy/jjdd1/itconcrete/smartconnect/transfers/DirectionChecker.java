package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;
import java.util.List;

public class DirectionChecker {

    public boolean checkDirection(List<BusStopDeltas> firstLineDeltasList, List<BusStopDeltas> secondLineDeltasList,
                                  BusStopDeltas busStopDeltaFirstLine, BusStopDeltas busStopDeltaSecondLine, String startBusStop, String endBusStop) {

        BusStopIndex busStopIndex = new BusStopIndex();

        boolean checkedDirection = false;

        int startBusStopIndexFirstLine = busStopIndex.checkBusStopIndex(firstLineDeltasList, startBusStop);
        int midBusStopIndexFirstLine = busStopIndex.checkBusStopIndex(firstLineDeltasList, busStopDeltaFirstLine.getBusStopName());
        boolean startStopBeforeMidStopFirstLine = startBusStopIndexFirstLine < midBusStopIndexFirstLine;

        int midBusStopIndexSecondLine = busStopIndex.checkBusStopIndex(secondLineDeltasList, busStopDeltaSecondLine.getBusStopName());
        int endBusStopIndexSecondLine = busStopIndex.checkBusStopIndex(secondLineDeltasList, endBusStop);
        boolean midStopBeforeEndStopSecondLine = midBusStopIndexSecondLine < endBusStopIndexSecondLine;

        checkedDirection = startStopBeforeMidStopFirstLine && midStopBeforeEndStopSecondLine;

        return checkedDirection;

    }






}