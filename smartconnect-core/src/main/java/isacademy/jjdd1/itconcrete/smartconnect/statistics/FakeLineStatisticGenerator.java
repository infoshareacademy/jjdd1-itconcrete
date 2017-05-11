package isacademy.jjdd1.itconcrete.smartconnect.statistics;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;

import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

@RequestScoped
public class FakeLineStatisticGenerator {

    ArrayList<StatisticsData> statistics = new ArrayList<>();

    public void loadData() throws IOException {

        ScheduleParser scheduleParser = new ScheduleParser();
        ArrayList<Integer> allBusLineNumbers = scheduleParser.getAllLineNumbers();
        ArrayList<Integer> listOfAlreadyAddedLines = new ArrayList<>();

        int upperboundForRandomValues = 100;
        int lowerboundForRandomValues = 1;

        for (int i = 0; i < 10 ; i++) {
            Random random = new Random();
            int randomLineNumber = allBusLineNumbers.get(random.nextInt(allBusLineNumbers.size()));
            if (!listOfAlreadyAddedLines.contains(randomLineNumber)){
                listOfAlreadyAddedLines.add(randomLineNumber);
                int generatedValue = (int)(Math.random() * ((upperboundForRandomValues - lowerboundForRandomValues) + 1) + lowerboundForRandomValues);
                statistics.add(new StatisticsData(randomLineNumber,generatedValue));
            }

        }

    }

    public ArrayList<StatisticsData> getStatistics() {
        return statistics;
    }
}
