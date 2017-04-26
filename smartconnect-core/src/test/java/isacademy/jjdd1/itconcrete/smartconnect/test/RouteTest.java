package isacademy.jjdd1.itconcrete.smartconnect.test;


import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.Direction;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.Route;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


public class RouteTest {

    @Test
    public void route_should_have_defined_direction(){
        Route sut = new Route(Direction.direction_1, new ArrayList<String>(), 136, new ArrayList<BusStopDeltas>());
        sut.getDirection();
        assertThat(sut.getDirection()).isNotEqualTo(Direction.undefined);

    }
}
