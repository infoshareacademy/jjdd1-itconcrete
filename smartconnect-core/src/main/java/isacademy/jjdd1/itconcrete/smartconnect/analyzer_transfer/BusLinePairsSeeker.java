package isacademy.jjdd1.itconcrete.smartconnect.analyzer_transfer;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer_alternative.Transfer;
import isacademy.jjdd1.itconcrete.smartconnect.analyzer_alternative.TransferSeekerAlternative;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BusLinePairsSeeker {

    public BusLineSetExtended seekBusLinePairs(Journey journey, ArrayList<BusLine> allBusLines) throws IOException {


        String startBusStop = journey.getStartBusStop();
        String endBusStop = journey.getEndBusStop();

        TransferSeekerAlternative transferSeekerAlternative = new TransferSeekerAlternative(allBusLines, startBusStop, endBusStop);
        List<Transfer> possibleTransfers = transferSeekerAlternative.getPossibleTransfers();

//        List<BusLineSet> busLineSets = new ArrayList<>();
//        PartBusLineSeeker partBusLineSeeker = new PartBusLineSeeker();
//
//        List<BusLine> foundFirstBusLines = partBusLineSeeker.seekPartBusLine(allBusLines, startBusStop, endBusStop);
//        List<BusLine> foundSecondBusLines = partBusLineSeeker.seekPartBusLine(allBusLines, endBusStop, startBusStop);
//
//        for (BusLine foundFirstBusLine : foundFirstBusLines) {
//
//            List<BusStopDeltas> firstLineDeltasList = foundFirstBusLine.getRoute().getDeltasList();
//
//            for (BusLine foundSecondBusLine : foundSecondBusLines) {
//
//                List<BusStopDeltas> secondLineDeltasList = foundSecondBusLine.getRoute().getDeltasList();
//
//                for (BusStopDeltas busStopDeltaFirstLine : firstLineDeltasList) {
//
//                    for (BusStopDeltas busStopDeltaSecondLine : secondLineDeltasList) {
//
//                        String midBusStop = busStopDeltaFirstLine.getBusStopName();
//
//                        boolean firstLineRidesMidStop = (busStopDeltaFirstLine.getTimeDifference() >=0);
//                        boolean secondLineRidesMidStop = (busStopDeltaFirstLine.getTimeDifference() >=0);
//                        boolean bothLinesRideMidBusStop = firstLineRidesMidStop && secondLineRidesMidStop;
//
//                        DirectionChecker directionChecker = new DirectionChecker();
//                        boolean checkedDirection = directionChecker.checkDirection(firstLineDeltasList, secondLineDeltasList, startBusStop, midBusStop, endBusStop);
//
//                        SetExistence setExistence = new SetExistence();
//                        boolean setExists = setExistence.checkSetExists(busLineSets, foundFirstBusLine, foundSecondBusLine);
//
//                        boolean busLinesIdentical = (foundFirstBusLine == foundSecondBusLine);
//                        boolean sameBusStop = busStopDeltaFirstLine.getBusStopName().equals(busStopDeltaSecondLine.getBusStopName());
//                        boolean firstLineRidesBusStop = busStopDeltaFirstLine.getTimeDifference() >= 0;
//                        boolean secondLineRidesBusStop = busStopDeltaSecondLine.getTimeDifference() >= 0;
//
//
//                        if (checkedDirection && !setExists && !busLinesIdentical && sameBusStop
//                                && firstLineRidesBusStop && secondLineRidesBusStop && bothLinesRideMidBusStop) {
//
//                            busLineSets.add(new BusLineSet(foundFirstBusLine, midBusStop, foundSecondBusLine));
//                        }
//                    }
//                }
//            }
//        }

        BusLineSetExtended busLineSetExtended = new BusLineSetExtended(startBusStop, endBusStop, possibleTransfers);

        return busLineSetExtended;
    }
}
