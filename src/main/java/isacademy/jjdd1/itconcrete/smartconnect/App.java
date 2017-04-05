package isacademy.jjdd1.itconcrete.smartconnect;


import isacademy.jjdd1.itconcrete.smartconnect.analyzer.ConnectionSeeker;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarEvent;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.CalendarParser;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.BusConnection;
import isacademy.jjdd1.itconcrete.smartconnect.schedule.ScheduleParser;
import isacademy.jjdd1.itconcrete.smartconnect.calendar.Event;


public class App
{
    public static void main( String[] args )





    {
        String pathToBusConnections = "C:/aaa/bbb"; // change this to proper value
        String pathToCalendarEvents = "C:/aaa/bbb"; // change this to proper value

        ScheduleParser scheduleParser = new ScheduleParser();
        //BusConnection busConnection[] = scheduleParser.parseDataFromPath(pathToBusConnections);

        CalendarParser calendarParser = new CalendarParser();
        CalendarEvent calendarEvent[] = calendarParser.parseDataFromPath(pathToCalendarEvents);

        ConnectionSeeker connectionSeeker = new ConnectionSeeker();

        /*for(int i=0; i<calendarEvent.length; i++) {
            CalendarEvent event = calendarEvent[i];
            int busNumber = connectionSeeker.seekConnection(event, busConnection);
        }*/
    }
}
