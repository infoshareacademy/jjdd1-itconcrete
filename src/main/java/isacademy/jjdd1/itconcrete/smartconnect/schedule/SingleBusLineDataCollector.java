package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import org.joda.time.LocalTime;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Ageee on 13.04.2017.
 */
public class SingleBusLineDataCollector {

    private int lineNumber;
    private File[] singleBuslineDirectoryContent;
    private Direction currentDirection;
    private static final String csvSplitBy = ";";
    private ArrayList<BusLine> oneBusLineBothDirections;


    public SingleBusLineDataCollector(int lineNumber, File[] singleBuslineDirectoryContent) {
        this.lineNumber = lineNumber;
        this.singleBuslineDirectoryContent = singleBuslineDirectoryContent;
        currentDirection = Direction.undefined;
        oneBusLineBothDirections = new ArrayList<>();
    }

    public SingleBusLineDataCollector() {}

    //get number
    //get route //get direction //get departures
    //get deltas

    public void loadData () throws IOException {
        for (File file : singleBuslineDirectoryContent) {
            if (file.getName().contains("warianty")) {
                System.out.println("Currently checked file is " + file.getName());
                buildDatabaseOfBusline(file);
            }
        }
    }

    private void buildDatabaseOfBusline(File file) throws IOException {
        //System.out.println("I am starting to build database!"); TODO Logger
        currentDirection = getBusDirection(file.getName());

        DeparturesCollector dc = new DeparturesCollector(file, currentDirection, lineNumber);
        dc.loadDeparturesData();

        RouteCollector rc = new RouteCollector(file, currentDirection, lineNumber);
        rc.loadRouteData();

    }



        //TODO updating departures  - creating departures objects for all busstops - connected wih minutes and variants
        //get departures ArrayList<LocalTime> departures = new ArrayList<>();
        //departures = getDepartures(file);

//        try {
//            BufferedReader br = null;
//            String line = "";
//            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "windows-1250"));
//            Direction direction = getBusDirection(file.getName());
//            ArrayList<String> arrayOfBusStopsInOneRoute = new ArrayList<>();
//            ArrayList<String[]> singleBusData = new ArrayList<String[]>();
//
//            while ((line = br.readLine()) != null) {
//                String[] oneRowInCSV = line.split(csvSplitBy);
//                singleBusData.add(oneRowInCSV);
//                String nameColumnInCSV = oneRowInCSV[3];
//                String deltaColumnInCSV = oneRowInCSV[4];
//
//                if (!deltaColumnInCSV.startsWith("X")) {
//                    if (deltaColumnInCSV.isEmpty()) {
//                        BusStopDeltas bsd = new BusStopDeltas(nameColumnInCSV, -1);
//                        deltasList.add(bsd);
//                    } else {
//                        BusStopDeltas bsd = new BusStopDeltas(nameColumnInCSV, Integer.parseInt(deltaColumnInCSV));
//                        deltasList.add(bsd);
//                    }
//                }

//                if (!nameColumnInCSV.equals("Nazwa")) {
//                    arrayOfBusStopsInOneRoute.add(nameColumnInCSV);
//                    if (!hashMapOfBusStops.containsKey(nameColumnInCSV)) {
//                        ArrayList listOfBusLines = new ArrayList();
//                        listOfBusLines.add(busLineNumber);
//                        hashMapOfBusStops.put(nameColumnInCSV, listOfBusLines);
//                    } else if (!hashMapOfBusStops.get(nameColumnInCSV).contains(busLineNumber)) {
//                        hashMapOfBusStops.get(nameColumnInCSV).add(busLineNumber);
//                    }
//                }
//            }

//            Route route = new Route(direction, arrayOfBusStopsInOneRoute, busLineNumber, deltasList);
//            arrayOfRoutes.add(route);
//            BusLine bl = new BusLine(busLineNumber, route, departures);
//            arrayOfBusLines.add(bl);
//


                        /* minutesMatrix = new HashMap<String,ArrayList>();
                           for (int i = 0; i < variants.size() ; i++) {
                               ArrayList<String> minutes = new ArrayList<String>();
                               for (int j = 1; j < singleBusData.size() ; j++) {
                                   String minute = singleBusData.get(j)[4+i];
                                   if (minute == null ){
                                       minutes.add("Skip");
                                   } else {
                                       minutes.add(minute);
                                   }
                               }
                               minutesMatrix.put(variants.get(i), minutes);
                        }*/

//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (br != null) {
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    private Direction getBusDirection (String busScheduleFilename) {
        if (busScheduleFilename.endsWith("1.csv")) {
            return Direction.direction_1;
        } else if (busScheduleFilename.endsWith("2.csv")){
            return Direction.direction_2;
        } else {
            //TODO Logger - error - direction not defined
            return Direction.undefined;
        }
    }

    public ArrayList<BusLine> getOneBusLineBothDirections() {
        return oneBusLineBothDirections;
    }
}

//    public HashMap<String, ArrayList> getHashMapOfBusStops() {
//        return hashMapOfBusStops;
//    }
//
//    public ArrayList<Route> getArrayOfRoutes() {
//        return arrayOfRoutes;
//    }
//
//    public ArrayList<BusLine> getArrayOfBusLines() {
//        return arrayOfBusLines;
//    }
//
//    public HashMap<String, ArrayList> getMinutesMatrix() { //TODO logic/algorythm of this method for further use
//        return minutesMatrix; }
