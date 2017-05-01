package isacademy.jjdd1.itconcrete.smartconnect.schedule;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;


public class SingleBusLineDataCollector {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingleBusLineDataCollector.class);
    private int lineNumber;
    private Direction direction;
    private BusLine busLine;
    private File file;



    public SingleBusLineDataCollector(int lineNumber, Direction direction, File file) throws IOException {
        this.lineNumber = lineNumber;
        this.direction = direction;
        this.file = file;
        loadData();
    }

    private void loadData() throws IOException {

        DeparturesCollector dc = new DeparturesCollector(file, direction, lineNumber);
        dc.loadDeparturesData();
        DeparturesFirstStop departuresFirstStop = dc.getDeparturesFirstStop();
        //TODO updating departures  - creating departures objects for all busstops - connected wih minutes and variants

        RouteCollector rc = new RouteCollector(file, direction, lineNumber);
        Route route = rc.getRoute();

        if (route.equals(null)){
            LOGGER.error("Something went wrong with collecting route data for line number: {}",lineNumber);
        }

        busLine = new BusLine(lineNumber, route, departuresFirstStop);
    }

    public BusLine getBusLine() {
        return busLine;
    }
}

//TODO logic/algorythm of this method for further use
//    public HashMap<String, ArrayList> getMinutesMatrix() {
//        return minutesMatrix; }
