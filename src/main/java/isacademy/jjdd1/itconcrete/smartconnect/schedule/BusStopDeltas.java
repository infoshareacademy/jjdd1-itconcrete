package isacademy.jjdd1.itconcrete.smartconnect.schedule;

/**
 * Created by katarzynadobrowolska on 06.04.2017.
 */
public class BusStopDeltas {
    String busStopName;
    int timeDifference;

    public BusStopDeltas(String busStopName, int timeDifference) {
        this.busStopName = busStopName;
        this.timeDifference = timeDifference;
    }

    public String getBusStopName() {
        return busStopName;
    }

    public int getTimeDifference() {
        return timeDifference;
    }
}
