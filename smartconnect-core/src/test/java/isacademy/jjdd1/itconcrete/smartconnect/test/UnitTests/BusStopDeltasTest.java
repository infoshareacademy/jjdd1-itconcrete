package isacademy.jjdd1.itconcrete.smartconnect.test.UnitTests;


import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class BusStopDeltasTest {

    private static final int MIN_DELTA_VALUE = -1;
    private static ScheduleParser scheduleParser;
    private BusStopDeltas busStopDelta;
    private List<String> busStopNames;


    @BeforeClass
    public static void setupScheduleParser() throws IOException {
        scheduleParser = new ScheduleParser();
    }


    @Before
    public void setUp() throws Exception {
        String busStopName = "Emaus";
        int timeDifference = -1;
        busStopDelta = new BusStopDeltas(busStopName,timeDifference);
        busStopNames = scheduleParser.getAllBusStopNames();
    }

    @Test
    public void busStopDelta_has_stop_name_present_in_database (){
        assertThat(busStopDelta.getBusStopName()).isIn(busStopNames);
    }

    @Test
    public void busStopDelta_time_difference_is_not_lower_than_minimum (){
        assertThat(busStopDelta.getTimeDifference()).isGreaterThanOrEqualTo(MIN_DELTA_VALUE);
    }

    @Test
    public void busStopDelta_time_difference_is_not_null(){
        assertThat(busStopDelta.getTimeDifference()).isNotNull();
    }


}
