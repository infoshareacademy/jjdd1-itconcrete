package isacademy.jjdd1.itconcrete.smartconnect.analyzer_direct;

import isacademy.jjdd1.itconcrete.smartconnect.result.DirectResultConnection;

import java.util.List;

class DirectSorter {

    public List<DirectResultConnection> sortDirectResultsByTravelEndDesc(List<DirectResultConnection> directResultConnectionList){

        directResultConnectionList.sort((o1, o2) -> o2.getTravelEndTime().compareTo(o1.getTravelEndTime()));

        return directResultConnectionList;
    }

    public List<DirectResultConnection> sortDirectResultsByTravelStartAsc(List<DirectResultConnection> directResultConnectionList){

        directResultConnectionList.sort((o1, o2) -> o1.getTravelStartTime().compareTo(o2.getTravelStartTime()));

        return directResultConnectionList;
    }

}
