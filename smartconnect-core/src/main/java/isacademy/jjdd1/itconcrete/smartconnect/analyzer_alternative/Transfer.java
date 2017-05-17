package isacademy.jjdd1.itconcrete.smartconnect.analyzer_alternative;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;


public class Transfer {

    private BusLine startLine;
    private BusLine endLine;
    private List<String> commonStops;

    public Transfer(BusLine startLine, BusLine endLine) {
        this.startLine = startLine;
        this.endLine = endLine;
        commonStops = new ArrayList<>();
    }

    public List<String> getCommonStops(){
        List<String> common = startLine.getRoute().getArrayOfStops().stream().filter
                (endLine.getRoute().getArrayOfStops()::contains).collect(toList());
        return common;
    }

    public BusLine getStartLine() {
        return startLine;
    }

    public BusLine getEndLine() {
        return endLine;
    }


    @Override
    public String toString() {
        return "Transfer{" +
                "startLine=" + startLine +
                ", endLine=" + endLine +
                '}';
    }
}
