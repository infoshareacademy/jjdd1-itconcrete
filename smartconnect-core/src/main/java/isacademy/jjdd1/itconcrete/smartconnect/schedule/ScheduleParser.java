package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.*;


public class ScheduleParser {

    private ArrayList<BusLine> arrayOfBusLines;
    private InitialDataChecker initialDataChecker;
    private HashMap<Integer,SingleBusLineDataCollector> completeBusLinesData;

    private static final String pathToSchedulesParentDirectory = "smartconnect-core/src/main/resources/rozklady_2015-09-08_13.43.01/";
    private static final File parentDirectoryWithSchedules = new File (pathToSchedulesParentDirectory);
    private static final File[] listOfSchedulesDirectories = parentDirectoryWithSchedules.listFiles();
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleParser.class);

    public ScheduleParser() throws IllegalAccessException, NoSuchFieldException, IOException {
        initialDataChecker = new InitialDataChecker();
        completeBusLinesData = new HashMap<>();
        arrayOfBusLines = new ArrayList<>();
    }

    public void loadData() throws IOException {
        LOGGER.trace("Loading data from schedule resources.");
        if (!initialDataChecker.checkIfSchedulesDirectoriesArePresent(listOfSchedulesDirectories)) {
            LOGGER.error("Data to build schedules database not found.");
        } else {
            LOGGER.trace("Starting to parse directories.");
            parseThroughDirectories();
        }
    }

    private void parseThroughDirectories () throws IOException {
        assert listOfSchedulesDirectories != null;
        for (File singleBuslineDirectory : listOfSchedulesDirectories) {
            if (!singleBuslineDirectory.isDirectory()) {
                LOGGER.debug(singleBuslineDirectory.getName() + " is not a proper directory file. Process terminated.");
            } else {
                LOGGER.info("Gathering information about busline number " + singleBuslineDirectory.getName().substring(0,3));
                LOGGER.trace("Entering directory " + singleBuslineDirectory.getName());
                parseInsideParticularBuslineDirectory(singleBuslineDirectory);
            }
        }
    }

    private void parseInsideParticularBuslineDirectory(File singleBuslineDirectory) throws IOException {
        File[] listOfOneBuslineFiles = singleBuslineDirectory.listFiles();
        if (!initialDataChecker.checkPresenceOfScheduleResource(listOfOneBuslineFiles)) {
            LOGGER.warn("Schedules for line " + singleBuslineDirectory.getName().substring(0,3) + " not available.");
        } else {
            LOGGER.trace("Collectig data about departures and routes.");
            int buslineNumber = getBusLineNumber(singleBuslineDirectory);

            SingleBusLineDataCollector singleBusLineDataCollector = new SingleBusLineDataCollector(buslineNumber, listOfOneBuslineFiles);
            singleBusLineDataCollector.loadData();
            arrayOfBusLines.add(singleBusLineDataCollector.getBusLine());
        }
    }

    private int getBusLineNumber (File file){
        String busLineNumber = file.getName().substring(0, 3);
     return Integer.parseInt(busLineNumber);
    }

    public ArrayList<BusLine> getArrayOfBusLines() {
        return arrayOfBusLines;
    }
}