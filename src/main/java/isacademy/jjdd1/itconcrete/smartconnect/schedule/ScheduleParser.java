package isacademy.jjdd1.itconcrete.smartconnect.parser;

import isacademy.jjdd1.itconcrete.smartconnect.data.BusConnection;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by katarzynadobrowolska on 01.04.2017.
 */
public class ScheduleParser {

    /*public BusConnection[] parseDataFromPath(String schedulePath) {
        //TODO logic here
        return null;
    }*/
    public void scheduleParser(){
        URL resource = getClass().getResource("C:\\Users\\Ageee\\IdeaProjects\\jjdd1-itconcrete\\src\\main\\java\\isacademy\\jjdd1\\itconcrete\\smartconnect\\resources\\rozklady_2015-09-08_13.43.01\\136_20140802\\136_20140802warianty1.csv");
        List<String> lines = Files.readAllLines(Paths.get(resource.toURI()));
        int currentLineNumber = 0;
        for (String line : lines) {
            currentLineNumber+=1;
            String[] elements = line.split(",");
        }

    }



}
