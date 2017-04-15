package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import org.joda.time.LocalTime;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ScheduleParser {

    final String cvsSplitBy = ";";
    private ArrayList<String> variants;
    private HashMap<String, ArrayList> minutesMatrix;
    private HashMap<String, ArrayList> hashMapOfBusStops;
    private Path rootPath;
    private ArrayList<Route> arrayOfRoutes;
    private ArrayList<BusLine> arrayOfBusLines;


    public ScheduleParser() throws URISyntaxException, IOException {   //TODO: Organize constructor in a better way

        arrayOfRoutes = new ArrayList<Route>();
        arrayOfBusLines = new ArrayList<BusLine>();
        hashMapOfBusStops = new HashMap<String, ArrayList>();


        URI uri = ScheduleParser.class.getResource("/rozklady_2015-09-08_13.43.01").toURI();
        rootPath = Paths.get(uri);
    }

    static List<Path> subdirectories(Path path) throws IOException {
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

    public HashMap<String, ArrayList> getHashMapOfBusStops() {
        return hashMapOfBusStops;
    }

    public ArrayList<Route> getArrayOfRoutes() {
        return arrayOfRoutes;
    }

    public ArrayList<BusLine> getArrayOfBusLines() {
        return arrayOfBusLines;
    }

    public HashMap<String, ArrayList> getMinutesMatrix() {
        return minutesMatrix;
    }

    public void loadData() throws IOException {

        for (Path path : subdirectories(rootPath)) {
            for (Path child : subdirectories(path)) {
                if (child.getFileName().toString().contains("warianty")) {
                    ArrayList<LocalTime> departures = getDepartures(child);


                    BufferedReader br = null;
                    String line = "";
                    try {


                        br = Files.newBufferedReader(child, Charset.forName("windows-1250"));
                        String nameOfFile = child.getFileName().toString();
                        String busLineNumber = nameOfFile.substring(0, 3);
                        int direction = 0;


                        if (nameOfFile.endsWith("1.csv")) {
                            direction = 1;
                        } else {
                            direction = 2;
                        }

                        ArrayList<String> arrayOfBusStopsInOneRoute = new ArrayList<>();
                        ArrayList<BusStopDeltas> deltasList = new ArrayList<>();
                        ArrayList<String[]> singleBusData = new ArrayList<String[]>();

                        while ((line = br.readLine()) != null) {

                            String[] oneRowInCSV = line.split(cvsSplitBy);
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
            }
        }
    }


    //DODAJ WARUNEK JESLI NIE MA 99

    private ArrayList<LocalTime> getDepartures(Path path) throws IOException {

        String parentFileName = path.getParent().getFileName().toString();
        Path pathToDepartures;

        // problems with // direction depending on operating system
        if (path.endsWith("1.csv")) {
            pathToDepartures = path.getParent().resolve(parentFileName + "kursy1.csv");
        } else {
            pathToDepartures = path.getParent().resolve(parentFileName + "kursy2.csv");
        }

        List<String> helperArray = Files.readAllLines(pathToDepartures, Charset.forName("windows-1250"))
                .stream()
                .map(l -> l.split(cvsSplitBy)) //String[] oneRowInCSV = line.split(cvsSplitBy);
                .map(a -> a[0]) //String datesColumnInCSV = oneRowInCSV[0];
                .collect(Collectors.toList()); //helperArray.add(datesColumnInCSV);

        ArrayList<LocalTime> weekDaysDepartures = new ArrayList<>();
        for (int i = 1; i < helperArray.size(); i++) {
            String ha = helperArray.get(i);
            if (!ha.equals("99") || !ha.equals("")) {
                //FixMe
                try {
                    weekDaysDepartures.add(new LocalTime(helperArray.get(i)));
                } catch (Exception e) {
                }
            } else {
                break;
            }
        }

        return weekDaysDepartures;

    }
}