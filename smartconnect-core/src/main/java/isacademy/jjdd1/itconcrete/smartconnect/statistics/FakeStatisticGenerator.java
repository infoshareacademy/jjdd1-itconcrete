package isacademy.jjdd1.itconcrete.smartconnect.statistics;


import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class FakeStatisticGenerator {

    ScheduleParser scheduleParser = new ScheduleParser();
    ArrayList<Integer> allBusLineNumbers = scheduleParser.getAllLineNumbers();
    ArrayList<StatisticsData> statistics = new ArrayList<>();

    public FakeStatisticGenerator() throws IOException {
        loadData();
    }

    private void loadData() throws IOException {

        ArrayList<Integer> listOfAlreadyAddedLines = new ArrayList<>();
        for (int i = 0; i < 11 ; i++) {
            Random random = new Random();
            int randomLineNumber = allBusLineNumbers.get(random.nextInt(allBusLineNumbers.size()));
            if (!listOfAlreadyAddedLines.contains(randomLineNumber)){
                listOfAlreadyAddedLines.add(randomLineNumber);
                int generatedValue = (int)(Math.random()*101);
                statistics.add(new StatisticsData(randomLineNumber,generatedValue));
            }

        }

    }

    public ArrayList<StatisticsData> getStatistics() {
        return statistics;
    }
}
