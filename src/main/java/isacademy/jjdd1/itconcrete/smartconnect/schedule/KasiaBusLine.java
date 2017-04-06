package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import org.joda.time.LocalTime;

/**
 * Created by katarzynadobrowolska on 06.04.2017.
 */
public class KasiaBusLine {
    private int lineNumber;
    private KasiaRoute route;
    private LocalTime departures[];

    public KasiaBusLine(int lineNumber, KasiaRoute route, LocalTime[] departures) {
        this.lineNumber = lineNumber;
        this.route = route;
        this.departures = departures;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public KasiaRoute getRoute() {
        return route;
    }

    public LocalTime[] getDepartures() {
        return departures;
    }
}
