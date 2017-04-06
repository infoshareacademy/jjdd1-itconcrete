package isacademy.jjdd1.itconcrete.smartconnect.schedule;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by agatabereza on 06.04.2017.
 */
public class ScheduleParser {

    private ArrayList<String[]> listOfScheduleRows;
    private ArrayList<String> route;
    private ArrayList<String> variants;



    public ScheduleParser() {
    }

//    public String getTestCase() {
//        return testCase;
//    }

    public ArrayList<String[]> scheduleParser() throws Exception{

        //Added to allow using polish characters.
        System.setProperty("file.encoding","windows-1250");
        Field charset = Charset.class.getDeclaredField("defaultCharset");
        charset.setAccessible(true);
        charset.set(null,null);

        listOfScheduleRows = new ArrayList<String[]>();

        String pathToSchedules = "/home/agatabereza/IdeaProjects/jjdd1-itconcrete/src/main/resources/rozklady_2015-09-08_13.43.01/131_20150718/131_20150718warianty1.csv";
        File file = new File(pathToSchedules);
        String busLineNumber = file.getName().toString().substring(0,3);

        //URL resource = getClass().getResource(pathToSchedules);
        //List<String> listOfAllLines = null;

        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ";";

        try {

            br = new BufferedReader(new FileReader(pathToSchedules));
            while ((line = br.readLine()) != null) {

                String[] oneRowInCSV = line.split(csvSplitBy);
                listOfScheduleRows.add(oneRowInCSV);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        variants = new ArrayList<String>();
        String [] firstRowInCSV = listOfScheduleRows.get(0);
        for (int i = 4; i < firstRowInCSV.length-1; i++){
            String currentElementFromFirsRow = firstRowInCSV[i];
            variants.add(currentElementFromFirsRow.substring(0,currentElementFromFirsRow.indexOf("(")));
        }


        route = new ArrayList<String>();
        for (int i = 1; i < listOfScheduleRows.size() ; i++) {
            route.add(listOfScheduleRows.get(i)[3]);
        }

        System.out.println("Busline: "+busLineNumber + "\nDirection: " + route.get(route.size()-1)+"\nVariants: " + variants + "\n");
        for (int i = 0; i < route.size(); i++) {
            System.out.println(route.get(i));

        }



        /*try {
            listOfScheduleRows = Files.readAllLines(Paths.get(resource.toURI()));
            System.out.println("probujemy");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        for (String singleLine : listOfAllLines) {

            String[] separatedElementsFromSingleLine = singleLine.split(";");
            listOfScheduleRows.add(separatedElementsFromSingleLine);
            System.out.println("Current stop id is: " + separatedElementsFromSingleLine[1]);
        }

        URL resource = getClass().getResource("C:\\Users\\Ageee\\IdeaProjects\\jjdd1-itconcrete\\src\\main\\java\\isacademy\\jjdd1\\itconcrete\\smartconnect\\resources\\rozklady_2015-09-08_13.43.01\\136_20140802\\136_20140802warianty1.csv");
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(resource.toURI()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        int currentLineNumber = 0;
        for (String line : lines) {
            currentLineNumber+=1;
            String[] elements = line.split(",");
        }*/
        return listOfScheduleRows;
    }

}
