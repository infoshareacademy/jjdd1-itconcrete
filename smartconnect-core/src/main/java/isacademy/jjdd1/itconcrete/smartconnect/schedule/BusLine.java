package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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

    public List<DepartureWithVariant> getDeparturesWeekdaysWithVariant() {
        return departures.getDeparturesWithVariantWeekdays();
    }

    public List<DepartureWithVariant> getDeparturesSaturdaysWithVariant() {
        return departures.getDeparturesWithVariantSaturdays();
    }

    public List<DepartureWithVariant> getDeparturesSundaysAndHolidaysWithVariant() {
        return departures.getDeparturesWithVariantSundaysAndHolidays();
    }

    public List<DepartureWithVariant> getDeparturesSaturdaysSundaysAndHolidaysWithVariant() {
        return departures.getDeparturesWithVariantSaturdaysSundaysAndHolidays();
    }

    public List<LocalTime> getDeparturesWeekdays() {
        return departures.getDeparturesWeekdays();
    }

    public List<LocalTime> getDeparturesSaturdays() {
        return departures.getDeparturesSaturdays();
    }

    public List<LocalTime> getDeparturesSundaysAndHolidays() {
        return departures.getDeparturesSundaysAndHolidays();
    }

    public List<LocalTime> getDeparturesSaturdaysSundaysAndHolidays() {
        return departures.getDeparturesSaturdaysSundaysAndHolidays();
    }

    @Override
    public String toString() {
        return "BusLine{" +
                "lineNumber=" + lineNumber +
                ", route=" + route +
                ", departures=" + departures +
                '}' + "/n";
    }
}