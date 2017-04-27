package isacademy.jjdd1.itconcrete.smartconnect.analyzer;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class TransferSeeker {

    private List<BusLine> seekPartBusLine(ArrayList<BusLine> busLinesForSeeking, String busStop) {

        List<BusLine> foundPartBusLines = new ArrayList<>();

        for (BusLine currentlyCheckedBusLine : busLinesForSeeking) {
            List<BusStopDeltas> deltasList = currentlyCheckedBusLine.getRoute().getDeltasList();
            for (BusStopDeltas currentlyCheckedBusStopDelta : deltasList) {
                if (currentlyCheckedBusStopDelta.getBusStopName().equals(busStop)) {
                    foundPartBusLines.add(currentlyCheckedBusLine);
                }
            }
        }
        return foundPartBusLines;
    }



    public List<List<BusLine>> seekTransfer (String startBusStop, String endBusStop)
            throws IOException, NoSuchFieldException, IllegalAccessException {

        ScheduleParser sp = null;
        try {
            sp = new ScheduleParser();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        sp.loadData();
        ArrayList<BusLine> allBusLines = sp.getArrayOfBusLines();

        List<BusLine> foundPartStartBusLine = new ArrayList<>();
        List<BusLine> foundPartEndBusLine = new ArrayList<>();

        List<BusLine> confirmedStartPartBusLines = seekPartBusLine(allBusLines, startBusStop);
        List<BusLine> confirmedEndPartBusLines = seekPartBusLine(allBusLines, endBusStop);

        for (BusLine foundStartPartBusLine : confirmedStartPartBusLines) {

            List<BusStopDeltas> startDeltasList = foundStartPartBusLine.getRoute().getDeltasList();

            for (BusLine foundEndPartBusLine : confirmedEndPartBusLines) {

                List<BusStopDeltas> endDeltasList = foundEndPartBusLine.getRoute().getDeltasList();

                for (BusStopDeltas currentStartDeltasList : startDeltasList) {

                    for (BusStopDeltas currentEndDeltasList : endDeltasList) {

                        if (currentStartDeltasList.equals(currentEndDeltasList)){

                            foundPartStartBusLine.add(foundStartPartBusLine);
                            foundPartEndBusLine.add(foundEndPartBusLine);

                        }
                    }
                }
            }
        }

        List<List<BusLine>> foundStartEndPartBusLine = new ArrayList<>();

        foundStartEndPartBusLine.add(foundPartStartBusLine);
        foundStartEndPartBusLine.add(foundPartEndBusLine);

        return foundStartEndPartBusLine;
    }
}