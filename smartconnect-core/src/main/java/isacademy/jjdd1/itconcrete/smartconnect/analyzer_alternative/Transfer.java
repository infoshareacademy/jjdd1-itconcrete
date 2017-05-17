package isacademy.jjdd1.itconcrete.smartconnect.analyzer_alternative;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusLine;


public class Transfer {

    private BusLine startLine;
    private BusLine endLine;

    public Transfer(BusLine startLine, BusLine endLine) {
        this.startLine = startLine;
        this.endLine = endLine;
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
