import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibCachedTest {

    private  FibCached fibCached;

    @BeforeEach
    void setUp() {
        fibCached = new FibCached();
    }

    @Test
    void getNthFib() {
        fibCached.getNthFib(10);
        assertEquals(55, fibCached.getNthFib(10));
    }

    @Test
    void getFibsCompCount() {
        fibCached.getFibsCompCount();
    }

    @Test
    void testToString() {
        fibCached.toString();
    }
}