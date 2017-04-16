package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import org.joda.time.LocalTime;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Ageee on 13.04.2017.
 */
public class SingleBusLineData {

    private int lineNumber;
    private File[] singleBuslineDirectoryContent;
    private Direction currentDirection;
    private static final String csvSplitBy = ";";
    private DeparturesFirstStop departuresFirstStopDirection1;
    private DeparturesFirstStop departuresFirstStopDirection2;

    public SingleBusLineData(int lineNumber, File[] singleBuslineDirectoryContent) {
        this.lineNumber = lineNumber;
        this.singleBuslineDirectoryContent = singleBuslineDirectoryContent;
        currentDirection = Direction.undefined;
        departuresFirstStopDirection1 = new DeparturesFirstStop();
        departuresFirstStopDirection2 = new DeparturesFirstStop();
    }

    public SingleBusLineData() {}

    //get number
    //get direction
    //get route
    //get departures
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
        ArrayList<String[]> departuresFirstStopWithoutDivision =  getDeparturesFromFirstStopWithoutDivisionWithXVariants(file);
        DeparturesFirstStop departuresFirstStop = new DeparturesFirstStop();

        if (currentDirection.equals(Direction.direction_1)){
            departuresFirstStopDirection1 = fillInDeparturesFirstStopObject (departuresFirstStopWithoutDivision);
        } else {
            departuresFirstStopDirection2 = fillInDeparturesFirstStopObject (departuresFirstStopWithoutDivision);
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
//            variants = new ArrayList<String>();
//            String[] firstRowInCSV = singleBusData.get(0);
//            for (int i = 4; i < firstRowInCSV.length; i++) {
//                String currentElementFromFirsRow = firstRowInCSV[i];
//                variants.add(currentElementFromFirsRow.substring(0, currentElementFromFirsRow.indexOf("(")));
//            }

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
    }

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

    private ArrayList<String[]> getDeparturesFromFirstStopWithoutDivisionWithXVariants(File file) throws IOException {
        //System.out.println("Initialization of departures list...");
        BufferedReader br = initializeBufferedReader(file);
        ArrayList<String[]> departuresFirstStopWithoutDivision = createListOfDeparturesForAWholeWeek(br);
        return departuresFirstStopWithoutDivision;
    }

    private BufferedReader initializeBufferedReader (File file) throws FileNotFoundException, UnsupportedEncodingException {
        FileInputStream fis = new FileInputStream(getFileToCreateDeparturesList(file));
        InputStreamReader isr = new InputStreamReader(fis,"windows-1250");
        BufferedReader br = new BufferedReader(isr);
        return br;
    }

    private File getFileToCreateDeparturesList(File file) {
        String pathToDepartures = replaceFilepathFromWariantyToKursy(file);
        File newFile = new File(pathToDepartures);
        return newFile;
    }

    private String replaceFilepathFromWariantyToKursy(File file){
        String currentPathOfFile = file.getAbsolutePath();
        String pathToDepartures = currentPathOfFile.replace("warianty","kursy");
        return pathToDepartures;
    }

    private ArrayList<String[]> createListOfDeparturesForAWholeWeek (BufferedReader br) throws IOException {
        ArrayList<String[]> helperArray = new ArrayList<String[]>();
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] oneRowInCSV = line.split(csvSplitBy);
            if (line.isEmpty()){
                break;
            }
            String timeColumnInCSV = oneRowInCSV[0];
            String variantColumnInCSV = oneRowInCSV[1];
            helperArray.add(new String[]{timeColumnInCSV, variantColumnInCSV});
        }
        return helperArray;
    }

    //private ArrayList<DepartureWithVariant> getSpecificDaysDepartures(ArrayList<String[]> departuresFirstStopWithoutDivision){
    private DeparturesFirstStop fillInDeparturesFirstStopObject (ArrayList<String[]> departuresFirstStopWithoutDivision){
        ArrayList<DepartureWithVariant> weekdays = null;
        ArrayList<DepartureWithVariant> saturdays = null;
        ArrayList<DepartureWithVariant> saturdaysSundays = null;
        ArrayList<DepartureWithVariant> sundays = null;

        DayOfWorking currentDayOfWorking = DayOfWorking.WEEKDAYS;
        ArrayList<DepartureWithVariant> current = null;
        for (int i = 0; i < departuresFirstStopWithoutDivision.size() ; i++) {
            String hourColumn = departuresFirstStopWithoutDivision.get(i)[0];
            String variantColumn = departuresFirstStopWithoutDivision.get(i)[1];
            if (hourColumn.equals("99")) {
                currentDayOfWorking = checkDayOfWorking(departuresFirstStopWithoutDivision.get(i)[1]);
                if (currentDayOfWorking == DayOfWorking.WEEKDAYS) {
                    weekdays = new ArrayList<>();
                    current = weekdays;
                } else if (currentDayOfWorking == DayOfWorking.SATURDAYS){
                    saturdays = new ArrayList<>();
                    current = saturdays;
                } else if (currentDayOfWorking == DayOfWorking.SUNDAYS_AND_HOLIDAYS){
                    sundays = new ArrayList<>();
                    current = sundays;
                } else if (currentDayOfWorking == DayOfWorking.SATURDAYS_SUNDAYS_AND_HOLIDAYS){
                    saturdaysSundays = new ArrayList<>();
                    current = saturdaysSundays;
                } else {
                    throw new IllegalArgumentException();
                }
                continue;
            }
            current.add(new DepartureWithVariant(new LocalTime(hourColumn), variantColumn));
            //TODO Logger - debug - invalid input
        }
        DeparturesFirstStop departuresFirstStop = new DeparturesFirstStop(lineNumber, currentDirection, weekdays, saturdays, saturdaysSundays, sundays);
        return departuresFirstStop;
    }

    private DayOfWorking checkDayOfWorking(String descriptionOfDayOfWorking){
        if (descriptionOfDayOfWorking.contains("powszednie")){
            return DayOfWorking.WEEKDAYS;
        } else if (descriptionOfDayOfWorking.contains("soboty") && !descriptionOfDayOfWorking.contains("niedziele")) {
            return DayOfWorking.SATURDAYS;
        } else if (descriptionOfDayOfWorking.contains("soboty") && descriptionOfDayOfWorking.contains("niedziele")){
            return DayOfWorking.SATURDAYS_SUNDAYS_AND_HOLIDAYS;
        } else {
            return DayOfWorking.SUNDAYS_AND_HOLIDAYS;
        }
    }

    public DeparturesFirstStop getDeparturesFirstStopDirection1() {
        return departuresFirstStopDirection1;
    }

    public DeparturesFirstStop getDeparturesFirstStopDirection2() {
        return departuresFirstStopDirection2;
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
