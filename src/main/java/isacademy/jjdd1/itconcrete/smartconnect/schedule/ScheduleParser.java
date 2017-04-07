package isacademy.jjdd1.itconcrete.smartconnect.schedule;



import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by agatabereza on 06.04.2017.
 */
public class ScheduleParser {

    private ArrayList<String[]> listOfScheduleRows;
    private ArrayList<String> route;
    private ArrayList<String> variants;
    private HashMap<String, ArrayList> hashMapOfBusStops;
    private File[] pathsToCSVFiles;

    public ScheduleParser() throws IllegalAccessException, NoSuchFieldException {
        //Added in order to allow using polish characters.
        /*System.setProperty("file.encoding","windows-1250");
        Field charset = Charset.class.getDeclaredField("defaultCharset");
        charset.setAccessible(true);
        charset.set(null,null);*/

        String csvFile = "src/main/resources/rozklady_2015-09-08_13.43.01/";
        File f = null;
        f = new File(csvFile);
        pathsToCSVFiles = f.listFiles();
    }

    /*private String charsetConverter (String windowsCharsetString) {
        String UTFCharsetString = Charset.forName("UTF-8").encode(windowsCharsetString).toString();
        return UTFCharsetString;
    }*/

    private String charsetConverter (String windowsCharsetString) throws UnsupportedEncodingException {
        byte ptext[] = windowsCharsetString.getBytes("windows-1250");
        String UTFCharsetString = new String(ptext, "UTF-8");
        return UTFCharsetString;
    }

    /*private String charsetConverter (String windowsCharsetString) throws UnsupportedEncodingException {
        byte[] byteText = windowsCharsetString.getBytes(Charset.forName("windows-1250"));
        String originalString = new String(byteText, "windows-1250");
        return originalString;
        /*ą=Ä…
        ć=Ä‡
        ę=Ä™
        ł=Ĺ‚
        ń=Ĺ„
        ó=Ăł
        ś=Ĺ›
        ź=Ĺş
        ż=ĹĽ*/


    /*private String byteConverter (String input){
        input = "This is an example";
        byte[] bytes = input.getBytes();

        System.out.println("Text : " + input);
        System.out.println("Text [Byte Format] : " + bytes);
        System.out.println("Text [Byte Format] : " + bytes.toString());

        String output = new String(bytes);
        System.out.println("Text Decryted : " + output);
        return output;
    }*/


        public HashMap<String, ArrayList> hashMapOfBusStops() {

        hashMapOfBusStops = new HashMap<String, ArrayList>();

        for (File path : pathsToCSVFiles) {
            File dir = new File(path.toString());
            File[] directoryListing = dir.listFiles();
            if (directoryListing != null) {
                for (File child : directoryListing) {
                    if (child.getName().contains("warianty")) {


                        BufferedReader br = null;
                        String line = "";
                        String cvsSplitBy = ";";

                        try {

                            br = new BufferedReader( new InputStreamReader(new FileInputStream(child),"windows-1250"));
                            //br = new BufferedReader(new FileReader(child));
                            String busLine = child.getName().substring(0,3);
                            while ((line = br.readLine()) != null) {

                                line = charsetConverter(line);
                                String[] oneRowInCSV = line.split(cvsSplitBy);
                                String nameColumnInCSV = charsetConverter(oneRowInCSV[3]);
                                System.out.println(oneRowInCSV[3]);


                                if (!nameColumnInCSV.equals("Nazwa")) {

                                    if (!hashMapOfBusStops.containsKey(nameColumnInCSV)) {
                                        ArrayList listOfBusLines = new ArrayList();
                                        listOfBusLines.add(busLine);
                                        hashMapOfBusStops.put(nameColumnInCSV, listOfBusLines);
                                    } else if (!hashMapOfBusStops.get(nameColumnInCSV).contains(busLine)) {
                                        hashMapOfBusStops.get(nameColumnInCSV).add(busLine);
                                    }
                                }
                            }


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
        return hashMapOfBusStops;
    }


    public ArrayList<String[]> scheduleParser(String bus) throws Exception{

        listOfScheduleRows = new ArrayList<String[]>();

        for (File path : pathsToCSVFiles) {
            if (path.toString().contains(bus+"_")) {
                File dir = new File(path.toString());
                File[] directoryListing = dir.listFiles();
                if (directoryListing != null) {
                    for (File child : directoryListing) {
                        if (child.getName().contains("warianty")) {

                            String pathToSchedules = child.getAbsolutePath();
                            BufferedReader br = null;
                            String line = "";
                            String csvSplitBy = ";";

                            try {

                                br = new BufferedReader(new FileReader(pathToSchedules));
                                while ((line = br.readLine()) != null) {

                                    line = charsetConverter(line);
                                    String[] oneRowInCSV = line.split(csvSplitBy);
                                    listOfScheduleRows.add(oneRowInCSV);

                                }

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

//        String pathToSchedules = "src/main/resources/rozklady_2015-09-08_13.43.01/131_20150718/131_20150718warianty1.csv";
//        File file = new File(pathToSchedules);
//        String busLineNumber = file.getName().toString().substring(0,3);




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

        System.out.println("Busline: "+bus + "\nDirection: " + route.get(route.size()-1)+"\nVariants: " + variants + "\n");
        for (int i = 0; i < route.size(); i++) {
            System.out.println(route.get(i));

        }

        return listOfScheduleRows;
    }



}