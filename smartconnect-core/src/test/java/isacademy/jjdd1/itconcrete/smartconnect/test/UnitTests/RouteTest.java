package isacademy.jjdd1.itconcrete.smartconnect.test.UnitTests;


import isacademy.jjdd1.itconcrete.smartconnect.schedule.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;


public class RouteTest {

    private Route route;

    @Before
    public void setUp() throws Exception {
        Direction direction = Direction.direction_1;
        ArrayList<String> stops = new ArrayList<>(Arrays.asList("Jasień PKM", "Jasieńska", "Staw Wróbla", "Zacna"));
        int lineNumber = 142;
        ArrayList<BusStopDeltas> busStopDeltas = mock(ArrayList.class);
        HashMap<String,String> postsWithStopsMap = mock(HashMap.class);
        route = new Route(direction, stops, lineNumber, busStopDeltas,postsWithStopsMap);
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

    @Test
    public void getPostSygnature_returns_a_proper_format_post_sygnature(){
            String string = "B,P(2263)";
            int indexOfOpeningParentheses = string.indexOf("(");
            int indexOfClosingParentheses = string.indexOf(")");
            String post = string.substring(indexOfOpeningParentheses+1,indexOfClosingParentheses);
            assertThat(post).containsOnlyDigits();
            assertThat(post.length()).isGreaterThanOrEqualTo(3).isLessThanOrEqualTo(4);
    }
}
