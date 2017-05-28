package com.isacademy.jjdd1.itconcrete.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by agata on 5/28/17.
 */
@Singleton
public class HomeBusStopUpdater {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeBusStopUpdater.class);

    @PersistenceContext
    EntityManager entityManager;

    public List<String> getHomeBusStops() {
        return entityManager.createQuery("SELECT s.homeBusStopName from HomeBusStop s").getResultList();
    }

    @PostConstruct
    public void setHomeBusStop() {
        HomeBusStop klonowa = new HomeBusStop("Klonowa", 1);
        entityManager.persist(klonowa);
    }
}
