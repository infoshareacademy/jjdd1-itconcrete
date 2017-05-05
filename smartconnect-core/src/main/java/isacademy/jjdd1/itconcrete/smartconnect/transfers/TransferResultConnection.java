package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import java.time.LocalTime;

public class TransferResultConnection {

    int firstLineNumber;
    LocalTime departureFirstLine;
    LocalTime arrivalFirstLine;
    int secondLine;
    LocalTime departureSecondLine;
    LocalTime arrivalSecondLine;

    public TransferResultConnection(int firstLineNumber, LocalTime departureFirstLine, LocalTime arrivalFirstLine, int secondLine, LocalTime departureSecondLine, LocalTime arrivalSecondLine) {
        this.firstLineNumber = firstLineNumber;
        this.departureFirstLine = departureFirstLine;
        this.arrivalFirstLine = arrivalFirstLine;
        this.secondLine = secondLine;
        this.departureSecondLine = departureSecondLine;
        this.arrivalSecondLine = arrivalSecondLine;
    }

    public int getFirstLineNumber() {
        return firstLineNumber;
    }

    public void setFirstLineNumber(int firstLineNumber) {
        this.firstLineNumber = firstLineNumber;
    }

    public LocalTime getDepartureFirstLine() {
        return departureFirstLine;
    }

    public void setDepartureFirstLine(LocalTime departureFirstLine) {
        this.departureFirstLine = departureFirstLine;
    }

    public LocalTime getArrivalFirstLine() {
        return arrivalFirstLine;
    }

    public void setArrivalFirstLine(LocalTime arrivalFirstLine) {
        this.arrivalFirstLine = arrivalFirstLine;
    }

    public int getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(int secondLine) {
        this.secondLine = secondLine;
    }

    public LocalTime getDepartureSecondLine() {
        return departureSecondLine;
    }

    public void setDepartureSecondLine(LocalTime departureSecondLine) {
        this.departureSecondLine = departureSecondLine;
    }

    public LocalTime getArrivalSecondLine() {
        return arrivalSecondLine;
    }

    public void setArrivalSecondLine(LocalTime arrivalSecondLine) {
        this.arrivalSecondLine = arrivalSecondLine;
    }


    @Override
    public String toString() {
        return "TransferResultConnection{" +
                "firstLineNumber=" + firstLineNumber +
                ", departureFirstLine=" + departureFirstLine +
                ", arrivalFirstLine=" + arrivalFirstLine +
                ", secondLine=" + secondLine +
                ", departureSecondLine=" + departureSecondLine +
                ", arrivalSecondLine=" + arrivalSecondLine +
                '}' + "\n";
    }
}
