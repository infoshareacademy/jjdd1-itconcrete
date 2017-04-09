package isacademy.jjdd1.itconcrete.smartconnect.schedule;

/**
 * Created by katarzynadobrowolska on 01.04.2017.
 */
public class BusConnection {

    int lineNumber;
    int direction;
    String departures[];

    public BusConnection(int lineNumber, int direction, String departures[]){
        this.lineNumber = lineNumber;
        this.direction = direction;
        this.departures = departures;
    }
}
