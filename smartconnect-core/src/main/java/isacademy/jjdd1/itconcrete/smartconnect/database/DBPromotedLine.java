package isacademy.jjdd1.itconcrete.smartconnect.database;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table
public class DBPromotedLine {

    @Id
    @GeneratedValue
    private int number;

    @Id
    @Column
    private int busNumber;


    public DBPromotedLine() {
    }

    public DBPromotedLine(int busNumber) {
        this.busNumber = busNumber;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
