package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.LineRideTime;

public class TransferRidePair {

    LineRideTime lineRideTimeforStartPart;
    LineRideTime lineRideTimeForEndPart;

    public TransferRidePair(LineRideTime lineRideTimeforStartPart, LineRideTime lineRideTimeForEndPart) {
        this.lineRideTimeforStartPart = lineRideTimeforStartPart;
        this.lineRideTimeForEndPart = lineRideTimeForEndPart;
    }

    public LineRideTime getLineRideTimeforStartPart() {
        return lineRideTimeforStartPart;
    }

    public void setLineRideTimeforStartPart(LineRideTime lineRideTimeforStartPart) {
        this.lineRideTimeforStartPart = lineRideTimeforStartPart;
    }

    public LineRideTime getLineRideTimeForEndPart() {
        return lineRideTimeForEndPart;
    }

    public void setLineRideTimeForEndPart(LineRideTime lineRideTimeForEndPart) {
        this.lineRideTimeForEndPart = lineRideTimeForEndPart;
    }

    @Override
    public String toString() {
        return "TransferRidePair{" +
                "lineRideTimeforStartPart=" + lineRideTimeforStartPart +
                ", lineRideTimeForEndPart=" + lineRideTimeForEndPart +
                '}';
    }
}
