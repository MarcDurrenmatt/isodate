package deqo.isodate;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsoDaysTest {
    IsoDays iso = new IsoDays(1995,26);
    @Test
    public void toString1() {
        assertEquals("1995-026",iso.toString1());

    }
}