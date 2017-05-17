package isacademy.jjdd1.itconcrete.smartconnect.analyzer_transfer;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer_alternative.Transfer;
import isacademy.jjdd1.itconcrete.smartconnect.analyzer_alternative.TransferSeekerAlternative;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TimeDifferenceCounter {

    public List<TimeDifferenceSet> calculateTimeDifferenceSet(BusLineSetExtended busLineSetExtended) throws IOException {

        List<TimeDifferenceSet> timeDifferenceSetList = new ArrayList<>();

        String startBusStop = busLineSetExtended.getStartBusStop();
        String endBusStop = busLineSetExtended.getEndBusStop();
        List<Transfer> transferList = busLineSetExtended.getPossibleTransfers();


        for (Transfer transfer : transferList) {

            BusLine firstBusLine = transfer.getStartLine();
            BusLine secondBusLine = transfer.getEndLine();
            String midBusStop = transfer.getCommonStops().get(0);

            List<BusStopDeltas> firstBusStopDeltas = firstBusLine.getRoute().getDeltasList();
            List<BusStopDeltas> secondBusStopDeltas = secondBusLine.getRoute().getDeltasList();

            TimeDifference timeDifference = new TimeDifference();

            int timeStartBusStopFirstLine = timeDifference.calculateTimeDifference(startBusStop, firstBusStopDeltas);
            int timeMidBusStopFirstLine = timeDifference.calculateTimeDifference(midBusStop, firstBusStopDeltas);
            int timeMidBusStopSecondLine = timeDifference.calculateTimeDifference(midBusStop, secondBusStopDeltas);
            int timeEndBusStopSecondLine = timeDifference.calculateTimeDifference(endBusStop, secondBusStopDeltas);

            timeDifferenceSetList.add(new TimeDifferenceSet(firstBusLine, timeStartBusStopFirstLine,
                    timeMidBusStopFirstLine, midBusStop, secondBusLine, timeMidBusStopSecondLine, timeEndBusStopSecondLine));
        }

        return timeDifferenceSetList;
    }
}
