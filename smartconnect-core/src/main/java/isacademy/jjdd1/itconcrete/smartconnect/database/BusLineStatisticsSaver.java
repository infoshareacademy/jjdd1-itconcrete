package isacademy.jjdd1.itconcrete.smartconnect.database;

import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.LineStatisticsData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(BusLineStatisticsSaver.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void updateBusLineStatistics(int lineNumber, int occurences) {
        LOGGER.info("Starting to collect line statistics.");

        Map<Integer, Integer> lineNumbers = getBusLineStatistics();
        LOGGER.info("Mapping line numbers.");

        if (!lineNumbers.isEmpty() && lineNumbers.containsKey(lineNumber)) {
            Query query = entityManager.createQuery("UPDATE BusLineStatistics bls SET " +
                    "bls.occurences = bls.occurences + 1 WHERE bls.lineNumber = ?1");
            query.setParameter(1, lineNumber).executeUpdate();
        }
        else {
            LOGGER.info("Inserting new row in database; linenumber and occurences "
                    + lineNumber +  " " + occurences);
            entityManager.persist(new BusLineStatistics(lineNumber, occurences));
        }
    }


    public Map<Integer, Integer> getBusLineStatistics(){
       LOGGER.info("Get busline stats");

        List<Integer> lines = entityManager.createQuery("SELECT bls.lineNumber " +
                    "FROM BusLineStatistics bls ORDER BY bls.occurences DESC", Integer.class)
                    .setMaxResults(10).getResultList();



        List<Integer> values  = entityManager.createQuery("SELECT bls.occurences " +
                    "FROM BusLineStatistics bls ORDER BY bls.occurences DESC", Integer.class)
                    .setMaxResults(10).getResultList();

        Map<Integer, Integer> results = new LinkedHashMap<>();
        if (lines != null && values != null) {
            for (int i = 0; i < lines.size(); i++) {
                results.put(lines.get(i), values.get(i));
            }
        }
        LOGGER.info("results size: " + results.size());
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

