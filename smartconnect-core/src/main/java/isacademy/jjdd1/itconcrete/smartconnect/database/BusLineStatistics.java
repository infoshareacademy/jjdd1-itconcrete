package isacademy.jjdd1.itconcrete.smartconnect.database;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BusLineStatistics {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private int lineNumber;

    @Column
    private int countedTimes;

    public BusLineStatistics(int lineNumber, int countedTimes) {
        this.lineNumber = lineNumber;
        this.countedTimes = countedTimes;
    }

    public BusLineStatistics() {
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getCountedTimes() {
        return countedTimes;
    }

    public void setCountedTimes(int countedTimes) {
        this.countedTimes = countedTimes;
    }
}
