package deqo.isodate;

import org.junit.Test;

import static org.junit.Assert.*;

public class YearTest {
    Year monannee = new Year(2017);
    Year monanneebis = new Year(2012);


    @Test
    public void getYear() {
        assertEquals(2017,monannee.getYear(),0);
    }

    @Test
    public void isLeapYear() {
        assertEquals(false,monannee.isLeapYear());
        assertEquals(true,monanneebis.isLeapYear());
    }
}