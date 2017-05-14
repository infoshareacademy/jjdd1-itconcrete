package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouteCollector {

    private File file;
    private int lineNumber;
    private Direction currentDirection;
    private Route route;
    private static final String csvSplitBy = ";";
    private static final int kNameColumnIndex = 3;
    private static final int kFirstColumnWithVariantIndex = 4;
    private static final int kPostColumnIndex = 1;

    public RouteCollector(File file, Direction currentDirection, int lineNumber) throws IOException {
        this.file = file;
        this.currentDirection = currentDirection;
        this.lineNumber = lineNumber;
        loadRouteData();
    }

    private void loadRouteData() throws IOException {
        BufferedReader br1 = initializeBufferedReader(file);
        BufferedReader br2 = initializeBufferedReader(file);
        BufferedReader br3 = initializeBufferedReader(file);

        List<String> arrayOfStops = createListOfStops(br1);
        List<BusStopDeltas> deltasList = createDeltasList(br2);
        Map<String,String> stopsWithPosts = createStopsWithPostsMap(br3);
        route = new Route(currentDirection, arrayOfStops, lineNumber, deltasList, stopsWithPosts);
//        ArrayList<String> variants = getVariants(br);
    }

    private BufferedReader initializeBufferedReader(File file) throws FileNotFoundException, UnsupportedEncodingException {
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "windows-1250");
        return new BufferedReader(isr);
    }

    private List<String> createListOfStops(BufferedReader br) throws IOException {
        List<String> arrayOfStops = new ArrayList<>();
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

    private List<BusStopDeltas> createDeltasList(BufferedReader br) throws IOException {
        List<BusStopDeltas> deltasList = new ArrayList<>();
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

    private Map<String,String> createStopsWithPostsMap(BufferedReader br) throws IOException {
        Map<String,String> stopsWithPosts = new HashMap<>();
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] oneRowInCSV = line.split(csvSplitBy);
            if (line.isEmpty()) {
                break;
            }

            String nameColumnInCSV = oneRowInCSV[kNameColumnIndex];
            String postColumnInCSV = oneRowInCSV[kPostColumnIndex];

            if (!nameColumnInCSV.contains("Nazwa")) {
                stopsWithPosts.put(nameColumnInCSV, getPostSygnature(postColumnInCSV));
            }
        }
        return stopsWithPosts;
    }


    private String getPostSygnature(String string){
        int indexOfOpeningParentheses = string.indexOf("(");
        int indexOfClosingParentheses = string.indexOf(")");
        return string.substring(indexOfOpeningParentheses+1,indexOfClosingParentheses);
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


