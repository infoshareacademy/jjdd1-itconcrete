package isacademy.jjdd1.itconcrete.smartconnect.map;

import java.util.Set;

public class CoordinatesGetter {

    public Coordinates getCoordinates(String busStopName, Set<Coordinates> coordinatesSet) {

        Coordinates validCoordinates = new Coordinates(busStopName, 0, 0);

        for (Coordinates coordinates : coordinatesSet) {

            if (busStopName.toLowerCase().equals(coordinates.getName().toLowerCase())) {

                validCoordinates.setLatitude(coordinates.getLatitude());
                validCoordinates.setLongitude(coordinates.getLongitude());
                break;
            }
        }

        return validCoordinates;
    }

}
