package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;


public class ScheduleParser {

    private ArrayList<BusLine> arrayOfBusLines = new ArrayList<>();
    private InitialDataChecker initialDataChecker = new InitialDataChecker();
    private Path rootPath;

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleParser.class);

    public ScheduleParser() throws IllegalAccessException, NoSuchFieldException, IOException, URISyntaxException {

        URI uri = Paths.get("/Users/katarzynadobrowolska/Desktop/rozklady_2015-09-08_13.43.01").toUri();
        rootPath = Paths.get(uri);
    }

    private static List<Path> subdirectories(Path path) throws IOException {
        List<Path> pathsToCSVFiles = new ArrayList<>();
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                pathsToCSVFiles.add(file);
                return FileVisitResult.CONTINUE;
            }
        });
        return pathsToCSVFiles;
    }

    public void loadData() throws IOException {
        LOGGER.trace("Loading data from schedule resources.");
        List<Path> pathsToScheduleFiles = subdirectories(rootPath);
        for (Path path : pathsToScheduleFiles) {
            if (!initialDataChecker.checkIfSchedulesArePresent(pathsToScheduleFiles)) {
                LOGGER.error("Data to build schedules database not found.");
            } else {
                if (path.toString().contains("warianty")){
                    LOGGER.trace("Starting to parse files.");
                    arrayOfBusLines.add(collectLineData(path));
                }
            }
        }
    }

    private BusLine collectLineData(Path path) throws IOException {
        String scheduleFileName = path.getFileName().toString();
        int buslineNumber = getBusLineNumber(scheduleFileName);
        Direction directionOfBus = getBusDirection(scheduleFileName);
        LOGGER.trace("Collectig data about departures and routes for line number: " + buslineNumber);

        SingleBusLineDataCollector sbldc = new SingleBusLineDataCollector(buslineNumber,directionOfBus, new File(path.toString()));
        return sbldc.getBusLine();
    }

    private int getBusLineNumber (String fileName){
        String busLineNumber = fileName.substring(0, 3);
     return Integer.parseInt(busLineNumber);
    }

    private Direction getBusDirection(String busScheduleFilename) {
        if (busScheduleFilename.endsWith("1.csv")) {
            return Direction.direction_1;
        } else if (busScheduleFilename.endsWith("2.csv")) {
            return Direction.direction_2;
        } else {
            LOGGER.warn("Invalid schedule file. Direction not defined. Filename: " + busScheduleFilename);
            //TODO Logger - error - direction not defined
            return Direction.undefined;
        }
    }

    public ArrayList<BusLine> getArrayOfBusLines() {
        return arrayOfBusLines;
    }
}