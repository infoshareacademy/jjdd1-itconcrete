package isacademy.jjdd1.itconcrete.smartconnect.database;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Singleton
public class BusLineStatisticsSaver {

    @PersistenceContext
    private EntityManager entityManager;

    public void updateBusLineStatistics(int lineNumber) {
        Map<Integer, Integer> lineNumbers = getBusLineStatistics();
        if (!lineNumbers.isEmpty() && lineNumbers.containsKey(lineNumber)) {
            Query query = entityManager.createQuery("UPDATE BusLineStatistics bls SET " +
                    "bls.occurences = bls.occurences + 1 WHERE bls.lineNumber = ?1");
            query.setParameter(1, lineNumber).executeUpdate();
        }
        else {
            entityManager.persist(new BusLineStatistics(lineNumber, 1));
        }
    }


    public Map<Integer, Integer> getBusLineStatistics(){
        List<Integer> lines = entityManager.createQuery("SELECT bls.lineNumber " +
                "FROM BusLineStatistics bls ORDER BY bls.occurences DESC", Integer.class)
                .setMaxResults(10).getResultList();
        List<Integer> values = entityManager.createQuery("SELECT bls.occurences " +
                "FROM BusLineStatistics bls ORDER BY bls.occurences DESC", Integer.class)
                .setMaxResults(10).getResultList();
        Map<Integer, Integer> results = new LinkedHashMap<>();
        if (lines != null && values != null) {
            for (int i = 0; i < lines.size(); i++) {
                results.put(lines.get(i), values.get(i));
            }
        }
        return results;
    }

    public void clearTable() {
        entityManager.createQuery("DELETE FROM BusLineStatistics").executeUpdate();
    }
}

