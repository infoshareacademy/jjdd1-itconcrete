package isacademy.jjdd1.itconcrete.smartconnect.analyzer_direct;

import isacademy.jjdd1.itconcrete.smartconnect.result.DirectResultConnection;

import java.util.List;

class DirectShrinker {

    public List<DirectResultConnection> shrinkDirectResults(List<DirectResultConnection> directResultConnections, int maxAmountOfResults) {

        int size = directResultConnections.size();
        if (size > maxAmountOfResults) {
            for (int i = size-maxAmountOfResults-1; i >= 0; i--) {
                directResultConnections.remove(i);
            }
        }
        return directResultConnections;
    }
}
