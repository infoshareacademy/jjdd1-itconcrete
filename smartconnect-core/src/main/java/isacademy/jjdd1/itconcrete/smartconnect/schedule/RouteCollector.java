package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import java.io.*;
import java.util.ArrayList;

public class RouteCollector {

    private File file;
    private int lineNumber;
    private Direction currentDirection;
    private Route route;
    private static final String csvSplitBy = ";";
    private static final int kNameColumnIndex = 3;
    private static final int kFirstColumnWithVariantIndex = 4;

    public RouteCollector(File file, Direction currentDirection, int lineNumber) throws IOException {
        this.file = file;
        this.currentDirection = currentDirection;
        this.lineNumber = lineNumber;
        loadRouteData();
    }

    private void loadRouteData() throws IOException {
        BufferedReader br1 = initializeBufferedReader(file);
        BufferedReader br2 = initializeBufferedReader(file);

        ArrayList<String> arrayOfStops = createListOfStops(br1);
        ArrayList<BusStopDeltas> deltasList = createDeltasList(br2);
        route = new Route(currentDirection, arrayOfStops, lineNumber, deltasList);
//        ArrayList<String> variants = getVariants(br);
    }

    private BufferedReader initializeBufferedReader(File file) throws FileNotFoundException, UnsupportedEncodingException {
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "windows-1250");
        return new BufferedReader(isr);
    }

    private ArrayList<String> createListOfStops(BufferedReader br) throws IOException {
        ArrayList<String> arrayOfStops = new ArrayList<>();
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] oneRowInCSV = line.split(csvSplitBy);
            if (line.isEmpty()) {
                break;
            }

            String nameColumnInCSV = oneRowInCSV[kNameColumnIndex];

            if (!nameColumnInCSV.contains("Nazwa")) {
                arrayOfStops.add(nameColumnInCSV);
            }
        }
        return arrayOfStops;
    }

    private ArrayList<BusStopDeltas> createDeltasList(BufferedReader br) throws IOException {
        ArrayList<BusStopDeltas> deltasList = new ArrayList<>();
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] oneRowInCSV = line.split(csvSplitBy);
            if (line.isEmpty()) {
                break;
            }

            String nameColumnInCSV = oneRowInCSV[kNameColumnIndex];
            String deltaColumnInCSV = oneRowInCSV[kFirstColumnWithVariantIndex];

            if (!deltaColumnInCSV.startsWith("X")){
                if (deltaColumnInCSV.isEmpty()){
                    BusStopDeltas bsd = new BusStopDeltas(nameColumnInCSV,-1);
                    deltasList.add(bsd);
                } else {
                    BusStopDeltas bsd = new BusStopDeltas(nameColumnInCSV, Integer.parseInt(deltaColumnInCSV));
                    deltasList.add(bsd);
                }
            }
        }
        return deltasList;
    }


    public Route getRoute() {
        return route;
    }
}


//TODO - functionality for further sprints
//  private ArrayList<String> getVariants (BufferedReader br) throws IOException {
//      String firstLineInCSV = br.readLine();
//      String[] oneRowInCSV = firstLineInCSV.split(csvSplitBy);
//      lengthOfOneRowInCSV = oneRowInCSV.length;
//
//      ArrayList<String> variants = new ArrayList<>();
//      return variants;
//  }

//    variants = new ArrayList<String>();
//        String[] firstRowInCSV = singleBusData.get(0);
//        for (int i = 4; i < firstRowInCSV.length; i++) {
//            String currentElementFromFirsRow = firstRowInCSV[i];
//            variants.add(currentElementFromFirsRow.substring(0, currentElementFromFirsRow.indexOf("(")));
//        }

//      key - variant, Value - array of Stop+delta
//      private HashMap<String, ArrayList<BusStopDeltas>> createMapOfDeltasForVariants (){
//        HashMap<String, ArrayList<BusStopDeltas>> mapOfDeltasForVariants = new HashMap<>();
//        return mapOfDeltasForVariants;
//     }


