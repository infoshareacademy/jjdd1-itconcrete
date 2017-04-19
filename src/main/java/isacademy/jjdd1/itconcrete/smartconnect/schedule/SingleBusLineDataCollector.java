package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Ageee on 13.04.2017.
 */
public class SingleBusLineDataCollector {

    private int lineNumber;
    private File[] singleBuslineDirectoryContent;
    private Direction currentDirection;
    private BusLine busLine;
    private ArrayList<BusLine> oneBusLineBothDirections;


    public SingleBusLineDataCollector(int lineNumber, File[] singleBuslineDirectoryContent) {
        this.lineNumber = lineNumber;
        this.singleBuslineDirectoryContent = singleBuslineDirectoryContent;
        currentDirection = Direction.undefined;
        oneBusLineBothDirections = new ArrayList<>();
    }

    public SingleBusLineDataCollector() {
    }

    //get number
    //get route //get direction //get departures
    //get deltas

    public void loadData() throws IOException {
        for (File file : singleBuslineDirectoryContent) {
            if (file.getName().contains("warianty")) {
                //System.out.println("Currently checked file is " + file.getName());
                buildDatabaseOfBusline(file);
            }
        }
    }

    private void buildDatabaseOfBusline(File file) throws IOException {
        //System.out.println("I am starting to build database!"); TODO Logger
        currentDirection = getBusDirection(file.getName());

        DeparturesCollector dc = new DeparturesCollector(file, currentDirection, lineNumber);
        dc.loadDeparturesData();
        DeparturesFirstStop departuresFirstStop = dc.getDeparturesFirstStop();
        //TODO updating departures  - creating departures objects for all busstops - connected wih minutes and variants

        RouteCollector rc = new RouteCollector(file, currentDirection, lineNumber);
        rc.loadRouteData();
        Route route = rc.getRoute();

        busLine = new BusLine(lineNumber, route, departuresFirstStop);
    }

//            BusLine bl = new BusLine(busLineNumber, route, departures);
//            arrayOfBusLines.add(bl);


    private Direction getBusDirection(String busScheduleFilename) {
        if (busScheduleFilename.endsWith("1.csv")) {
            return Direction.direction_1;
        } else if (busScheduleFilename.endsWith("2.csv")) {
            return Direction.direction_2;
        } else {
            //TODO Logger - error - direction not defined
            return Direction.undefined;
        }
    }

    public BusLine getBusLine() {
        return busLine;
    }
}
// MIGHT NOT BE NECESSARY
//    public ArrayList<BusLine> getOneBusLineBothDirections() {
//        return oneBusLineBothDirections;
//    }


//TODO logic/algorythm of this method for further use
//    public HashMap<String, ArrayList> getMinutesMatrix() {
//        return minutesMatrix; }
