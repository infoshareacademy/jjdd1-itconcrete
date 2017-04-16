package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import java.util.ArrayList;

/**
 * Created by Ageee on 13.04.2017.
 */
public class DeparturesFirstStop {

    private int lineNumber;
    private Direction direction;
    private ArrayList<DepartureWithVariant> departuresWeekdays;
    private ArrayList<DepartureWithVariant> departuresSaturdays;
    private ArrayList<DepartureWithVariant> departuresSaturdaysSundaysAndHolidays;
    private ArrayList<DepartureWithVariant> departuresSundaysAndHolidays;

    public DeparturesFirstStop() {
    }

    public DeparturesFirstStop(int lineNumber, Direction direction,
                               ArrayList<DepartureWithVariant> departuresWeekdays,
                               ArrayList<DepartureWithVariant> departuresSaturdays,
                               ArrayList<DepartureWithVariant> departuresSaturdaysSundaysAndHolidays,
                               ArrayList<DepartureWithVariant> departuresSundaysAndHolidays) {
        this.lineNumber = lineNumber;
        this.direction = direction;
        this.departuresWeekdays = departuresWeekdays;
        this.departuresSaturdays = departuresSaturdays;
        this.departuresSundaysAndHolidays = departuresSaturdaysSundaysAndHolidays;
        this.departuresSundaysAndHolidays = departuresSundaysAndHolidays;
    }

    public ArrayList<DepartureWithVariant> getDeparturesWeekdays() {
        return departuresWeekdays;
    }

    public ArrayList<DepartureWithVariant> getDeparturesSaturdays() {
        return departuresSaturdays;
    }

    public ArrayList<DepartureWithVariant> getDeparturesSaturdaysSundaysAndHolidays() {
        return departuresSaturdaysSundaysAndHolidays;
    }

    public ArrayList<DepartureWithVariant> getDeparturesSundaysAndHolidays() {
        return departuresSundaysAndHolidays;
    }
}
