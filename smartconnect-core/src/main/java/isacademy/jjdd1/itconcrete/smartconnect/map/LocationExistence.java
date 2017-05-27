package isacademy.jjdd1.itconcrete.smartconnect.map;

import java.util.Set;

public class LocationExistence {

    public boolean checkLocationExistence(String busStopName, Set<Coordinates> coordinatesSet) {

        boolean exists = false;

        for (Coordinates coordinates : coordinatesSet) {
            exists = busStopName.toLowerCase().equals(coordinates.getName().toLowerCase());

            if (exists) {
                break;
            }
        }
        return exists;
    }
}
