package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import java.util.HashMap;
import java.util.List;

/**
 * Created by katarzynadobrowolska on 06.04.2017.
 */
public class Route {
    private int direction;
    private List<BusStopDeltas> deltasList;
    private String variant;

    public Route(int direction, List<BusStopDeltas> deltasList, String variant) {
        this.direction = direction;
        this.deltasList = deltasList;
        this.variant = variant;
    }

    public int getDirection() {
        return direction;
    }

    public List<BusStopDeltas> getDeltasList() {
        return deltasList;
    }

    public String getVariant() {
        return variant;
    }
}
