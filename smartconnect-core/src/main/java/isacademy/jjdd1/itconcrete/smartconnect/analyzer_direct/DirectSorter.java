package isacademy.jjdd1.itconcrete.smartconnect.analyzer_direct;

import isacademy.jjdd1.itconcrete.smartconnect.result.DirectResultConnection;

import java.util.List;

class DirectSorter {

    public List<DirectResultConnection> sortDirectResultsByTravelEnd(List<DirectResultConnection> directResultConnectionList){

        directResultConnectionList.sort((o1, o2) -> o2.getTravelEndTime().compareTo(o1.getTravelEndTime()));

        return directResultConnectionList;
    }

}
