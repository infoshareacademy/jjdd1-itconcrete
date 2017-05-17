package isacademy.jjdd1.itconcrete.smartconnect.analyzer_alternative;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.Route;

import java.util.List;

/**
 * Created by agatabereza on 17.05.17.
 */
public class TransferSeekerAlternative {

    private List<BusLine> allBusLines;
    private String start;
    private String end;

    private List<RouteAndIndex> starts;
    private List<RouteAndIndex> ends;
    private List<Transfer> possibleTransfers;

    public TransferSeekerAlternative(List<BusLine> allBusLines, String start, String end) {
        this.allBusLines = allBusLines;
        this.start = start;
        this.end = end;
        findAllStarts();
        findAllEnds();
        findTransfer();

    }

    private void findAllStarts(){
        for (int i = 0; i < allBusLines.size() ; i++) {
            Route route = allBusLines.get(i).getRoute();
            if (route.getArrayOfStops().contains(start) && !route.getArrayOfStops().contains(end)){
                starts.add(new RouteAndIndex(route, route.getArrayOfStops().indexOf(start)));
                continue;
            }
        }
    }

    private void findAllEnds(){
        for (int i = 0; i < allBusLines.size() ; i++) {
            Route route = allBusLines.get(i).getRoute();
            if (route.getArrayOfStops().contains(end)  && !route.getArrayOfStops().contains(start)){
                ends.add(new RouteAndIndex(route, route.getArrayOfStops().indexOf(end)));
                continue;
            }
        }
    }


    //TODO START HERE AT HOME!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private void findTransfer(){

        for (int i = 0; i < starts.size() ; i++) {
            String activeStop = null;
            starts.get(i).getRoute();

        }

    }



    public List<RouteAndIndex> getStarts() {
        return starts;
    }

    public void setStarts(List<RouteAndIndex> starts) {
        this.starts = starts;
    }

    public List<RouteAndIndex> getEnds() {
        return ends;
    }

    public void setEnds(List<RouteAndIndex> ends) {
        this.ends = ends;
    }
}
