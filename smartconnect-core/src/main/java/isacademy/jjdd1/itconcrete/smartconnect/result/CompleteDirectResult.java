package isacademy.jjdd1.itconcrete.smartconnect.result;

import java.util.List;

public class CompleteDirectResult {

    private String startLocation;
    private String endLocation;
    private String startBusStop;
    private String endBusStop;
    private List<DirectResultConnection> directResultConnectionList;

    public CompleteDirectResult(String startLocation, String endLocation, String startBusStop, String endBusStop, List<DirectResultConnection> directResultConnectionList) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startBusStop = startBusStop;
        this.endBusStop = endBusStop;
        this.directResultConnectionList = directResultConnectionList;
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

    public List<DirectResultConnection> getDirectResultConnectionList() {
        return directResultConnectionList;
    }

    @Override
    public String toString() {
        return "CompleteDirectResult{" +
                "startLocation='" + startLocation + '\'' +
                ", endLocation='" + endLocation + '\'' +
                ", startBusStop='" + startBusStop + '\'' +
                ", endBusStop='" + endBusStop + '\'' +
                ", directResultConnectionList=" + directResultConnectionList +
                '}';
    }
}

