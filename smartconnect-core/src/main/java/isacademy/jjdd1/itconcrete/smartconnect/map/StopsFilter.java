package isacademy.jjdd1.itconcrete.smartconnect.map;

import java.util.HashSet;
import java.util.Set;

public class StopsFilter {

    public Set<Coordinates> filterStops(Set<Stop> stops){



        Set<Coordinates> coordinatesSet = new HashSet<>();

        for (Stop stop : stops) {

            String stopCode = stop.getStopCode();

            if (stopCode != null) {

                String stopName = stop.getStopName();
                Float stopLat = stop.getStopLat();
                Float stopLon = stop.getStopLon();

                coordinatesSet.add(new Coordinates(stopName, stopLat, stopLon));

            }
        }

        return coordinatesSet;
    }


}
