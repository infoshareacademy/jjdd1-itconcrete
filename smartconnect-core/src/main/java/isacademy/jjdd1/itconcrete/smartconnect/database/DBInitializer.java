package isacademy.jjdd1.itconcrete.smartconnect.database;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Singleton
public class DBInitializer {

    @PersistenceContext
    private EntityManager entityManager;

    public DBInitializer() {
        entityManager.persist(new BusLineStatistics());
        entityManager.persist(new BusStopStatistics());
    }
}
