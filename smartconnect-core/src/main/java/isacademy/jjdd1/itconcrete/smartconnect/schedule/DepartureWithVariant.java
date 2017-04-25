package isacademy.jjdd1.itconcrete.smartconnect.schedule;


import java.time.LocalTime;

public class DepartureWithVariant {

    private LocalTime timeOfDeparture;
    private String variant;

    DepartureWithVariant(LocalTime timeOfDeparture, String variant) {
        this.timeOfDeparture = timeOfDeparture;
        this.variant = variant;
    }

    LocalTime getTimeOfDeparture() {
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
