package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class EventTest {

    private Event e;
    private Date d;

    //NOTE: these tests might fail if time at which line (2) below is executed
    //is different from time that line (1) is executed.  Lines (1) and (2) must
    //run in same millisecond for this test to make sense and pass.

    @BeforeEach
    public void runBefore() {
        e = new Event("E1");   // (1)
        d = Calendar.getInstance().getTime();   // (2)
    }


    @Test
    public void testEvent() {
        assertEquals("E1", e.getDescription());
        assertEquals(d, e.getDate());
    }


    @Test
    public void testEqual() {
        Event e1 = new Event("E1");
        Event e2 = new Event("E1");
        Event e3 = new Event("E3");
        Event e4 = null;
        EventLog eventLog1 = new EventLog();

        assertTrue(e1.getDate().equals(e2.getDate()));
        assertTrue(e1.equals(e2));
        assertFalse(e1.equals(e3));
        assertFalse(e1.equals(e4));
        assertFalse(e1.equals(eventLog1));
    }

    @Test
    public void testHashCode() {
        Event e1 = new Event("E1");
        Event e2 = new Event("E1");

        assertEquals(e1.hashCode(), e2.hashCode());

    }


    @Test
    public void testToString() {
        assertEquals(d.toString() + "\n" + "E1", e.toString());
    }


}
