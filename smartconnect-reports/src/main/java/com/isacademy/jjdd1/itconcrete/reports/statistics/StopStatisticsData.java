package com.isacademy.jjdd1.itconcrete.reports.statistics;

public class StopStatisticsData {

    private String busStopName;
    private int countedTimes;

    public StopStatisticsData(String busStopName, int countedTimes) {
        this.busStopName = busStopName;
        this.countedTimes = countedTimes;
    }

    public String getBusStopName() {
        return busStopName;
    }

    public int getCountedTimes() {
        return countedTimes;
    }

    public void setBusStopName(String busStopName) {
        this.busStopName = busStopName;
    }

    public void setCountedTimes(int countedTimes) {
        this.countedTimes = countedTimes;
    }

    @Override
    public String toString() {
        return "StatisticsData{" +
                "busStopName=" + busStopName +
                ", countedTimes=" + countedTimes +
                '}';
    }
}
