package com.isacademy.jjdd1.itconcrete.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by agata on 5/28/17.
 */
@Singleton
public class HomeBusStopUpdater {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeBusStopUpdater.class);

    @PersistenceContext
    EntityManager entityManager;


    public void updateTable(String homeBusStopName){
        boolean presence = checkIfRecordAlreadyExist(homeBusStopName);
        if(presence){
            incrementOccurences(homeBusStopName);
        } else {
            addNewHomeBusStopToTable(homeBusStopName);
        }

    }

    private boolean checkIfRecordAlreadyExist(String homeBusStopName){
        Query query = entityManager.createQuery("SELECT  hbs.occurences FROM HomeBusStop hbs  " +
                " WHERE hbs.homeBusStopName = ?1");
        int occurences = (int) query.setParameter(1, homeBusStopName).getSingleResult();
        Optional<Integer> integerOptional = Optional.ofNullable(occurences);
        if (integerOptional.isPresent()){
            return true;
        } else {
            return false;
        }
    }

    private void incrementOccurences(String name){
        Query query = entityManager.createQuery("UPDATE HomeBusStop hbs SET " +
                    "hbs.occurences = hbs.occurences + 1 WHERE hbs.homeBusStopName = ?1");
        query.setParameter(1, name).executeUpdate();
    }

    private void addNewHomeBusStopToTable(String name){
        entityManager.persist(new HomeBusStop(name, 1));
    }

    public List<String> getListOfAllHomeBusStops() {
        return entityManager.createQuery("SELECT s.homeBusStopName from HomeBusStop s").getResultList();
    }

    @PostConstruct
    public void setHomeBusStop() {
        HomeBusStop klonowa = new HomeBusStop("Klonowa", 1);
        entityManager.persist(klonowa);
        HomeBusStop emaus = new HomeBusStop("Emaus", 1);
        entityManager.persist(emaus);
    }

    public int getValuForHomeBusStop(String homeBusStopName){
        Query query = entityManager.createQuery("SELECT  hbs.occurences FROM HomeBusStop hbs  " +
                " WHERE hbs.homeBusStopName = ?1");
        int occurences = (int) query.setParameter(1, homeBusStopName).getSingleResult();
        return occurences;
    }
}
//
//    public void updateCountryStatistics(String country) {
//        Map<String, Integer> countries = getCountryStatistics();
//        if (!countries.isEmpty() && countries.containsKey(country)) {
//            Query query = entityManager.createQuery("UPDATE CountryStatistics cs SET " +
//                    "cs.popularity = cs.popularity + 1 WHERE cs.country = ?1");
//            query.setParameter(1, country).executeUpdate();
//        }
//        else {
//            entityManager.persist(new CountryStatistics(country, 1));
//        }
//    }
//
//
//    public Map<String, Integer> getCountryStatistics(){
//        List<String> names = entityManager.createQuery("SELECT cs.country " +
//                "FROM CountryStatistics cs ORDER BY cs.popularity DESC", String.class)
//                .setMaxResults(10).getResultList();
//        List<Integer> values = entityManager.createQuery("SELECT cs.popularity " +
//                "FROM CountryStatistics cs ORDER BY cs.popularity DESC", Integer.class)
//                .setMaxResults(10).getResultList();
//        Map<String, Integer> results = new LinkedHashMap<>();
//        if (names != null && values != null) {
//            for (int i = 0; i < names.size(); i++) {
//                results.put(names.get(i), values.get(i));
//            }
//        }
//        return results;
//    }
//
//    public void clearTable() {
//        entityManager.createQuery("DELETE FROM CountryStatistics").executeUpdate();
//    }
