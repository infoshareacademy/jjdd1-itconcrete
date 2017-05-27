package isacademy.jjdd1.itconcrete.smartconnect.map;

import java.util.HashSet;
import java.util.Set;

public class CoordinatesSetter {

    public Set<BusStopCoordinate> setCoordinates(){

        Set<BusStopCoordinate> busStopCoordinates = new HashSet<>();

        busStopCoordinates.add(new BusStopCoordinate("Klonowa", 54.380526, 18.601262));
        busStopCoordinates.add(new BusStopCoordinate("Miszewskiego", 54.375870, 18.615669));
        busStopCoordinates.add(new BusStopCoordinate("Galeria Bałtycka", 54.382600, 18.598511));
        busStopCoordinates.add(new BusStopCoordinate("Dworzec Główny PKP",54.355254, 18.644596));

        return busStopCoordinates;
    }
}
