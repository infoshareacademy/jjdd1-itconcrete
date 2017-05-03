package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransferBusLinesSeeker {

    public List<TransferBusLineSet> seekBusLinePairs(String startBusStop, String endBusStop)
            throws IOException, NoSuchFieldException, IllegalAccessException {

        int check = 0;
        ScheduleParser sp = null;
        sp = new ScheduleParser();
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

                            int startBusStopIndexInCurrentStartDeltasList = checkBusStopIndex(startDeltasList, startBusStop);
//                            System.out.println("startBusStopIndexInCurrentStartDeltasList = " + startBusStopIndexInCurrentStartDeltasList);
                            int midBusStopIndexInCurrentStartDeltasList = checkBusStopIndex(startDeltasList, currentStartDeltasList.getBusStopName());
//                            System.out.println("midBusStopIndexInCurrentStartDeltasList = " + midBusStopIndexInCurrentStartDeltasList);

                            boolean startStopBeforeMidStopInCurrentStartDeltasList = startBusStopIndexInCurrentStartDeltasList < midBusStopIndexInCurrentStartDeltasList;
//                            System.out.println("startStopBeforeMidStopInCurrentStartDeltasList = " + startStopBeforeMidStopInCurrentStartDeltasList);

                            int midBusStopIndexInCurrentEndDeltasList = checkBusStopIndex(endDeltasList, currentEndDeltasList.getBusStopName());
//                            System.out.println("midBusStopIndexInCurrentEndDeltasList = " + midBusStopIndexInCurrentEndDeltasList);
                            int endBusStopIndexInCurrentEndDeltasList = checkBusStopIndex(endDeltasList, endBusStop);
//                            System.out.println("endBusStopIndexInCurrentEndDeltasList = " + endBusStopIndexInCurrentEndDeltasList);

                            boolean midStopBeforeEndStopInCurrentEndDeltasList = midBusStopIndexInCurrentEndDeltasList < endBusStopIndexInCurrentEndDeltasList;
//                            System.out.println("midStopBeforeEndStopInCurrentEndDeltasList = " + midStopBeforeEndStopInCurrentEndDeltasList);

                            if (startStopBeforeMidStopInCurrentStartDeltasList && midStopBeforeEndStopInCurrentEndDeltasList) {
                                transferBusLineSets.add(new TransferBusLineSet(foundStartPartBusLine, currentStartDeltasList.getBusStopName(), foundEndPartBusLine));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(transferBusLineSets);
        return transferBusLineSets;
    }


    public int checkBusStopIndex(List<BusStopDeltas> busStopDeltas, String busStop) {

        int index = 0;
        int i = 0;

        for (i = 1; i < busStopDeltas.size(); i++) {

            if (busStopDeltas.get(i).getBusStopName().toLowerCase().equals(busStop.toLowerCase())) {
                index = i;
            }
        }
        return index;
    }

}
