package com.isacademy.jjdd1.itconcrete.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;


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
        try{
            Query query = entityManager.createQuery("SELECT  hbs.occurences FROM HomeBusStop hbs  " +
                    " WHERE hbs.homeBusStopName = ?1");
            int occurences = (int) query.setParameter(1, homeBusStopName).getSingleResult();
            Optional<Integer> integerOptional = Optional.ofNullable(occurences);
            if (integerOptional.isPresent()){
                return true;
            } else {
                return false;
            }
        } catch (NoResultException e){}
        return false;
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
        try {
            return entityManager.createQuery("SELECT s.homeBusStopName from HomeBusStop s").getResultList();
        } catch (NoResultException e) {}

        List<String> list = new ArrayList<>();
        return list;
    }


    public int getValuForHomeBusStop(String homeBusStopName){
        try {
            Query query = entityManager.createQuery("SELECT  hbs.occurences FROM HomeBusStop hbs  " +
                    " WHERE hbs.homeBusStopName = ?1");
            int occurences = (int) query.setParameter(1, homeBusStopName).getSingleResult();
            return occurences;
        } catch (NoResultException e) {}
        return 0;
    }
}


