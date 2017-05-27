package isacademy.jjdd1.itconcrete.smartconnect.map;

import java.util.HashSet;
import java.util.Set;

public class CoordinatesSetter {

    public Set<Coordinates> setCoordinates(){

        Set<Coordinates> coordinates = new HashSet<>();

        coordinates.add(new Coordinates("Klonowa", 54.380526, 18.601262));
        coordinates.add(new Coordinates("Miszewskiego", 54.375870, 18.615669));
        coordinates.add(new Coordinates("Galeria Bałtycka", 54.382600, 18.598511));
        coordinates.add(new Coordinates("Dworzec Główny PKP",54.355254, 18.644596));

        return coordinates;
    }
}
