package isacademy.jjdd1.itconcrete.smartconnect.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BusLineStatistics {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private int lineNumber;

    @Column
    private int occurences;

    public BusLineStatistics() {}

    public BusLineStatistics(int lineNumber, int occurences) {
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
