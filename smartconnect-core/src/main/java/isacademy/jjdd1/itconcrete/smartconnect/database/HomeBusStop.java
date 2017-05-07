package isacademy.jjdd1.itconcrete.smartconnect.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class HomeBusStop {

    @Id
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
