package isacademy.jjdd1.itconcrete.smartconnect.displayer;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.ResultConnection;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarEvent;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DisplayConnection {

    public String displayingConnection(ResultConnection resultConnections) {

        int lineNumber = resultConnections.getLineNumber();
        LocalTime travelStartTime = resultConnections.getTravelStartTime();
        LocalTime travelEndTime = resultConnections.getTravelEndTime();
        String fromBusStop = resultConnections.getFromBusStop();
        String toBusStop = resultConnections.getToBusStop();

        String connectionResultText = lineNumber + " - start journey at: " + prettyFormatTime(travelStartTime) + ", you will reach destination "
                 + prettyFormatTime(travelEndTime);

        return connectionResultText;
    }

    private String prettyFormatTime(LocalTime time) {

        DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
        return formatter.print(time);
    }

    public String displayEventHeader(CalendarEvent calendarEvent) {

        String fromBusStop = calendarEvent.getFromBusStop();
        String toBusStop = calendarEvent.getToBusStop();
        String eventHeaderText = "From bus stop " + fromBusStop + " to bus stop " + toBusStop + " you can take lines:";

        return eventHeaderText;
    }
}
