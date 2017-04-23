package isacademy.jjdd1.itconcrete.smartconnect.analyzer;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateAndTimeConverter {

    public static LocalTime timeFromKeyboardParser(String timeInString) {
        return LocalTime.parse(timeInString);
    }

    public static String prettyFormatTime(LocalTime time) {
        return time.truncatedTo(ChronoUnit.MINUTES).toString();
    }

}
