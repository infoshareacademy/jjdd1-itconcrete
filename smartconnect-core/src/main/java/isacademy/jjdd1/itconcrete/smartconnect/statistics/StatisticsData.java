package isacademy.jjdd1.itconcrete.smartconnect.statistics;



public class StatisticsData {


    private int lineNumber;

    private int countedTimes;


    public StatisticsData(int lineNumber, int countedTimes) {
        this.lineNumber = lineNumber;
        this.countedTimes = countedTimes;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getCountedTimes() {
        return countedTimes;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setCountedTimes(int countedTimes) {
        this.countedTimes = countedTimes;
    }

    @Override
    public String toString() {
        return "StatisticsData{" +
                "lineNumber=" + lineNumber +
                ", countedTimes=" + countedTimes +
                '}';
    }
}
