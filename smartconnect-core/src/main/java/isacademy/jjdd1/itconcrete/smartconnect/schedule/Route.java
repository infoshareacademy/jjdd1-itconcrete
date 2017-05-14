package isacademy.jjdd1.itconcrete.smartconnect.schedule;


import java.util.List;
import java.util.Map;

public class Route {

    private Direction direction;
    private List<String> arrayOfStops;
    private int lineNumber;
    private List<BusStopDeltas> deltasList; //for X1
    private Map<String,String> stopsWithPosts;
    //private List<VariantX> variantXList; //for X1

    public Route(Direction direction, List<String> arrayOfStops,
                 int lineNumber, List<BusStopDeltas> deltasList, Map<String,String> stopsWithPosts) {
        this.direction = direction;
        this.arrayOfStops = arrayOfStops;
        this.lineNumber = lineNumber;
        this.deltasList = deltasList;
        this.stopsWithPosts = stopsWithPosts;
    }


    public Direction getDirection() {
        return direction;
    }

    public List<String> getArrayOfStops() {
        return arrayOfStops;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public List<BusStopDeltas> getDeltasList() {
        return deltasList;
    }

    public Map<String, String> getStopsWithPosts() {
        return stopsWithPosts;
    }

    @Override
    public String toString() {
        return "Route{" +
                "direction=" + direction +
                ", arrayOfStops=" + arrayOfStops +
                ", lineNumber=" + lineNumber +
                ", deltasList=" + deltasList +
                ", stopsWithPosts=" + stopsWithPosts +
                '}';
    }

    public boolean containsStops (String startBusStop, String endBusStop){
        if (arrayOfStops.contains(startBusStop) && arrayOfStops.contains(endBusStop)){
                if (arrayOfStops.indexOf(startBusStop) < arrayOfStops.indexOf(endBusStop)) {
                    return true;
                } else {
                    return false;
                }
            } else {
            return false;
        }
    }
}
