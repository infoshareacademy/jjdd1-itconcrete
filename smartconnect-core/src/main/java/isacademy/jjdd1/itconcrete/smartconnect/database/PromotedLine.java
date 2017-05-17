package isacademy.jjdd1.itconcrete.smartconnect.database;

import isacademy.jjdd1.itconcrete.smartconnect.util.HibernateUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class PromotedLine {

    private static org.hibernate.Session session;


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

    public void addPromotedLineToDatabase() {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(new PromotedLine(10));
        session.saveOrUpdate(new PromotedLine(15));
        session.getTransaction().commit();
    }
}