package isacademy.jjdd1.itconcrete.smartconnect.calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BusLineStatistics1 {

    @Id
    private int id;

    @Column
    private int lineNumber;

    @Column
    private int countedTimes;

    public BusLineStatistics1(int lineNumber, int countedTimes) {
        this.lineNumber = lineNumber;
        this.countedTimes = countedTimes;
    }

    public BusLineStatistics1() {
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
