package com.isacademy.jjdd1.itconcrete.statistics;


public class HomeBusStopStatsGetter {

    //
//
//    public Map<String, Integer> getCountryStatistics(){
//        List<String> names = entityManager.createQuery("SELECT cs.country " +
//                "FROM CountryStatistics cs ORDER BY cs.popularity DESC", String.class)
//                .setMaxResults(10).getResultList();
//        List<Integer> values = entityManager.createQuery("SELECT cs.popularity " +
//                "FROM CountryStatistics cs ORDER BY cs.popularity DESC", Integer.class)
//                .setMaxResults(10).getResultList();
//        Map<String, Integer> results = new LinkedHashMap<>();
//        if (names != null && values != null) {
//            for (int i = 0; i < names.size(); i++) {
//                results.put(names.get(i), values.get(i));
//            }
//        }
//        return results;
//    }
//
//    public void clearTable() {
//        entityManager.createQuery("DELETE FROM CountryStatistics").executeUpdate();
//    }

}
