package isacademy.jjdd1.itconcrete.smartconnect.displayer;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.ResultConnection;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import java.time.LocalTime;


public class DisplayConnection {

    public String displayingConnection(ResultConnection resultConnections) {

        int lineNumber = resultConnections.getLineNumber();
        LocalTime travelStartTime = resultConnections.getTravelStartTime();
        LocalTime travelEndTime = resultConnections.getTravelEndTime();
        String startBusStop = resultConnections.getStartBusStop();
        String endBusStop = resultConnections.getEndBusStop();

        Util util = new Util();

        String connectionResultText = lineNumber + " - start journey at: " + util.prettyFormatTime(travelStartTime) + ", you will reach destination "
                 + util.prettyFormatTime(travelEndTime);

        return connectionResultText;
    }

    public String displayEventHeader(Journey journey) {

        String fromBusStop = journey.getStartBusStop();
        String toBusStop = journey.getEndBusStop();
        String eventHeaderText = "From bus stop " + fromBusStop + " to bus stop " + toBusStop + " you can take lines:";

        return eventHeaderText;
    }
}
