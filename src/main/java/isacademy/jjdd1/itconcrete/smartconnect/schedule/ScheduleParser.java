package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import org.joda.time.LocalTime;
import java.io.*;
import java.util.*;

public class ScheduleParser {

    private ArrayList<String> variants;
    private HashMap<String, ArrayList> minutesMatrix;
    private HashMap<String, ArrayList> hashMapOfBusStops;
    private ArrayList<Route> arrayOfRoutes;
    private ArrayList<BusLine> arrayOfBusLines;

    private static final String pathToSchedulesParentDirectory = "src/main/resources/rozklady_2015-09-08_13.43.01/";
    private static final File parentDirectoryWithSchedules = new File (pathToSchedulesParentDirectory);
    private static final File[] listOfSchedulesDirectories = parentDirectoryWithSchedules.listFiles();
    private static final String csvSplitBy = ";";


    public ScheduleParser() throws IllegalAccessException, NoSuchFieldException, IOException {
        arrayOfRoutes = new ArrayList<>();
        arrayOfBusLines = new ArrayList<>();
        hashMapOfBusStops = new HashMap<>();
    }

    public HashMap<String, ArrayList> getHashMapOfBusStops() {
        return hashMapOfBusStops;
    }

    public ArrayList<Route> getArrayOfRoutes() {
        return arrayOfRoutes;
    }

    public ArrayList<BusLine> getArrayOfBusLines() {
        return arrayOfBusLines;
    }

    private static boolean checkPresenceOfSchedulesResources(File[] resource){
        Optional<File[]> listOfFiles = Optional.ofNullable(listOfSchedulesDirectories);
        return listOfFiles.isPresent();
    }

    public HashMap<String, ArrayList> getMinutesMatrix() { //TODO logic/algorythm of this method for further use
        return minutesMatrix; }

    public void loadData() throws IOException {
        if (!checkPresenceOfSchedulesResources(listOfSchedulesDirectories)) {
            ///TODO Logger - fatal - no data to build schedules database
            System.out.println("Oh no, there is no data to parse.");
        } else {
            //TODO Logger - info
            //System.out.println("Great, let's build the database!");
            parseThroughDirectories();
        }
    }

    private void parseThroughDirectories () throws IOException {
        assert listOfSchedulesDirectories != null;
        for (File singleBuslineDirectory : listOfSchedulesDirectories) {
            if (!singleBuslineDirectory.isDirectory()) {
                //TODO Debug - This isn't a directory
                //System.out.println("It is not a proper directory file.");
                break;
            } else {
                //TODO Logger - info - Start building database about busline number X
                parseInsideParticularBuslineDirectory(singleBuslineDirectory);
            }
        }
    }

    private void parseInsideParticularBuslineDirectory(File singleBuslineDirectory) throws IOException {
        File[] listOfOneBuslineFiles = singleBuslineDirectory.listFiles();
        if (!checkPresenceOfSchedulesResources(listOfOneBuslineFiles)) {
            //TODO Logger - Warning - no schedules available for this line + line number
            System.out.println("Couldn't find schedule files for this busline.");
        } else {
            //TODO Logger - info - receiving data about departures and route
            assert listOfOneBuslineFiles != null;
            for (File file : listOfOneBuslineFiles) {
                ArrayList<LocalTime> departures = new ArrayList<>();
                if (file.getName().contains("warianty")) {
                    departures = getDepartures(file);
                    buildDatabaseOfBusline(file, departures);
                }
            }
        }
    }

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

    private void buildDatabaseOfBusline(File file, ArrayList<LocalTime> departures){
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "windows-1250"));
            String nameOfFile = file.getName();
            String busLineNumber = nameOfFile.substring(0, 3);
            int direction = getBusDirection(nameOfFile);

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

                if (!nameColumnInCSV.equals("Nazwa")) {
                    arrayOfBusStopsInOneRoute.add(nameColumnInCSV);
                    if (!hashMapOfBusStops.containsKey(nameColumnInCSV)) {
                        ArrayList listOfBusLines = new ArrayList();
                        listOfBusLines.add(busLineNumber);
                        hashMapOfBusStops.put(nameColumnInCSV, listOfBusLines);
                    } else if (!hashMapOfBusStops.get(nameColumnInCSV).contains(busLineNumber)) {
                        hashMapOfBusStops.get(nameColumnInCSV).add(busLineNumber);
                    }
                }
            }

            Route route = new Route(direction, arrayOfBusStopsInOneRoute, Integer.parseInt(busLineNumber), deltasList);
            arrayOfRoutes.add(route);
            BusLine bl = new BusLine(Integer.parseInt(busLineNumber), route, departures);
            arrayOfBusLines.add(bl);

            variants = new ArrayList<String>();
            String[] firstRowInCSV = singleBusData.get(0);
            for (int i = 4; i < firstRowInCSV.length; i++) {
                String currentElementFromFirsRow = firstRowInCSV[i];
                variants.add(currentElementFromFirsRow.substring(0, currentElementFromFirsRow.indexOf("(")));
            }

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




    //DODAJ WARUNEK JESLI NIE MA 99

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