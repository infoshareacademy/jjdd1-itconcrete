package isacademy.jjdd1.itconcrete.smartconnect.schedule;

/**
 * Created by Ageee on 05.04.2017.
 */
public class BusLine {

    private int lineNumber;
    private Route route;

    public BusLine(int lineNumber, Route route) {
        this.lineNumber = lineNumber;
        this.route = route;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public Route getRoute() {
        return route;
    }
}
