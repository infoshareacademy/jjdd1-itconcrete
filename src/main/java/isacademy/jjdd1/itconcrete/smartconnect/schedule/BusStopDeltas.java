package isacademy.jjdd1.itconcrete.smartconnect.schedule;

/**
 * Created by katarzynadobrowolska on 06.04.2017.
 */
public class BusStopDeltas {
    String name;
    int time;

    public BusStopDeltas(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }
}
