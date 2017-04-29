package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DeparturesFirstStop {

    private int lineNumber;
    private Direction direction;
    private ArrayList<DepartureWithVariant> departuresWithVariantWeekdays;
    private ArrayList<DepartureWithVariant> departuresWithVariantSaturdays;
    private ArrayList<DepartureWithVariant> departuresWithVariantSaturdaysSundaysAndHolidays;
    private ArrayList<DepartureWithVariant> departuresWithVariantSundaysAndHolidays;
    private List<LocalTime> departuresWeekdays;
    private List<LocalTime> departuresSaturdays;
    private List<LocalTime> departuresSaturdaysSundaysAndHolidays;
    private List<LocalTime> departuresSundaysAndHolidays;


    DeparturesFirstStop() {
    }

    DeparturesFirstStop(int lineNumber, Direction direction,
                               ArrayList<DepartureWithVariant> departuresWithVariantWeekdays,
                               ArrayList<DepartureWithVariant> departuresWithVariantSaturdays,
                               ArrayList<DepartureWithVariant> departuresWithVariantSaturdaysSundaysAndHolidays,
                               ArrayList<DepartureWithVariant> departuresWithVariantSundaysAndHolidays) {
        this.lineNumber = lineNumber;
        this.direction = direction;
        this.departuresWithVariantWeekdays = departuresWithVariantWeekdays;
        this.departuresWithVariantSaturdays = departuresWithVariantSaturdays;
        this.departuresWithVariantSaturdaysSundaysAndHolidays = departuresWithVariantSaturdaysSundaysAndHolidays;
        this.departuresWithVariantSundaysAndHolidays = departuresWithVariantSundaysAndHolidays;
    }

    ArrayList<DepartureWithVariant> getDeparturesWithVariantWeekdays() {
        return departuresWithVariantWeekdays;
    }

    ArrayList<DepartureWithVariant> getDeparturesWithVariantSaturdays() {
        return departuresWithVariantSaturdays;
    }

    ArrayList<DepartureWithVariant> getDeparturesWithVariantSaturdaysSundaysAndHolidays() {
        return departuresWithVariantSaturdaysSundaysAndHolidays;
    }

    ArrayList<DepartureWithVariant> getDeparturesWithVariantSundaysAndHolidays() {
        return departuresWithVariantSundaysAndHolidays;
    }

    List<LocalTime> getDeparturesWeekdays() {
        departuresWeekdays = new ArrayList<>();
        for (DepartureWithVariant departuresWithVariantWeekday : departuresWithVariantWeekdays) {
            departuresWeekdays.add(departuresWithVariantWeekday.getTimeOfDeparture());
        }
        return departuresWeekdays;
    }

    List<LocalTime> getDeparturesSaturdays() {
        departuresSaturdays = new ArrayList<>();
        for (DepartureWithVariant departuresWithVariantSaturday : departuresWithVariantSaturdays) {
            departuresSaturdays.add(departuresWithVariantSaturday.getTimeOfDeparture());
        }
        return departuresSaturdays;
    }

    List<LocalTime> getDeparturesSaturdaysSundaysAndHolidays() {
        departuresSaturdaysSundaysAndHolidays = new ArrayList<>();
        for (DepartureWithVariant departuresWithVariantSaturdaysSundaysAndHoliday : departuresWithVariantSaturdaysSundaysAndHolidays) {
            departuresSaturdaysSundaysAndHolidays.add(departuresWithVariantSaturdaysSundaysAndHoliday.getTimeOfDeparture());
        }
        return departuresSaturdaysSundaysAndHolidays;
    }

    List<LocalTime> getDeparturesSundaysAndHolidays() {
        departuresSundaysAndHolidays = new ArrayList<>();
        for (DepartureWithVariant departuresWithVariantSundaysAndHoliday : departuresWithVariantSundaysAndHolidays) {
            departuresSundaysAndHolidays.add(departuresWithVariantSundaysAndHoliday.getTimeOfDeparture());
        }
        return departuresSundaysAndHolidays;
    }
}
