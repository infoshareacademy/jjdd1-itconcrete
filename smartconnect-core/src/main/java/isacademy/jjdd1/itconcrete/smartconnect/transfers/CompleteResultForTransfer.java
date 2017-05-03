package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.ResultConnection;

import java.util.List;

public class CompleteResultForTransfer {

    private String startLocation;
    private String endLocation;
    private String startBusStop;
    private String midBusStop;
    private String endBusStop;
    private List<ResultConnection> resultConnectionListforStartLine;
    private List<ResultConnection> resultConnectionListforEndLine;


    public CompleteResultForTransfer(String startLocation, String endLocation, String startBusStop, String midBusStop,
                                     String endBusStop, List<ResultConnection> resultConnectionListforStartLine,
                                     List<ResultConnection> resultConnectionListforEndLine) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startBusStop = startBusStop;
        this.midBusStop = midBusStop;
        this.endBusStop = endBusStop;
        this.resultConnectionListforStartLine = resultConnectionListforStartLine;
        this.resultConnectionListforEndLine = resultConnectionListforEndLine;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public String getStartBusStop() {
        return startBusStop;
    }

    public void setStartBusStop(String startBusStop) {
        this.startBusStop = startBusStop;
    }

    public String getMidBusStop() {
        return midBusStop;
    }

    public void setMidBusStop(String midBusStop) {
        this.midBusStop = midBusStop;
    }

    public String getEndBusStop() {
        return endBusStop;
    }

    public void setEndBusStop(String endBusStop) {
        this.endBusStop = endBusStop;
    }

    public List<ResultConnection> getResultConnectionListforStartLine() {
        return resultConnectionListforStartLine;
    }

    public void setResultConnectionListforStartLine(List<ResultConnection> resultConnectionListforStartLine) {
        this.resultConnectionListforStartLine = resultConnectionListforStartLine;
    }

    public List<ResultConnection> getResultConnectionListforEndLine() {
        return resultConnectionListforEndLine;
    }

    public void setResultConnectionListforEndLine(List<ResultConnection> resultConnectionListforEndLine) {
        this.resultConnectionListforEndLine = resultConnectionListforEndLine;
    }


    @Override
    public String toString() {
        return "CompleteResultForTransfer{" +
                "startLocation='" + startLocation + '\'' +
                ", endLocation='" + endLocation + '\'' +
                ", startBusStop='" + startBusStop + '\'' +
                ", midBusStop='" + midBusStop + '\'' +
                ", endBusStop='" + endBusStop + '\'' +
                ", resultConnectionListforStartLine=" + resultConnectionListforStartLine +
                ", resultConnectionListforEndLine=" + resultConnectionListforEndLine +
                '}';
    }
}



