package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class EventLogTest {

    EventLog el;
    Event event1;
    Event event2;
    Event event3;

    @BeforeEach
    public void loadEvents() {
        event1 = new Event("E1");
        event2 = new Event("E2");
        event3 = new Event("E3");
        el = EventLog.getInstance();
        el.logEvent(event1);
        el.logEvent(event2);
        el.logEvent(event3);
    }


    @Test
    public void testClear() {
        EventLog el = EventLog.getInstance();
        el.clear();
        Iterator<Event> itr = el.iterator();
        assertTrue(itr.hasNext());   // After log is cleared, the clear log event is added
        assertEquals("Event log cleared.", itr.next().getDescription());
        assertFalse(itr.hasNext());
    }


}
