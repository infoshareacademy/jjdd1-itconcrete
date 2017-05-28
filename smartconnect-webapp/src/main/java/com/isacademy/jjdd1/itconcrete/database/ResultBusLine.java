package com.isacademy.jjdd1.itconcrete.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by agata on 5/28/17.
 */
@Entity
public class ResultBusLine {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private int lineNumber;

    @Column
    private int occurences;

    public ResultBusLine() {
    }

    public ResultBusLine(int lineNumber, int occurences) {
        this.lineNumber = lineNumber;
        this.occurences = occurences;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getOccurences() {
        return occurences;
    }

    public void setOccurences(int occurences) {
        this.occurences = occurences;
    }
}
