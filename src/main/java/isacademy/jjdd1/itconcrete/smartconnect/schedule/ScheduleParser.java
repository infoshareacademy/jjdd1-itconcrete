package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import java.io.*;
import java.util.*;

public class ScheduleParser {

    private ArrayList<BusLine> arrayOfBusLines;
    private InitialDataChecker initialDataChecker;
    private HashMap<Integer,SingleBusLineData> completeBusLinesData;

    private static final String pathToSchedulesParentDirectory = "src/main/resources/rozklady_2015-09-08_13.43.01/";
    private static final File parentDirectoryWithSchedules = new File (pathToSchedulesParentDirectory);
    private static final File[] listOfSchedulesDirectories = parentDirectoryWithSchedules.listFiles();

    public ScheduleParser() throws IllegalAccessException, NoSuchFieldException, IOException {
        initialDataChecker = new InitialDataChecker();
        completeBusLinesData = new HashMap<>();
    }

    public void loadData() throws IOException {
        if (!initialDataChecker.checkIfSchedulesDirectoriesArePresent(listOfSchedulesDirectories)) {
            ///TODO Logger - fatal - no data to build schedules database
            System.out.println("Oh no, there is no data to parse.");
        } else {
            //TODO Logger - info
            System.out.println("Great, let's build the database!");
            parseThroughDirectories();
        }
    }

    private void parseThroughDirectories () throws IOException {
        assert listOfSchedulesDirectories != null;
        for (File singleBuslineDirectory : listOfSchedulesDirectories) {
            if (!singleBuslineDirectory.isDirectory()) {
                //TODO Debug - This isn't a directory
                System.out.println("It is not a proper directory file.");
            } else {
                //TODO Logger - info - Start building database about busline number X
                parseInsideParticularBuslineDirectory(singleBuslineDirectory);
            }
        }
    }

    private void parseInsideParticularBuslineDirectory(File singleBuslineDirectory) throws IOException {
        File[] listOfOneBuslineFiles = singleBuslineDirectory.listFiles();
        if (!initialDataChecker.checkPresenceOfScheduleResource(listOfOneBuslineFiles)) {
            //TODO Logger - Warning - no schedules available for this line + line number
            System.out.println("Couldn't find schedule files for this busline.");
        } else {
            //TODO Logger - info - receiving data about departures and route
            int buslineNumber = getBusLineNumber(singleBuslineDirectory);
            SingleBusLineData singleBusLineData = new SingleBusLineData(buslineNumber, listOfOneBuslineFiles);
            completeBusLinesData.put(buslineNumber,singleBusLineData);
        }
    }

    private int getBusLineNumber (File file){
        String busLineNumber = file.getName().substring(0, 3);
     return Integer.parseInt(busLineNumber);
    }

    //TODO przypadek jeśli w bazie danych nie znajdzie tego numeru
    //TODO logger - warning
    public SingleBusLineData getCompleteBusLinesData(int numberOfLine) {
        for (int key : completeBusLinesData.keySet()){
            if(key == numberOfLine) {
                ///TODO Logger - info
                return completeBusLinesData.get(numberOfLine);
            }
        }
        SingleBusLineData singleBusLineData = new SingleBusLineData();
        return singleBusLineData;
    }

    public ArrayList<BusLine> getArrayOfBusLines() {
        return arrayOfBusLines;
    }
}