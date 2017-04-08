package isacademy.jjdd1.itconcrete.smartconnect.schedule;

/**
 * Created by katarzynadobrowolska on 01.04.2017.
 */
public class BusConnection {

    int busNumber;
    int direction;
    String departures[];

    public BusConnection(int busNumber, int direction, String departures[]){
        this.busNumber = busNumber;
        this.direction = direction;
        this.departures = departures;
    }
}
