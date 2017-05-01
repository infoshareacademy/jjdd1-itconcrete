package isacademy.jjdd1.itconcrete.smartconnect.schedule;


public class BusStopDeltas {

    private String busStopName;
    private int timeDifference;

    public BusStopDeltas(String busStopName, int timeDifference)  {
        this.busStopName = busStopName;
        this.timeDifference = timeDifference;
    }



    public String getBusStopName() {
        return busStopName;
    }

    public int getTimeDifference() {
        return timeDifference;
    }

    @Override
    public String toString() {
        return busStopName+", " + timeDifference;   }

}
