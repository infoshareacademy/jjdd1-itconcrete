package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransferBusLinesSeeker {

    public TransferSetForSeeking seekBusLinePairs(String startBusStop, String endBusStop)
            throws IOException, NoSuchFieldException, IllegalAccessException {

        ScheduleParser sp = new ScheduleParser();
        sp.loadData();
        ArrayList<BusLine> allBusLines = sp.getArrayOfBusLines();

        List<TransferBusLineSet> transferBusLineSets = new ArrayList<>();
        PartBusLineSeeker partBusLineSeeker = new PartBusLineSeeker();

        List<BusLine> confirmedStartPartBusLines = partBusLineSeeker.seekPartBusLine(allBusLines, startBusStop);
        List<BusLine> confirmedEndPartBusLines = partBusLineSeeker.seekPartBusLine(allBusLines, endBusStop);

        for (BusLine foundStartPartBusLine : confirmedStartPartBusLines) {

            List<BusStopDeltas> startDeltasList = foundStartPartBusLine.getRoute().getDeltasList();

            for (BusLine foundEndPartBusLine : confirmedEndPartBusLines) {

                List<BusStopDeltas> endDeltasList = foundEndPartBusLine.getRoute().getDeltasList();

                for (BusStopDeltas currentStartDeltasList : startDeltasList) {

                    for (BusStopDeltas currentEndDeltasList : endDeltasList) {

                        if (currentStartDeltasList.getBusStopName().equals(currentEndDeltasList.getBusStopName()) &&
                                currentStartDeltasList.getTimeDifference() >= 0 && currentEndDeltasList.getTimeDifference() >= 0) {

                            DirectionChecker directionChecker = new DirectionChecker();

                            boolean finalCondition = directionChecker.checkDirection(startDeltasList, endDeltasList,
                                    currentStartDeltasList, currentEndDeltasList, startBusStop, endBusStop);

                            if (finalCondition) {
                                transferBusLineSets.add(new TransferBusLineSet(foundStartPartBusLine, currentStartDeltasList.getBusStopName(), foundEndPartBusLine));
                            }
                        }
                    }
                }
            }
        }

        TransferSetForSeeking transferSetForSeeking = new TransferSetForSeeking(startBusStop, endBusStop, transferBusLineSets);
        return transferSetForSeeking;
    }
}
