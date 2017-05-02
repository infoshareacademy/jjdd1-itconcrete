package isacademy.jjdd1.itconcrete.smartconnect.transfers;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransferBusLinesSeeker {

    public List<TransferBusLinePair> seekBusLinePairs (String startBusStop, String endBusStop)
            throws IOException, NoSuchFieldException, IllegalAccessException {


        ScheduleParser sp = null;
        sp = new ScheduleParser();
        sp.loadData();
        ArrayList<BusLine> allBusLines = sp.getArrayOfBusLines();

        List<TransferBusLinePair> transferBusLinePairs = new ArrayList<>();
        PartBusLineSeeker partBusLineSeeker = new PartBusLineSeeker();

        List<BusLine> confirmedStartPartBusLines = partBusLineSeeker.seekPartBusLine(allBusLines, startBusStop);
        List<BusLine> confirmedEndPartBusLines = partBusLineSeeker.seekPartBusLine(allBusLines, endBusStop);

        for (BusLine foundStartPartBusLine : confirmedStartPartBusLines) {

            List<BusStopDeltas> startDeltasList = foundStartPartBusLine.getRoute().getDeltasList();

            for (BusLine foundEndPartBusLine : confirmedEndPartBusLines) {

                List<BusStopDeltas> endDeltasList = foundEndPartBusLine.getRoute().getDeltasList();

                for (BusStopDeltas currentStartDeltasList : startDeltasList) {

                    for (BusStopDeltas currentEndDeltasList : endDeltasList) {

                        if (currentStartDeltasList.getBusStopName().equals(currentEndDeltasList.getBusStopName())){

                            boolean startStopBeforeMidStop = startDeltasList.indexOf(startBusStop) < startDeltasList.indexOf(currentStartDeltasList.getBusStopName());
                            boolean midStopBeforeEndStop = startDeltasList.indexOf(currentEndDeltasList.getBusStopName()) < endDeltasList.indexOf(endBusStop);

                            if (startStopBeforeMidStop && midStopBeforeEndStop) {

                                transferBusLinePairs.add(new TransferBusLinePair(foundStartPartBusLine,
                                        foundEndPartBusLine, currentStartDeltasList.getBusStopName()));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(transferBusLinePairs);
        return transferBusLinePairs;
    }
}
