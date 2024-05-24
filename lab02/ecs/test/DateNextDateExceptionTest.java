import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
// import org.junit.runners.Parameterized.Parameters;
import static org.junit.jupiter.api.Assertions.*;


import java.util.*;

@RunWith(Parameterized.class)
public class DateNextDateExceptionTest {
    
    private int year;
    private int month;
    private int day;
    
    public DateNextDateExceptionTest(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Parameterized.Parameters
    public static List<Integer []> data() {
        List<Integer []> inputAndOutputs = new ArrayList<Integer[]> ();
        inputAndOutputs.add(new Integer[] {1500, 2, 31});
        inputAndOutputs.add(new Integer[] {1500, 2, 29});
        inputAndOutputs.add(new Integer[] {-1, 10, 20});
        inputAndOutputs.add(new Integer[] {1458, 15, 12});
        inputAndOutputs.add(new Integer[] {1975, 6, -50});
        return inputAndOutputs;
    }

    @Test
    public void testNextDateCorrect() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> {
            Date d = new Date(this.year, this.month, this.day).nextDate();
        });
    }
}