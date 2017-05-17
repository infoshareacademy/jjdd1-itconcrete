package isacademy.jjdd1.itconcrete.smartconnect.database;

import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteDirectResult;
import isacademy.jjdd1.itconcrete.smartconnect.util.HibernateUtil;

import java.util.List;

/**
 * Created by lukaszstyk on 17.05.17.
 */
public class AddToDbFromServlet {

    private static org.hibernate.Session session;

    public void addStopsToDatabase(List<CompleteDirectResult> completeDirectResultList) {
        session = HibernateUtil.getSessionFactory().openSession();

        for (int i = 0; i < completeDirectResultList.size(); i++) {
            session.beginTransaction();
            session.save(new BusStop(completeDirectResultList.get(i).getStartBusStop()));
            session.getTransaction().commit();
        }
        session.beginTransaction();
        session.save(new BusStop(completeDirectResultList.get(completeDirectResultList.size() - 1).getEndBusStop()));
        session.getTransaction().commit();
    }
}
