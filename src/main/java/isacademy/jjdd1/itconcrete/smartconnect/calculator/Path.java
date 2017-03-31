package isacademy.jjdd1.itconcrete.smartconnect.calculator;

/**
 * Created by agatabereza on 31.03.17.
 */
public class Path {
    private int fromStreet;
    private int toStreet;

    public Path(int fromStreet, int toStreet) {
        this.fromStreet = fromStreet;
        this.toStreet = toStreet;
    }

    public int getFromStreet() {
        return fromStreet;
    }

    public int getToStreet() {
        return toStreet;
    }

}
