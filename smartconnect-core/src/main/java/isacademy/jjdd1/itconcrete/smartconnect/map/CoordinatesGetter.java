package isacademy.jjdd1.itconcrete.smartconnect.map;

import java.util.List;

public class CoordinatesGetter {

    public BusStopCoordinate getCoordinates(String busStopName, List<BusStopCoordinate> busStopCoordinates) {

        BusStopCoordinate validCoordinates = new BusStopCoordinate(busStopName, 0, 0);

        for (int i = 0; i < busStopCoordinates.size(); i++) {

            BusStopCoordinate busStopCoordinate = busStopCoordinates.get(i);

            if (busStopName.toLowerCase().equals(busStopCoordinate.getName().toLowerCase())) {

                validCoordinates.setLatitude(busStopCoordinate.getLatitude());
                validCoordinates.setLongitude(busStopCoordinate.getLongitude());
                break;
            }
        }

        return validCoordinates;
    }

}
