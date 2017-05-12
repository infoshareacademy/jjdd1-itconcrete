package isacademy.jjdd1.itconcrete.smartconnect.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HomeBusStop {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    public HomeBusStop(String name) {
        this.name = name;
    }

    public HomeBusStop() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
