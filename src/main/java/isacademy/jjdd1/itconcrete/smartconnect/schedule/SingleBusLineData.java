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
    private static final String csvSplitBy = ";";

    public SingleBusLineData(int lineNumber, File[] singleBuslineDirectoryContent) {
        this.lineNumber = lineNumber;
        this.singleBuslineDirectoryContent = singleBuslineDirectoryContent;
    }

    public SingleBusLineData() {}

    //get number
    //get direction
    //get route
    //get departures
    //get deltas

    public void loadData () {
        for (File file : singleBuslineDirectoryContent) {
            if (file.getName().contains("warianty")) {
                buildDatabaseOfBusline(file);
            }
        }
    }

    //TODO ENUM direction 1 or 2
    private int getBusDirection (String busScheduleFilename) {
        if (busScheduleFilename.endsWith("1.csv")) {
            return 1;
        } else if (busScheduleFilename.endsWith("2.csv")){
            return 2;
        } else {
            //TODO Logger - error - direction not defined
            return 0;
        }
    }


    private void buildDatabaseOfBusline(File file){

        BufferedReader br = null;
        String line = "";

        //TODO updating departures  - creating departures objects for all busstops - connected wih minutes and variants
        //get departures ArrayList<LocalTime> departures = new ArrayList<>();
        //departures = getDepartures(file);

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "windows-1250"));
            //int busLineNumber = getBusLineNumber(file);
            int direction = getBusDirection(file.getName());

            ArrayList<String> arrayOfBusStopsInOneRoute = new ArrayList<>();
            ArrayList<BusStopDeltas> deltasList = new ArrayList<>();
            ArrayList<String[]> singleBusData = new ArrayList<String[]>();

            while ((line = br.readLine()) != null) {
                String[] oneRowInCSV = line.split(csvSplitBy);
                singleBusData.add(oneRowInCSV);
                String nameColumnInCSV = oneRowInCSV[3];
                String deltaColumnInCSV = oneRowInCSV[4];

                if (!deltaColumnInCSV.startsWith("X")) {
                    if (deltaColumnInCSV.isEmpty()) {
                        BusStopDeltas bsd = new BusStopDeltas(nameColumnInCSV, -1);
                        deltasList.add(bsd);
                    } else {
                        BusStopDeltas bsd = new BusStopDeltas(nameColumnInCSV, Integer.parseInt(deltaColumnInCSV));
                        deltasList.add(bsd);
                    }
                }

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
            }

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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }





    private ArrayList<LocalTime> getDepartures (File file) throws IOException {

        String fileName = file.getName();

        String filePath = file.getParentFile().toString();
        int indexOfWarianty = fileName.indexOf('w');
        String fileHead = fileName.substring(0,indexOfWarianty);
        String pathToDepartures = "";

        // problems with // direction depending on operating system

        if (fileName.endsWith("1.csv")){
            pathToDepartures = filePath +"//" + fileHead + "kursy1.csv";
        } else {
            pathToDepartures = filePath + "//" + fileHead + "kursy2.csv";
        }

        File newFile = new File (pathToDepartures);

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        br = new BufferedReader( new InputStreamReader(new FileInputStream(newFile),"windows-1250"));
        ArrayList<String> helperArray = new ArrayList<>();

        while ((line = br.readLine()) != null) {

            String[] oneRowInCSV = line.split(cvsSplitBy);
            String datesColumnInCSV = oneRowInCSV[0];
            helperArray.add(datesColumnInCSV);
        }

        ArrayList<LocalTime> weekDaysDepartures = new ArrayList<>();
        for (int i = 1; i < helperArray.size() ; i++) {
            String ha = helperArray.get(i);
            if ( !ha.equals("99") || !ha.equals("")) {

                try {
                    weekDaysDepartures.add(new LocalTime(ha));
                } catch (Exception e) {
                }
            } else {
                break;
            }
        }

        return weekDaysDepartures;

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
