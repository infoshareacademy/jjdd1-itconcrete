package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BusLinePairsSeeker {

    public BusLineSetExtended seekBusLinePairs(Journey journey)
            throws IOException, NoSuchFieldException, IllegalAccessException {

        ScheduleParser sp = new ScheduleParser();
        sp.loadData();
        ArrayList<BusLine> allBusLines = sp.getArrayOfBusLines();
        String startBusStop = journey.getStartBusStop();
        String endBusStop = journey.getEndBusStop();

        List<BusLineSet> busLineSets = new ArrayList<>();
        PartBusLineSeeker partBusLineSeeker = new PartBusLineSeeker();

        List<BusLine> foundFirstBusLines = partBusLineSeeker.seekPartBusLine(allBusLines, startBusStop);
        List<BusLine> foundSecondBusLines = partBusLineSeeker.seekPartBusLine(allBusLines, endBusStop);

        for (BusLine foundFirstBusLine : foundFirstBusLines) {

            List<BusStopDeltas> firstLineDeltasList = foundFirstBusLine.getRoute().getDeltasList();

            for (BusLine foundSecondBusLine : foundSecondBusLines) {

                List<BusStopDeltas> secondLineDeltasList = foundSecondBusLine.getRoute().getDeltasList();

                for (BusStopDeltas busStopDeltaFirstLine : firstLineDeltasList) {

                    for (BusStopDeltas busStopDeltaSecondLine : secondLineDeltasList) {

                        if (busStopDeltaFirstLine.getBusStopName().equals(busStopDeltaSecondLine.getBusStopName()) &&
                                busStopDeltaFirstLine.getTimeDifference() >= 0 && busStopDeltaSecondLine.getTimeDifference() >= 0) {

                            DirectionChecker directionChecker = new DirectionChecker();

                            boolean checkedDirection = directionChecker.checkDirection(firstLineDeltasList, secondLineDeltasList,
                                    busStopDeltaFirstLine, busStopDeltaSecondLine, startBusStop, endBusStop);

                            BusLineIndex busLineIndex = new BusLineIndex();

                            if (busLineSets.size() > 0) {

                                boolean addsToList = busLineIndex.checkAddingToList(busLineSets, foundFirstBusLine, foundSecondBusLine);

                                if (checkedDirection && (foundFirstBusLine.getLineNumber() != foundSecondBusLine.getLineNumber()) && addsToList) {
                                    busLineSets.add(new BusLineSet(foundFirstBusLine, busStopDeltaFirstLine.getBusStopName(), foundSecondBusLine));

                                }
                            } else {

                                if (checkedDirection && (foundFirstBusLine.getLineNumber() != foundSecondBusLine.getLineNumber())) {
                                    busLineSets.add(new BusLineSet(foundFirstBusLine, busStopDeltaFirstLine.getBusStopName(), foundSecondBusLine));
                                }
                            }
                        }
                    }
                }
            }
        }

        BusLineSetExtended busLineSetExtended = new BusLineSetExtended(startBusStop, endBusStop, busLineSets);
        return busLineSetExtended;
    }
}
