package isacademy.jjdd1.itconcrete.smartconnect.displayer;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.ResultConnection;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DisplayConnection {

    private String connectionResultText;

    public String displayingConnection(ResultConnection resultConnections) {

        int lineNumber = resultConnections.getLineNumber();
        LocalTime travelStartTime = resultConnections.getTravelStartTime();
        LocalTime travelEndTime = resultConnections.getTravelEndTime();
        String fromBusStop = resultConnections.getFromBusStop();
        String toBusStop = resultConnections.getToBusStop();

        connectionResultText = "The best connection to: " + fromBusStop + " is line number: " + lineNumber +
                ", start your journey at: " + prettyFormatTime(travelStartTime) + ", you will reach your destination " + toBusStop +
                " at: " + prettyFormatTime(travelEndTime);

        return connectionResultText;
    }

    private String prettyFormatTime(LocalTime time) {

        DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
        return formatter.print(time);
    }
}
