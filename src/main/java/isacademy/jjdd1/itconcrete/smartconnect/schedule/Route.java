package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import java.util.HashMap;

/**
 * Created by Ageee on 05.04.2017.
 */
public class Route {

    private int direction;
    private HashMap<Integer, String> hashMapOfStops;
    private String variant;

    public Route(int direction, HashMap<Integer, String> hashMapOfStops, String variant) {
        this.direction = direction;
        this.hashMapOfStops = hashMapOfStops;
        this.variant = variant;
    }

    public int getDirection() {
        return direction;
    }

    public HashMap<Integer, String> getHashMapOfStops() {
        return hashMapOfStops;
    }

    public String getVariant() {
        return variant;
    }
}
