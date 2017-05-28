package isacademy.jjdd1.itconcrete.smartconnect.database;

import isacademy.jjdd1.itconcrete.smartconnect.statistics.LineStatisticsData;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Singleton
public class BusLineStatisticsSaver {

    @PersistenceContext
    private EntityManager entityManager;

    public void updateBusLineStatistics(int lineNumber, int occurences) {
        System.out.println("starting to collect line statistics..........");
        Map<Integer, Integer> lineNumbers = getBusLineStatistics();
        System.out.println("mapping line numbers");
        if (!lineNumbers.isEmpty() && lineNumbers.containsKey(lineNumber)) {
            Query query = entityManager.createQuery("UPDATE BusLineStatistics bls SET " +
                    "bls.occurences = bls.occurences + 1 WHERE bls.lineNumber = ?1");
            query.setParameter(1, lineNumber).executeUpdate();
        }
        else {
            System.out.println("i am elsing in busline stats saver");
            System.out.println("linenumber and occurences " + lineNumber +  " " + occurences);
            BusLineStatistics blr = new BusLineStatistics(3,1);
            System.out.println("line nuuuuuuuuu" + blr.getLineNumber());
//            entityManager.merge(blr);
//            entityManager.flush();
            System.out.println("flushed");
        }
    }


    public Map<Integer, Integer> getBusLineStatistics(){
        System.out.println("Get busline stats");

        List<Integer> lines = new ArrayList<>();
        try {
            lines = entityManager.createQuery("SELECT bls.lineNumber " +
                    "FROM BusLineStatistics bls ORDER BY bls.occurences DESC", Integer.class)
                    .setMaxResults(10).getResultList();
        } catch (NullPointerException e){}
        System.out.println("1....");

        List<Integer> values = new ArrayList<>();
        try {
            values = entityManager.createQuery("SELECT bls.occurences " +
                    "FROM BusLineStatistics bls ORDER BY bls.occurences DESC", Integer.class)
                    .setMaxResults(10).getResultList();
        } catch (NullPointerException e) {}
        System.out.println("2,,,,");
        Map<Integer, Integer> results = new LinkedHashMap<>();
        if (lines != null && values != null) {
            for (int i = 0; i < lines.size(); i++) {
                results.put(lines.get(i), values.get(i));
            }
        }
        System.out.println("results size" + results.size());
        return results;
    }


    public List<LineStatisticsData> getConvertedBusLineStatistics(){
        Map <Integer,Integer> thisMap = getBusLineStatistics();
        List<LineStatisticsData> busLineStatistics = new ArrayList<>();
        for (Integer key : thisMap.keySet()){
            busLineStatistics.add(new LineStatisticsData(key, thisMap.get(key)));
        }
        return busLineStatistics;
    }

    public void clearTable() {
        entityManager.createQuery("DELETE FROM BusLineStatistics").executeUpdate();
    }
}

