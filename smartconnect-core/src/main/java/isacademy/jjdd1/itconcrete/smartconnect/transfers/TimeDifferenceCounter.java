package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;
import java.util.ArrayList;
import java.util.List;

public class TimeDifferenceCounter {

    public List<TimeDifferenceSet> calculateTimeDifferenceSet(BusLineSetExtended busLineSetExtended) {

        List<TimeDifferenceSet> timeDifferenceSetList = new ArrayList<>();

        String startBusStop = busLineSetExtended.getStartBusStop();
        String endBusStop = busLineSetExtended.getEndBusStop();

        List<BusLineSet> busLineSetList = busLineSetExtended.getBusLineSetList();

        for (BusLineSet busLineSet : busLineSetList) {

            BusLine firstBusLine = busLineSet.getFirstBusLine();
            BusLine secondBusLine = busLineSet.getSecondBusLine();
            String midBusStop = busLineSet.getMidBusStop();

            List<BusStopDeltas> firstBusStopDeltas = firstBusLine.getRoute().getDeltasList();
            List<BusStopDeltas> secondBusStopDeltas = secondBusLine.getRoute().getDeltasList();

            TimeDifference timeDifference = new TimeDifference();

            int timeStartBusStopFirstLine = timeDifference.calculateTimeDifference(startBusStop, firstBusStopDeltas);
            int timeMidBusStopFirstLine = timeDifference.calculateTimeDifference(midBusStop, firstBusStopDeltas);
            int timeMidBusStopSecondLine = timeDifference.calculateTimeDifference(midBusStop, secondBusStopDeltas);
            int timeEndBusStopSecondLine = timeDifference.calculateTimeDifference(endBusStop, secondBusStopDeltas);

            timeDifferenceSetList.add(new TimeDifferenceSet(firstBusLine, timeStartBusStopFirstLine,
                    timeMidBusStopFirstLine, secondBusLine, timeMidBusStopSecondLine, timeEndBusStopSecondLine));
        }

//        System.out.println(timeDifferenceSetList);
        return timeDifferenceSetList;
    }
}
