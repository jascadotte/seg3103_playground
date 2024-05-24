

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
// import org.junit.runners.Parameterized.Parameters;
import static org.junit.jupiter.api.Assertions.*;


import java.util.*;

@RunWith(Parameterized.class)
public class DateNextDateOkTest {
    
    private Date start;
    private Date end;
    
    public DateNextDateOkTest(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    @Parameterized.Parameters(name="{index}: testDate_NextDate({0})={1}")
    public static List<Date []> data() {
        
        return Arrays.asList(new Date[][] {
                {new Date(1700, 6, 20), new Date(1700, 6, 21)},
                {new Date(2005, 4, 15), new Date(2005, 4, 16)},
                {new Date(1901, 7, 20), new Date(1901, 7, 21)},
                {new Date(3456, 3, 27), new Date(3456, 3, 28)},
                {new Date(1500, 2, 17), new Date(1500, 2, 18)},
                {new Date(1700, 6, 29), new Date(1700, 6, 30)},
                {new Date(1800, 11, 29), new Date(1800, 11, 30)},
                {new Date(3453, 1, 29), new Date(3453, 1, 30)},
                {new Date(444, 2, 29), new Date(444, 3, 1)},
                {new Date(2005, 4, 30), new Date(2005, 5, 1)},
                {new Date(3453, 1, 30), new Date(3453, 1, 31)},
                {new Date(3456, 3, 30), new Date(3456, 3, 31)},
                {new Date(1901, 7, 31), new Date(1901, 8, 1)},
                {new Date(3453, 1, 31), new Date(3453, 2, 1)},
                {new Date(3456, 12, 31), new Date(3457, 1, 1)}
        });
    }

    @Test
    public void testNextDateCorrect() {
        assertEquals(start.nextDate(), end);
    }
}