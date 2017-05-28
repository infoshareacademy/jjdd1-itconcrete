package isacademy.jjdd1.itconcrete.smartconnect.database;

import isacademy.jjdd1.itconcrete.smartconnect.result.CompleteDirectResult;
import isacademy.jjdd1.itconcrete.smartconnect.statistics.StatisticsData;
import isacademy.jjdd1.itconcrete.smartconnect.util.HibernateUtil;

import java.util.List;

public class AddToDbFromServlet {

    private static org.hibernate.Session session;

    public void addLineStatsToDatabase(List<StatisticsData> stats) {
        session = HibernateUtil.getSessionFactory().openSession();

        for (StatisticsData currentStatisticData : stats) {
            session.beginTransaction();
            session.save(new BusLineStatistics(currentStatisticData.getLineNumber(), currentStatisticData.getCountedTimes()));
            session.getTransaction().commit();
        }
    }

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