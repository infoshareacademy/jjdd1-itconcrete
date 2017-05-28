package isacademy.jjdd1.itconcrete.smartconnect;

import isacademy.jjdd1.itconcrete.smartconnect.database.BusLineStatistics;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by agata on 5/28/17.
 */

@Singleton
public class testEnt {

    @PersistenceContext
    private EntityManager entityManager;

    public void go () {
        BusLineStatistics bls = new BusLineStatistics(3, 5);
        entityManager.persist(bls);
    }
}
