package isacademy.jjdd1.itconcrete.smartconnect.schedule;

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
