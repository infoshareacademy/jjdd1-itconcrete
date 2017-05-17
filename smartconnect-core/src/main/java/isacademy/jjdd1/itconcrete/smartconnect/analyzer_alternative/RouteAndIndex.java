package isacademy.jjdd1.itconcrete.smartconnect.analyzer_alternative;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.Route;

/**
 * Created by agatabereza on 17.05.17.
 */
public class RouteAndIndex {

    private Route route;
    private int index;

    public RouteAndIndex(Route route, int index) {
        this.route = route;
        this.index = index;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "RouteAndIndex{" +
                "route=" + route +
                ", index=" + index +
                '}';
    }
}
