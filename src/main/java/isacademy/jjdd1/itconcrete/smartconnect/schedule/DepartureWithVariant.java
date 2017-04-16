package isacademy.jjdd1.itconcrete.smartconnect.schedule;


import org.joda.time.LocalTime;

/**
 * Created by Ageee on 16.04.2017.
 */
public class DepartureWithVariant {

    private LocalTime timeOfDeparture;
    private String variant;

    public DepartureWithVariant(LocalTime timeOfDeparture, String variant) {
        this.timeOfDeparture = timeOfDeparture;
        this.variant = variant;
    }

    public LocalTime getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public String getVariant() {
        return variant;
    }

    @Override
    public String toString() {
        return "DepartureWithVariant{" +
                "timeOfDeparture=" + timeOfDeparture +
                ", variant='" + variant + '\'' +
                '}';
    }
}
