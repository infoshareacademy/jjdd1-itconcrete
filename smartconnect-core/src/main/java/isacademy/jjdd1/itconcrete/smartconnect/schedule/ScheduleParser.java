package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class ScheduleParser {

    private static final String ZIP_FILE_PATH = "/rozklady_2015-09-08_13.43.01.zip";
    private static final Path ROOT_PATH = Paths.get(System.getProperty("java.io.tmpdir")).resolve("smartconnect");
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleParser.class);

    private ArrayList<BusLine> arrayOfBusLines = new ArrayList<>();
    private InitialDataChecker initialDataChecker = new InitialDataChecker();
    private ArrayList<Integer> allLineNumbers = new ArrayList<>();
    private ArrayList<String> allBusStopNames = new ArrayList<>();

    public ScheduleParser() throws IOException {
        LOGGER.debug("Unzipping zip {} to temp folder {}.", ZIP_FILE_PATH, ROOT_PATH);
        Files.createDirectories(ROOT_PATH);
        ZipInputStream stream = new ZipInputStream(ScheduleParser.class.getResourceAsStream(ZIP_FILE_PATH));
        ZipEntry entry;
        while ((entry = stream.getNextEntry()) != null) {
            Path p = ROOT_PATH.resolve(entry.getName());
            if (entry.isDirectory()) {
                Files.createDirectories(p);
            } else {
                OutputStream outputStream = Files.newOutputStream(p);
                final int BUFFER_SIZE = 4096;
                byte[] bytesIn = new byte[BUFFER_SIZE];
                int read = 0;
                while ((read = stream.read(bytesIn)) != -1) {
                    outputStream.write(bytesIn, 0, read);
                }
                outputStream.close();
            }
        }
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
        List<Path> pathsToScheduleFiles = subdirectories(ROOT_PATH);
        for (Path path : pathsToScheduleFiles) {
            if (!initialDataChecker.checkIfSchedulesArePresent(pathsToScheduleFiles)) {
                LOGGER.error("Data to build schedules database not found.");
            } else {
                if (path.toString().contains("warianty")){
                    LOGGER.trace("Starting to parse files.");
                    BusLine busLine = collectLineData(path);
                    arrayOfBusLines.add(busLine);
                    allLineNumbers.add(busLine.getLineNumber());
                    allBusStopNames.addAll(busLine.getRoute().getArrayOfStops());
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

    public ArrayList<Integer> getAllLineNumbers() {
        return allLineNumbers;
    }

    public ArrayList<String> getAllBusStopNames() {
        return allBusStopNames;
    }
}