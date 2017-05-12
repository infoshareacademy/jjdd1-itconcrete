package isacademy.jjdd1.itconcrete.smartconnect.database;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BusStop {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    public BusStop(String name) {
        this.name = name;
    }

    public BusStop() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
