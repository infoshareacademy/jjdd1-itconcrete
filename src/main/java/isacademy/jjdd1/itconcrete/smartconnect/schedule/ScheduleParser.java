package isacademy.jjdd1.itconcrete.smartconnect.schedule;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by agatabereza on 06.04.2017.
 */
public class ScheduleParser {

    private ArrayList<String[]> listOfScheduleRows;
    private ArrayList<String> route;
    private ArrayList<String> variants;



    public ArrayList<String[]> scheduleParser() throws Exception{

        //Added to allow using polish characters.
        System.setProperty("file.encoding","windows-1250");
        Field charset = Charset.class.getDeclaredField("defaultCharset");
        charset.setAccessible(true);
        charset.set(null,null);

        listOfScheduleRows = new ArrayList<String[]>();

        String pathToSchedules = "src/main/resources/rozklady_2015-09-08_13.43.01/131_20150718/131_20150718warianty1.csv";
        File file = new File(pathToSchedules);
        String busLineNumber = file.getName().toString().substring(0,3);


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

        return listOfScheduleRows;
    }

}
