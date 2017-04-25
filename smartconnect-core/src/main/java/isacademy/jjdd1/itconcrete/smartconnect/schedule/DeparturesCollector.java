package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;

class DeparturesCollector {

    private File file;
    private int lineNumber;
    private Direction currentDirection;
    private DeparturesFirstStop departuresFirstStop;
    private static final String csvSplitBy = ";";

    DeparturesCollector(File file, Direction currentDirection, int lineNumber) {
        this.file = file;
        this.currentDirection = currentDirection;
        this.lineNumber = lineNumber;
    }

    void loadDeparturesData() throws IOException {
        ArrayList<String[]> departuresFirstStopWithoutDivision =  getDeparturesFromFirstStopWithoutDivisionWithXVariants(file);
        departuresFirstStop = new DeparturesFirstStop();
        departuresFirstStop = fillInDeparturesFirstStopObject (departuresFirstStopWithoutDivision);
    }

    private ArrayList<String[]> getDeparturesFromFirstStopWithoutDivisionWithXVariants(File file) throws IOException {
        BufferedReader br = initializeBufferedReader(file);
        return createListOfDeparturesForAWholeWeek(br);
    }

    private BufferedReader initializeBufferedReader (File file) throws FileNotFoundException, UnsupportedEncodingException {
        FileInputStream fis = new FileInputStream(getFileToCreateDeparturesList(file));
        InputStreamReader isr = new InputStreamReader(fis,"windows-1250");
        return new BufferedReader(isr);
    }

    private File getFileToCreateDeparturesList(File file) {
        String pathToDepartures = replaceFilepathFromWariantyToKursy(file);
        return new File(pathToDepartures);
    }

    private String replaceFilepathFromWariantyToKursy(File file){
        String currentPathOfFile = file.getAbsolutePath();
        return currentPathOfFile.replace("warianty","kursy");
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
            current.add(new DepartureWithVariant(LocalTime.parse(hourColumn), variantColumn));
            //TODO Logger - debug - invalid input
        }
        return new DeparturesFirstStop(lineNumber, currentDirection, weekdays, saturdays, saturdaysSundays, sundays);
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

    DeparturesFirstStop getDeparturesFirstStop() {
        return departuresFirstStop;
    }
}
