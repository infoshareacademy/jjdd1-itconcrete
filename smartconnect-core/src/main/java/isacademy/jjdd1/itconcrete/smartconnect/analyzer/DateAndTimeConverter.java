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

    public static LocalTime timeFromKeyboardParser(String timeInString) {
        return LocalTime.parse(timeInString);
    }

    public static String prettyFormatTime(LocalTime time) {
        return time.truncatedTo(ChronoUnit.MINUTES).toString();
    }

}
