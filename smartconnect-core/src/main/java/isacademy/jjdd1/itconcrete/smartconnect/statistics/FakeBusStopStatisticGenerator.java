package isacademy.jjdd1.itconcrete.smartconnect.statistics;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;
import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

@RequestScoped
public class FakeBusStopStatisticGenerator {

    ArrayList<StopStatisticsData> statistics = new ArrayList<>();

    public void loadData() throws IOException {

        ScheduleParser scheduleParser = new ScheduleParser();
        ArrayList<String> allBusStopNames = scheduleParser.getAllBusStopNames();
        ArrayList<String> listOfAlreadyAddedStops = new ArrayList<>();

        int upperboundForRandomValues = 100;
        int lowerboundForRandomValues = 1;

        for (int i = 0; i < 6 ; i++) {
            Random random = new Random();
            String randomBusStopName = allBusStopNames.get(random.nextInt(allBusStopNames.size()));
            if (!listOfAlreadyAddedStops.contains(randomBusStopName)){
                listOfAlreadyAddedStops.add(randomBusStopName);
                int generatedValue = (int)(Math.random() * ((upperboundForRandomValues - lowerboundForRandomValues) + 1) + lowerboundForRandomValues);
                statistics.add(new StopStatisticsData(randomBusStopName,generatedValue));
            }

        }

    }

    public ArrayList<StopStatisticsData> getStatistics() {
        return statistics;
    }
}
