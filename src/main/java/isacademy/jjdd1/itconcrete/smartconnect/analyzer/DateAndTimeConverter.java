package isacademy.jjdd1.itconcrete.smartconnect.analyzer;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateAndTimeConverter {

    public static LocalTime timeParser(String timeInString) {

        DateTimeFormatter parser = DateTimeFormat.forPattern("yyyyMMdd'T'HHmmss'Z'");
        DateTime dateTime = parser.parseDateTime(timeInString);
        LocalTime localTime = new LocalTime(dateTime.getHourOfDay(), dateTime.getMinuteOfHour());
        return localTime;
    }


    public static String prettyFormatTime(LocalTime time) {

        DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
        return formatter.print(time);
    }

}
