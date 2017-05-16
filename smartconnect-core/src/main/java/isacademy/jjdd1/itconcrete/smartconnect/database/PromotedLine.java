package isacademy.jjdd1.itconcrete.smartconnect.database;

import isacademy.jjdd1.itconcrete.smartconnect.util.HibernateUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class PromotedLine {

    private static org.hibernate.Session session;


    @Id
    @GeneratedValue
    private long id;

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

    public void addPromotedLineToDatabase() {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(new PromotedLine(100));
        session.saveOrUpdate(new PromotedLine(101));
        session.getTransaction().commit();

    }

}
