package isacademy.jjdd1.itconcrete.smartconnect.database;


import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class BusStopStatisticsSaver {

    @PersistenceContext
    private EntityManager entityManager;

    public void updateBusStopStatistics(String stopName, int occurences) {
        Map<String, Integer> stops = getBusStopStatistics();
        if (!stops.isEmpty() && stops.containsKey(stopName)) {
            Query query = entityManager.createQuery("UPDATE BusStopStatistics bss SET " +
                    "bss.occurences = bss.occurences + 1 WHERE bss.stopName = ?1");
            query.setParameter(1, stopName).executeUpdate();
        }
        else {
            entityManager.persist(new BusStopStatistics(stopName, occurences));
        }
    }


    public Map<String, Integer> getBusStopStatistics(){
        List<String> stops = entityManager.createQuery("SELECT bss.stopName " +
                "FROM BusStopStatistics bss ORDER BY bss.occurences DESC", String.class)
                .setMaxResults(10).getResultList();
        List<Integer> values = entityManager.createQuery("SELECT bss.occurences " +
                "FROM BusStopStatistics bss ORDER BY bss.occurences DESC", Integer.class)
                .setMaxResults(10).getResultList();
        Map<String, Integer> results = new LinkedHashMap<>();
        if (stops != null && values != null) {
            for (int i = 0; i < stops.size(); i++) {
                results.put(stops.get(i), values.get(i));
            }
        }
        return results;
    }

    public void clearTable() {
        entityManager.createQuery("DELETE FROM BusStopStatistics").executeUpdate();
    }
}
