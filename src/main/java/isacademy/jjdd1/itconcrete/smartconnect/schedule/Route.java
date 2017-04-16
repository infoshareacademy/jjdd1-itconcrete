package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import java.util.ArrayList;
import java.util.List;

public class Route {

    private Direction direction;
    private ArrayList<String> arrayOfStops;
    private int lineNumber;
    private List<VariantX> variantXList; //for X1


    public Route(Direction direction, ArrayList<String> arrayOfStops, int lineNumber, List<VariantX> variantXList) {
        this.direction = direction;
        this.arrayOfStops = arrayOfStops;
        this.lineNumber = lineNumber;
        this.variantXList = variantXList;
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

    public List<VariantX> getVariantXList() {
        return variantXList;
    }

    public int getAmountOfStops() {return arrayOfStops.size();}


    @Override
    public String toString() {
        return "Route{" +
                "direction=" + direction +
                ",\n arrayOfStops=" + arrayOfStops +
                ",\n lineNumber='" + lineNumber + '\'' +
                ",\n variantXList=" + variantXList +
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
