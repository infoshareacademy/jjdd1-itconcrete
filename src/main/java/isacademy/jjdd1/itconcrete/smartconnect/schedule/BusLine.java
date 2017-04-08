package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import org.joda.time.LocalTime;

/**
 * Created by katarzynadobrowolska on 06.04.2017.
 */
public class BusLine {
    private int lineNumber;
    private Route route;
    private LocalTime departures[];

    public BusLine(int lineNumber, Route route, LocalTime[] departures) {
        this.lineNumber = lineNumber;
        this.route = route;
        this.departures = departures;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public Route getRoute() {
        return route;
    }

    public LocalTime[] getDepartures() {
        return departures;
    }
}