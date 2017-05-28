package com.isacademy.jjdd1.itconcrete.statistics;

import com.isacademy.jjdd1.itconcrete.database.HomeBusStopUpdater;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class HomeBusStopStatsGetter {

    @Inject
    HomeBusStopUpdater homeBusStopUpdater;

    @PersistenceContext
    EntityManager entityManager;

    public List<StopStatsData> getStatistics(){

        List<StopStatsData> results = new ArrayList<>();

        try {
            List<String> stops = entityManager.createQuery("SELECT hbs.homeBusStopName " +
                    "FROM HomeBusStop hbs ORDER BY hbs.occurences")
                    .setMaxResults(3).getResultList();

            int currentOccurence = 0;
            if(stops != null){
                for (int i = 0; i < stops.size(); i++) {
                    currentOccurence = homeBusStopUpdater.getValuForHomeBusStop(stops.get(i));
                    results.add(new StopStatsData(stops.get(i),currentOccurence ));
                }
            }

            return results;

        } catch (NoResultException e) {}

        return results;
    }
}
