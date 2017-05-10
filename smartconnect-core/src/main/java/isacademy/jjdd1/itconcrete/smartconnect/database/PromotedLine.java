package isacademy.jjdd1.itconcrete.smartconnect.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PromotedLine {

    @Id
    @Column
    private int number;

    public PromotedLine() {
    }

    public PromotedLine(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
