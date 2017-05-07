package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class BusLinePairsSeeker {

    public BusLineSetExtended seekBusLinePairs(Journey journey) throws IOException {

        ScheduleParser sp = new ScheduleParser();
        sp.loadData();
        ArrayList<BusLine> allBusLines = sp.getArrayOfBusLines();
        String startBusStop = journey.getStartBusStop();
        String endBusStop = journey.getEndBusStop();

        List<BusLineSet> busLineSets = new ArrayList<>();
        PartBusLineSeeker partBusLineSeeker = new PartBusLineSeeker();

        List<BusLine> foundFirstBusLines = partBusLineSeeker.seekPartBusLine(allBusLines, startBusStop, endBusStop);
        List<BusLine> foundSecondBusLines = partBusLineSeeker.seekPartBusLine(allBusLines, endBusStop, startBusStop);

        for (BusLine foundFirstBusLine : foundFirstBusLines) {

            List<BusStopDeltas> firstLineDeltasList = foundFirstBusLine.getRoute().getDeltasList();

            for (BusLine foundSecondBusLine : foundSecondBusLines) {

                List<BusStopDeltas> secondLineDeltasList = foundSecondBusLine.getRoute().getDeltasList();

                for (BusStopDeltas busStopDeltaFirstLine : firstLineDeltasList) {

                    for (BusStopDeltas busStopDeltaSecondLine : secondLineDeltasList) {

                        String midBusStop = busStopDeltaFirstLine.getBusStopName();

                        DirectionChecker directionChecker = new DirectionChecker();
                        boolean checkedDirection = directionChecker.checkDirection(firstLineDeltasList, secondLineDeltasList, startBusStop, midBusStop, endBusStop);

                        SetExistence setExistence = new SetExistence();
                        boolean setExists = setExistence.checkSetExists(busLineSets, foundFirstBusLine, foundSecondBusLine);

                        boolean lineNumbersIdentical = (foundFirstBusLine.getLineNumber() == foundSecondBusLine.getLineNumber());
                        boolean sameBusStop = busStopDeltaFirstLine.getBusStopName().equals(busStopDeltaSecondLine.getBusStopName());
                        boolean firstLineRidesBusStop = busStopDeltaFirstLine.getTimeDifference() >= 0;
                        boolean secondLineRidesBusStop = busStopDeltaSecondLine.getTimeDifference() >= 0;


                        if (checkedDirection && !setExists && !lineNumbersIdentical && sameBusStop && firstLineRidesBusStop && secondLineRidesBusStop) {

                            busLineSets.add(new BusLineSet(foundFirstBusLine, midBusStop, foundSecondBusLine));
                        }
                    }
                }
            }
        }

        //fixme sa bledy filtracji wynikow? metody na sprawdzenie czy poprawne?

        BusLineSetExtended busLineSetExtended = new BusLineSetExtended(startBusStop, endBusStop, busLineSets);

        return busLineSetExtended;
    }
}
