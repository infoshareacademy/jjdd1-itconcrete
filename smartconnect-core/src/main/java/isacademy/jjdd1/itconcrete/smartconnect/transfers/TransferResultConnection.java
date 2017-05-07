package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import java.time.LocalTime;

class TransferResultConnection {

    private String startBusStop;
    private int firstLineNumber;
    private LocalTime departureFirstLine;
    private LocalTime arrivalFirstLine;
    private String midBusStop;
    private int secondLineNumber;
    private LocalTime departureSecondLine;
    private LocalTime arrivalSecondLine;
    private String endBusStop;

    public TransferResultConnection(String startBusStop, int firstLineNumber, LocalTime departureFirstLine,
                                    LocalTime arrivalFirstLine, String midBusStop, int secondLineNumber,
                                    LocalTime departureSecondLine, LocalTime arrivalSecondLine, String endBusStop) {
        this.startBusStop = startBusStop;
        this.firstLineNumber = firstLineNumber;
        this.departureFirstLine = departureFirstLine;
        this.arrivalFirstLine = arrivalFirstLine;
        this.midBusStop = midBusStop;
        this.secondLineNumber = secondLineNumber;
        this.departureSecondLine = departureSecondLine;
        this.arrivalSecondLine = arrivalSecondLine;
        this.endBusStop = endBusStop;
    }

    public String getStartBusStop() {
        return startBusStop;
    }

    public void setStartBusStop(String startBusStop) {
        this.startBusStop = startBusStop;
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

    public String getMidBusStop() {
        return midBusStop;
    }

    public void setMidBusStop(String midBusStop) {
        this.midBusStop = midBusStop;
    }

    public int getSecondLineNumber() {
        return secondLineNumber;
    }

    public void setSecondLineNumber(int secondLineNumber) {
        this.secondLineNumber = secondLineNumber;
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

    public String getEndBusStop() {
        return endBusStop;
    }

    public void setEndBusStop(String endBusStop) {
        this.endBusStop = endBusStop;
    }

    @Override
    public String toString() {
        return "TransferResultConnection{" +
                "startBusStop='" + startBusStop + '\'' +
                ", firstLineNumber=" + firstLineNumber +
                ", departureFirstLine=" + departureFirstLine +
                ", arrivalFirstLine=" + arrivalFirstLine +
                ", midBusStop='" + midBusStop + '\'' +
                ", secondLineNumber=" + secondLineNumber +
                ", departureSecondLine=" + departureSecondLine +
                ", arrivalSecondLine=" + arrivalSecondLine +
                ", endBusStop='" + endBusStop + '\'' +
                '}' + "\n";
    }
}
