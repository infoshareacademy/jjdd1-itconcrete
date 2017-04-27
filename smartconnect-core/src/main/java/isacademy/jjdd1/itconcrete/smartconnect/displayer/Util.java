package isacademy.jjdd1.itconcrete.smartconnect.displayer;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusStopDeltas;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public boolean busStopExistence(String busStop, ArrayList<BusLine> busLinesForSeeking) {

        boolean busStopExistence = false;

        for (BusLine currentlyCheckedBusLine : busLinesForSeeking) {

            List<BusStopDeltas> deltasList = currentlyCheckedBusLine.getRoute().getDeltasList();

            for (BusStopDeltas currentlyCheckedBusStopDelta : deltasList) {

                if (currentlyCheckedBusStopDelta.getBusStopName().toLowerCase().equals(busStop.toLowerCase())
                        && currentlyCheckedBusStopDelta.getTimeDifference() >= 0) {
                    busStopExistence = true;
                }
            }
        }
        return busStopExistence;
    }


    public LocalTime timeFromKeyboardParser(String timeInString) {
        return LocalTime.parse(timeInString);
    }


    public String prettyFormatTime(LocalTime time) {
        return time.truncatedTo(ChronoUnit.MINUTES).toString();
    }


    public static String makeFirstLetterCapital(String busName){

        String result = busName.substring(0,1).toUpperCase() + busName.substring(1, busName.length()).toLowerCase();

        return result;
    }

}
