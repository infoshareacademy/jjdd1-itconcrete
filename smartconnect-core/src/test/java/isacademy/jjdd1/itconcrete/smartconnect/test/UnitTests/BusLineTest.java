package isacademy.jjdd1.itconcrete.smartconnect.test.UnitTests;


import isacademy.jjdd1.itconcrete.smartconnect.schedule.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class BusLineTest {

    private static int THE_LOWEST_LINE_NUMBER;
    private static int THE_HIGHEST_LINE_NUMBER;
    private static ScheduleParser scheduleParser;
    private BusLine busLine;
    private List<Integer> allLineNumbers;


    @BeforeClass
    public static void setupScheduleParser() throws IOException {
        scheduleParser = new ScheduleParser();
    }

    @Before
    public void setUp() throws Exception {
        allLineNumbers = scheduleParser.getAllLineNumbers();
        THE_LOWEST_LINE_NUMBER = Collections.min(allLineNumbers);
        THE_HIGHEST_LINE_NUMBER = Collections.max(allLineNumbers);

        DeparturesFirstStop dfs = mock(DeparturesFirstStop.class);
        Route route = mock(Route.class);
        int lineNumber = 136;
        busLine = new BusLine(lineNumber, route, dfs);
    }

    @Test
    public void busLine_has_line_number_defined (){
        assertThat(busLine.getLineNumber()).isNotNull();
    }

    @Test
    public void busLine_line_number_is_in_a_database (){
        assertThat(busLine.getLineNumber()).isIn(allLineNumbers);
    }

    @Test
    public void busLine_line_number_is_in_a_specific_range_of_numbers (){
        assertThat(busLine.getLineNumber()).isBetween(THE_LOWEST_LINE_NUMBER,THE_HIGHEST_LINE_NUMBER);
    }

}
