package deqo.isodate;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsoDateTest {
    IsoDate d = new IsoDate(1995,06,26);
    @Test
    public void toString2() {
        assertEquals("1995-6-26",d.toString2());

    }

    @Test
    public void toIsoDays() {
        assertEquals("1995-177",d.toIsoDays().toString1());
    }
}