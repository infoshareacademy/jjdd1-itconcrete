package isacademy.jjdd1.itconcrete.smartconnect.data;

/**
 * Created by katarzynadobrowolska on 01.04.2017.
 */
public class BusConnection {

    int number;
    String busStop;
    String direction;
    String departures[];

    public BusConnection(int number, String direction, String busStop, String departures[]){
        this.number = number;
        this.direction = direction;
        this.busStop = busStop;
        this.departures = departures;
    }
}
