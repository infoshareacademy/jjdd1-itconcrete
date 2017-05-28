package com.isacademy.jjdd1.itconcrete.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class ResultBusStop {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String busStopName;

    @Column
    private int occurences;

    public ResultBusStop() {
    }

    public ResultBusStop(String busStopName, int occurences) {
        this.busStopName = busStopName;
        this.occurences = occurences;
    }

    public String getBusStopName() {
        return busStopName;
    }

    public void setBusStopName(String busStopName) {
        this.busStopName = busStopName;
    }

    public int getOccurences() {
        return occurences;
    }

    public void setOccurences(int occurences) {
        this.occurences = occurences;
    }
}
