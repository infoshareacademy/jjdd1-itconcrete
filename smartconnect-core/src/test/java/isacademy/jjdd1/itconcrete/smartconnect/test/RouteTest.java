package isacademy.jjdd1.itconcrete.smartconnect.test;


import isacademy.jjdd1.itconcrete.smartconnect.schedule.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;


public class RouteTest {

    private Route route;

    @Before
    public void setUp() throws Exception {
        Direction direction = Direction.direction_1;
        ArrayList<String> stops = mock(ArrayList.class);
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
}
