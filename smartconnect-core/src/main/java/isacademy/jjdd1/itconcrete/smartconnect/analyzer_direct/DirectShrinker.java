package isacademy.jjdd1.itconcrete.smartconnect.analyzer_direct;

import isacademy.jjdd1.itconcrete.smartconnect.result.DirectResultConnection;

import java.util.List;

class DirectShrinker {

    final int MAX_RESULTS_AMOUNT = 3;

    public List<DirectResultConnection> shrinkDirectResults(List<DirectResultConnection> directResultConnections) {

        int size = directResultConnections.size();
        if (size > MAX_RESULTS_AMOUNT) {
            for (int i = size - MAX_RESULTS_AMOUNT - 1; i >= 0; i--) {
                directResultConnections.remove(i);
            }
        }
        return directResultConnections;
    }
}
