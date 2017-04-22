package isacademy.jjdd1.itconcrete.smartconnect.forwebapp;

import isacademy.jjdd1.itconcrete.smartconnect.analyzer.ResultConnection;
import java.util.List;

public class ResultForWebApp {

    private String startLocation;
    private String endLocation;
    private String startBusStop;
    private String endBusStop;
    private List<ResultConnection> resultConnectionList;

    public ResultForWebApp(String startLocation, String endLocation, String startBusStop, String endBusStop, List<ResultConnection> resultConnectionList) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startBusStop = startBusStop;
        this.endBusStop = endBusStop;
        this.resultConnectionList = resultConnectionList;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public String getStartBusStop() {
        return startBusStop;
    }

    public String getEndBusStop() {
        return endBusStop;
    }

    public List<ResultConnection> getResultConnectionList() {
        return resultConnectionList;
    }

    @Override
    public String toString() {
        return "ResultForWebApp{" +
                "startLocation='" + startLocation + '\'' +
                ", endLocation='" + endLocation + '\'' +
                ", startBusStop='" + startBusStop + '\'' +
                ", endBusStop='" + endBusStop + '\'' +
                ", resultConnectionList=" + resultConnectionList +
                '}';
    }
}

