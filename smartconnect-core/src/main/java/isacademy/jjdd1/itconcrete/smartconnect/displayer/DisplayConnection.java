package isacademy.jjdd1.itconcrete.smartconnect.displayer;

import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import isacademy.jjdd1.itconcrete.smartconnect.result.DirectResultConnection;
import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteDirectResult;
import isacademy.jjdd1.itconcrete.smartconnect.result.TransferResultConnection;

import java.time.LocalTime;


public class DisplayConnection {


    public String displayEventHeader(Journey journey) {

        String fromBusStop = journey.getStartBusStop();
        String toBusStop = journey.getEndBusStop();
        String eventHeaderText = "From " + fromBusStop + " to " + toBusStop + " you can take lines:";

        return eventHeaderText;
    }


    public String displayingDirectConnection(DirectResultConnection directResultConnections) {

        int lineNumber = directResultConnections.getLineNumber();
        LocalTime travelStartTime = directResultConnections.getTravelStartTime();
        LocalTime travelEndTime = directResultConnections.getTravelEndTime();

        Util util = new Util();

        String directResultText = lineNumber + " - start journey at: " + util.prettyFormatTime(travelStartTime) + ", you will reach destination "
                 + util.prettyFormatTime(travelEndTime);

        return directResultText;
    }


    public String displayingTransferConnection(TransferResultConnection transferResultConnection) {

        int firstLineNumber = transferResultConnection.getFirstLineNumber();

        LocalTime departureFirstLine = transferResultConnection.getDepartureFirstLine();
        LocalTime arrivalFirstLine = transferResultConnection.getArrivalFirstLine();

        String midBusStop = transferResultConnection.getMidBusStop();

        int secondLineNumber = transferResultConnection.getSecondLineNumber();

        LocalTime departureSecondLine = transferResultConnection.getDepartureSecondLine();
        LocalTime arrivalSecondLine = transferResultConnection.getArrivalSecondLine();

        String transferResultText = firstLineNumber + " - start journey at: " + departureFirstLine
                + ", you will reach transfer bus stop at: " + arrivalFirstLine +
                ". Take transfer from " + midBusStop + ", " + secondLineNumber
                + " - start journey at: " + departureSecondLine +
                ", you will reach destination at: " + arrivalSecondLine;

        return transferResultText;
    }
}
