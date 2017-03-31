package isacademy.jjdd1.itconcrete.smartconnect.calculator;

/**
 * Created by agatabereza on 31.03.17.
 */
public class PathFinder {

    public int calculatePathLength(Path path) {
        return path.getFromStreet() * path.getToStreet();
    }
}
