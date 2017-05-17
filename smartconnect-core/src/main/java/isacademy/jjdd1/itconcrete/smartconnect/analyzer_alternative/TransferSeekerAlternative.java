package isacademy.jjdd1.itconcrete.smartconnect.analyzer_alternative;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.Route;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;


public class TransferSeekerAlternative {

    private List<BusLine> allBusLines;
    private String start;
    private String end;

    private List<BusLine> starts = new ArrayList<>();
    private List<BusLine> ends = new ArrayList<>();
    private List<Transfer> possibleTransfers = new ArrayList<>();

    public TransferSeekerAlternative(List<BusLine> allBusLines, String start, String end) {
        this.allBusLines = allBusLines;
        this.start = start;
        this.end = end;
        findAllStartsAndEnds();
        findTransfer();
    }

    private void findAllStartsAndEnds(){
        for (int i = 0; i < allBusLines.size() ; i++) {
            Route route = allBusLines.get(i).getRoute();
            if (route.getArrayOfStops().contains(start) && !route.getArrayOfStops().contains(end)){
                starts.add(allBusLines.get(i));
                continue;
            } else if (route.getArrayOfStops().contains(end)  && !route.getArrayOfStops().contains(start)){
                ends.add(allBusLines.get(i));
                continue;
            }
        }
    }


    private void findTransfer(){

        for (int i = 0; i < starts.size(); i++) {

            List<String> currentStartRoute = starts.get(i).getRoute().getArrayOfStops();

            for (int j = 0; j < ends.size(); j++) {

                List<String> currentEndRoute = ends.get(j).getRoute().getArrayOfStops();
                List<String> common = currentStartRoute.stream().filter(currentEndRoute::contains).collect(toList());
                Transfer transfer = new Transfer(starts.get(i), ends.get(j));

                int indexOfStart = currentStartRoute.indexOf(start);
                int indexOfEnd = currentEndRoute.indexOf(end);
                int indexOfFirstCommonStopInStartRoute = -1;
                int indexOfFirstCommonStopInEndRoute = -1;

                if (!common.isEmpty()){
                    indexOfFirstCommonStopInStartRoute = currentStartRoute.indexOf(common.get(0));
                    indexOfFirstCommonStopInEndRoute = currentEndRoute.indexOf(common.get(0));
                } else {
                    continue;
                }

                if (!common.contains(start) && !common.contains(end) && !possibleTransfers.contains(transfer)
                        && indexOfStart < indexOfFirstCommonStopInStartRoute && indexOfEnd > indexOfFirstCommonStopInEndRoute){
                    possibleTransfers.add(transfer);
                }

            }

        }

    }

    public List<Transfer> getPossibleTransfers() {
        return possibleTransfers;
    }

    @Override
    public String toString() {
        return "TransferSeekerAlternative{" +
                "possibleTransfers=" + possibleTransfers +
                '}';
    }
}
