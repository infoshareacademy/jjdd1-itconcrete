package isacademy.jjdd1.itconcrete.smartconnect.map;

import java.util.ArrayList;
import java.util.List;

public class CoordinatesSetter {

    public List<BusStopCoordinate> setCoordinates(){

        List<BusStopCoordinate> busStopCoordinates = new ArrayList<>();

        busStopCoordinates.add(new BusStopCoordinate("Klonowa", 54.380526, 18.601262));
        busStopCoordinates.add(new BusStopCoordinate("Miszewskiego", 54.375870, 18.615669));
        busStopCoordinates.add(new BusStopCoordinate("Galeria Bałtycka", 54.382600, 18.598511));
        busStopCoordinates.add(new BusStopCoordinate("Dworzec Główny PKP",54.355254, 18.644596));

        return busStopCoordinates;
    }
}
