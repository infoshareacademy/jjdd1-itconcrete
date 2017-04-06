package isacademy.jjdd1.itconcrete.smartconnect.schedule;

/**
 * Created by katarzynadobrowolska on 01.04.2017.
 */
public class BusConnection {

    int number;
    int direction;
    String departures[];

    public BusConnection(int number, int direction, String departures[]){
        this.number = number;
        this.direction = direction;
        this.departures = departures;
    }
}
