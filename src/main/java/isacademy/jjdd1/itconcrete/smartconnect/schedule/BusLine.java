package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import org.joda.time.LocalTime;
import java.util.ArrayList;

public class BusLine {

    private final int lineNumber;
    private final Route route;
    private final DeparturesFirstStop departures;

    public BusLine(int lineNumber, Route route, DeparturesFirstStop departuresFirstStop) {
        this.lineNumber = lineNumber;
        this.route = route;
        this.departures = departuresFirstStop;
    }


    public int getLineNumber() {
        return lineNumber;
    }

    public Route getRoute() {
        return route;
    }

    public ArrayList<DepartureWithVariant> getDeparturesWeekdays() {
        return departures.getDeparturesWeekdays();
    }

    public ArrayList<DepartureWithVariant> getDeparturesSaturdays() {
        return departures.getDeparturesSaturdays();
    }

    public ArrayList<DepartureWithVariant> getDeparturesSundaysAndHolidays() {
        return departures.getDeparturesSundaysAndHolidays();
    }

    public ArrayList<DepartureWithVariant> getDeparturesSaturdaysSundaysAndHolidays() {
        return departures.getDeparturesSaturdaysSundaysAndHolidays();
    }
}