package isacademy.jjdd1.itconcrete.smartconnect.analyzer;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateAndTimeConverter {

    public static LocalTime timeParser(String timeInString) {

        DateTimeFormatter parser = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'");
        LocalDateTime dateTime = LocalDateTime.from(parser.parse(timeInString));
        LocalTime localTime = LocalTime.of(dateTime.getHour(), dateTime.getMinute(), 0, 0);
        return localTime;
    }

//    DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//    LocalDateTime dateTime = LocalDateTime.from(f.parse("2012-01-10 23:13:26"));

    public static LocalTime timeFromKeyboardParser(String timeInString) {

        DateTimeFormatter parser = DateTimeFormatter.ofPattern("HH:mm");
        //DateTimeFormatter parser = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'");
        LocalDateTime dateTime = LocalDateTime.from(parser.parse(timeInString));
        LocalTime localTime = LocalTime.of(dateTime.getHour(), dateTime.getMinute(), 0, 0);
        return localTime;
    }

    public static String prettyFormatTime(LocalTime time) {
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return time.truncatedTo(ChronoUnit.MINUTES).toString();
    }

}
