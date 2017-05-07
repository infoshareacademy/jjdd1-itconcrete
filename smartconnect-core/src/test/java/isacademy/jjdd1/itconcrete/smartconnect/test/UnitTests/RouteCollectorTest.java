package isacademy.jjdd1.itconcrete.smartconnect.test.UnitTests;


import isacademy.jjdd1.itconcrete.smartconnect.test.ExemplaryCSVFileBuilder.CSVFileWriter;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.Direction;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.Route;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.RouteCollector;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.*;


import static org.assertj.core.api.Assertions.assertThat;



public class RouteCollectorTest {

    private static final int EXPECTED_NUMBER_OF_STOPS = 5;
    private static final String fileName = System.getProperty("java.io.tmpdir")+"/005_warianty1.csv";
    private static final Direction direction = Direction.direction_1;
    private static final int lineNumber = 5;
    private static RouteCollector routeCollector;
    private static Route route;
    private static File file;
    private static String stopNameWithoutUsingRouteCollector;


    @BeforeClass
    public static void setup() throws IOException {
        System.out.println(fileName);
        CSVFileWriter.writeCsvFile(fileName);
        file = new File(fileName);
        routeCollector = new RouteCollector(file, direction, lineNumber);
        route = routeCollector.getRoute();
    }

    @Test
    public void RouteCollector_getRoute_returns_route_object(){
        assertThat(routeCollector.getRoute()).isInstanceOf(Route.class);
    }

    @Test
    public void RouteCollector_creates_deltasList_with_busStopDeltasObjects(){
        assertThat(route.getDeltasList().get(0)).isInstanceOf(BusStopDeltas.class);
    }


    @Test
    public void RouteCollector_collects_non_empty_list_of_deltas(){
        assertThat(route.getDeltasList()).isNotEmpty();
    }

    @Test
    public void RouteCollector_collects_non_empty_list_of_stops(){
        assertThat(route.getArrayOfStops()).isNotEmpty();
    }

    @Test
    public void amount_of_collected_stop_names_is_as_expected(){
        assertThat(route.getArrayOfStops().size()).isEqualTo(EXPECTED_NUMBER_OF_STOPS);
    }

    @Before
    public void get_data_without_using_RouteCollector() throws IOException {
        String line = (String) FileUtils.readLines(file).get(1);
        String [] row = line.split(";");
        stopNameWithoutUsingRouteCollector = row[3];
    }

    @Test
    public void output_charset_for_data_imported_from_windows1250_is_UTF_8(){
        String firstStopNameFromRouteCollector = route.getArrayOfStops().get(0);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(stopNameWithoutUsingRouteCollector).isNotEqualTo(firstStopNameFromRouteCollector);
        softly.assertThat(stopNameWithoutUsingRouteCollector.substring(0,5)).isEqualTo(firstStopNameFromRouteCollector.substring(0,5));
        softly.assertThat(stopNameWithoutUsingRouteCollector.substring(5,6)).isNotEqualTo(firstStopNameFromRouteCollector.substring(5,6));
    }
}
