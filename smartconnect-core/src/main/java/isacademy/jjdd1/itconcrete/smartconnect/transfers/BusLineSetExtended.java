package isacademy.jjdd1.itconcrete.smartconnect.transfers;

import java.util.List;

public class BusLineSetExtended {

    private String startBusStop;
    private String endBusStop;
    private List<BusLineSet> busLineSetList;

    public BusLineSetExtended(String startBusStop, String endBusStop, List<BusLineSet> busLineSetList) {
        this.startBusStop = startBusStop;
        this.endBusStop = endBusStop;
        this.busLineSetList = busLineSetList;
    }

    public String getStartBusStop() {
        return startBusStop;
    }

    public void setStartBusStop(String startBusStop) {
        this.startBusStop = startBusStop;
    }

    public String getEndBusStop() {
        return endBusStop;
    }

    public void setEndBusStop(String endBusStop) {
        this.endBusStop = endBusStop;
    }

    public List<BusLineSet> getBusLineSetList() {
        return busLineSetList;
    }

    public void setBusLineSetList(List<BusLineSet> busLineSetList) {
        this.busLineSetList = busLineSetList;
    }

    @Override
    public String toString() {
        return "BusLineSetExtended{" +
                "startBusStop='" + startBusStop + '\'' +
                ", endBusStop='" + endBusStop + '\'' + "\n" +
                ", busLineSetList=" + "\n" + busLineSetList +
                '}' + "\n";
    }
}



