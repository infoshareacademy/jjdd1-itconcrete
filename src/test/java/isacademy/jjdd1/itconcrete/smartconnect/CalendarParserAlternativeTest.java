package isacademy.jjdd1.itconcrete.smartconnect;

import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarParserAlternative;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Journey;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

public class CalendarParserAlternativeTest {

    @Test
    public void should_read_calendar_events() throws IOException {
        CalendarParserAlternative calendar = new CalendarParserAlternative();
        List<Journey> eventList = calendar.getEventList();

        assertThat(eventList, hasSize(5));
    }

}