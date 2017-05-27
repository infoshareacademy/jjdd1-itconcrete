package isacademy.jjdd1.itconcrete.smartconnect.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BusStopStatistics {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String stopName;

    @Column
    private int occurences;

    public BusStopStatistics() {
    }

    public BusStopStatistics(String stopName, int occurences) {
        this.stopName = stopName;
        this.occurences = occurences;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public int getOccurences() {
        return occurences;
    }

    public void setOccurences(int occurences) {
        this.occurences = occurences;
    }
}
