package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Route {

    private Direction direction;
    private ArrayList<String> arrayOfStops;
    private int lineNumber;
    private List<BusStopDeltas> deltasList; //for X1
    private HashMap<String,String> stopsWithPosts;
    //private List<VariantX> variantXList; //for X1

    public Route(Direction direction, ArrayList<String> arrayOfStops,
                 int lineNumber, List<BusStopDeltas> deltasList, HashMap<String,String> stopsWithPosts) {
        this.direction = direction;
        this.arrayOfStops = arrayOfStops;
        this.lineNumber = lineNumber;
        this.deltasList = deltasList;
        this.stopsWithPosts = stopsWithPosts;
    }


    public Direction getDirection() {
        return direction;
    }

    public ArrayList<String> getArrayOfStops() {
        return arrayOfStops;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public List<BusStopDeltas> getDeltasList() {
        return deltasList;
    }

    public HashMap<String, String> getStopsWithPosts() {
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
