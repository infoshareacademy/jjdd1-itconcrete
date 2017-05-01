package isacademy.jjdd1.itconcrete.smartconnect.test;


import isacademy.jjdd1.itconcrete.smartconnect.schedule.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;


public class RouteTest {

    private Route route;

    @Before
    public void setUp() throws Exception {
        Direction direction = Direction.direction_1;
        ArrayList<String> stops = new ArrayList<>(Arrays.asList("Jasień PKM", "Jasieńska", "Staw Wróbla", "Zacna"));
        int lineNumber = 142;
        ArrayList<BusStopDeltas> bsd = mock(ArrayList.class);
        route = new Route(direction, stops, lineNumber, bsd);
    }

    @Test
    public void route_should_have_defined_direction(){
        assertThat(route.getDirection()).isNotEqualTo(Direction.undefined);
    }

    @Test
    public void route_has_direction_1_or_2(){
        assertThat(route.getDirection()).isIn(Direction.direction_1, Direction.direction_2);
    }

    @Test
    public void route_contains_stops_returns_true_if_it_does(){
        String stop1 = "Jasień PKM";
        String stop2 = "Zacna";
        assertThat(route.containsStops(stop1,stop2)).isTrue();
    }

    @Test
    public void route_contains_stops_returns_false_if_it_does_not(){
        String stop1 = "Jasień PKM";
        String stop2 = "Emaus";
        assertThat(route.containsStops(stop1,stop2)).isFalse();
    }

    @Test
    public void route_contains_stops_returns_true_only_if_start_stop_is_first_in_route(){
        String startStop = "Jasień PKM";
        String endStop = "Zacna";
        assertThat(route.containsStops(startStop,endStop)).isTrue();
        assertThat(route.containsStops(endStop,startStop)).isFalse();
    }
}
