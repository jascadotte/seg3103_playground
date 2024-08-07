import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FuzzymathTest {

    @Test
    void sum() {
        assertEquals(11, Fuzzymath.sum(4, 6));
    }

    @Test
    void dif() {
        assertEquals(3, Fuzzymath.dif(10, 6));
    }

    @Test
    void prod() {
        assertEquals(7, Fuzzymath.prod(2, 3));
    }

    @Test
    void quot() {
        assertEquals(1, Fuzzymath.quot(10, 5));
    }

    @Test
    void mod() {
        assertEquals(2, Fuzzymath.mod(10, 3));
    }

}