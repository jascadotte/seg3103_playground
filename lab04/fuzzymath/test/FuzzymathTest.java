import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FuzzymathTest {

    @Test
    void sum() {
        assertEquals(11, Fuzzymath.sum(4, 6));
    }

}