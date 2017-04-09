package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ageee on 05.04.2017.
 */
public class Route {

    private int direction;
    private ArrayList<String> arrayOfStops;
    private String lineNumber;
    private List<BusStopDeltas> deltasList; //for X1
    private int amountOfStops;


    public Route(int direction, ArrayList<String> arrayOfStops, String lineNumber, List<BusStopDeltas> deltasList) {
        this.direction = direction;
        this.arrayOfStops = arrayOfStops;
        this.lineNumber = lineNumber;
        this.deltasList = deltasList;
    }

    public int getDirection() {
        return direction;
    }

    public ArrayList<String> getArrayOfStops() {
        return arrayOfStops;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public List<BusStopDeltas> getDeltasList() {
        return deltasList;
    }

    public int getAmountOfStops() {return arrayOfStops.size();}


    @Override
    public String toString() {
        return "Route{" +
                "direction=" + direction +
                ",\n arrayOfStops=" + arrayOfStops +
                ",\n lineNumber='" + lineNumber + '\'' +
                ",\n deltasList=" + deltasList +
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
