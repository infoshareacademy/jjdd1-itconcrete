package isacademy.jjdd1.itconcrete.smartconnect.map;

import java.util.Set;

public class LocationExistence {

    public boolean checkLocationExistence(String busStopName, Set<BusStopCoordinate> busStopCoordinates) {

        boolean exists = false;

        for (BusStopCoordinate busStopCoordinate : busStopCoordinates) {
            exists = busStopName.toLowerCase().equals(busStopCoordinate.getName().toLowerCase());

            if (exists) {
                break;
            }
        }
        return exists;
    }
}