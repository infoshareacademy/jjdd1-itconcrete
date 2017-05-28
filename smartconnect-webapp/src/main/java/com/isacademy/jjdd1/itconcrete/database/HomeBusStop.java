package com.isacademy.jjdd1.itconcrete.database;

import javax.persistence.*;


@Entity
public class HomeBusStop {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String homeBusStopName;

    @Column
    private int occurences;

    public HomeBusStop() {
    }

    public HomeBusStop(String homeBusStopName, int occurences) {
        this.homeBusStopName = homeBusStopName;
        this.occurences = occurences;
    }

    public String getHomeBusStopName() {
        return homeBusStopName;
    }

    public void setHomeBusStopName(String homeBusStopName) {
        this.homeBusStopName = homeBusStopName;
    }

    public int getOccurences() {
        return occurences;
    }

    public void setOccurences(int occurences) {
        this.occurences = occurences;
    }
}
