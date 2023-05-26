import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeKeyValueGenTest {
    private BinaryTreeKeyValueGen<Integer, String> tree;

    @BeforeEach
    public void setUp() {
        tree = new BinaryTreeKeyValueGen<>();
    }

    @Test
    public void testPutAndGet() {
        tree.put(1, "apple");
        assertEquals("apple", tree.getValByKey(1));
    }

    @Test
    public void testUpdateValue() {
        tree.put(1, "apple");
        tree.put(1, "banana");
        assertEquals("banana", tree.getValByKey(1));
    }

    @Test
    public void testKeyNotFound() {
        assertThrows(RuntimeException.class, () -> tree.getValByKey(1));
    }

    @Test
    public void testPrintAllKeyValPairs() {
        tree.put(1, "apple");
        tree.put(2, "banana");
        tree.put(3, "cherry");
        // This is a bit tricky to test because it involves console output.
        // You might want to consider returning a string from the method instead of printing directly to the console.
    }
}
