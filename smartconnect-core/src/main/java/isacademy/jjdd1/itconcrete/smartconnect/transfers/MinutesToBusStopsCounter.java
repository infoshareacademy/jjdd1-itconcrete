package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;
import java.util.ArrayList;
import java.util.List;

public class MinutesToBusStopsCounter {

    public List<TransferMinutesToBusStop> calculateTransfersMinutesToBusStops(TransferSetForSeeking transferSetForSeeking) {

        List<TransferMinutesToBusStop> transferMinutesToBusStopList = new ArrayList<>();

        String startBusStop = transferSetForSeeking.getStartBusStop();
        String endBusStop = transferSetForSeeking.getEndBusStop();

        List<TransferBusLineSet> transferBusLineSetList = transferSetForSeeking.getTransferBusLineSetList();

        for (TransferBusLineSet transferBusLineSet : transferBusLineSetList) {

            BusLine startBusLine = transferBusLineSet.getStartBusLine();
            BusLine endBusLine = transferBusLineSet.getEndBusLine();
            String midBusStop = transferBusLineSet.getMidBusStop();

            List<BusStopDeltas> startBusLineBusStopDeltas = startBusLine.getRoute().getDeltasList();
            List<BusStopDeltas> endBusLineBusStopDeltas = endBusLine.getRoute().getDeltasList();

            int timeToStartBusStopOnStartLine = calculateTimeToReachBusStop(startBusStop, startBusLineBusStopDeltas);
            int timeToMidBusStopOnStartLine = calculateTimeToReachBusStop(midBusStop, startBusLineBusStopDeltas);
            int timeToMidBusStopOnEndLine = calculateTimeToReachBusStop(midBusStop, endBusLineBusStopDeltas);
            int timeToEndBusStopOnEndLine = calculateTimeToReachBusStop(endBusStop, endBusLineBusStopDeltas);

            transferMinutesToBusStopList.add(new TransferMinutesToBusStop(startBusLine, timeToStartBusStopOnStartLine,
                    timeToMidBusStopOnStartLine, endBusLine, timeToMidBusStopOnEndLine, timeToEndBusStopOnEndLine));
        }

        System.out.println(transferMinutesToBusStopList);
        return transferMinutesToBusStopList;
    }


    private int calculateTimeToReachBusStop (String busStop, List<BusStopDeltas> deltasList) {

        int timeToReachBusStopFromFirstBusStop = 0;
        for (BusStopDeltas busStopDeltas : deltasList) {
            if (busStopDeltas.getTimeDifference() > 0){
                timeToReachBusStopFromFirstBusStop += busStopDeltas.getTimeDifference();}

            if (busStopDeltas.getBusStopName().toLowerCase().equals(busStop.toLowerCase())) {
                break;
            }
        }
        return timeToReachBusStopFromFirstBusStop;
    }
}
