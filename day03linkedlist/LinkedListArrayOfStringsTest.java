import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListArrayOfStringsTest {

    private LinkedListArrayOfStrings list;

    @BeforeEach
    void setUp() {
        list = new LinkedListArrayOfStrings();
    }

    @Test
    void addAndGet() {
        list.add("Ant");
        assertEquals("Ant", list.get(0));
    }

    @Test
    void getSize() {
        list.add("Ant");
        list.add("Bat");
        assertEquals(2, list.getSize());
    }

    @Test
    void insertValueAtIndex() {
        list.add("Ant");
        list.add("Bat");
        list.insertValueAtIndex("Banana", 1);
        assertEquals("Banana", list.get(1));
    }

    @Test
    void replaceValueAtIndex() {
        list.add("Ant");
        list.add("Bat");
        list.replaceValueAtIndex("Banana", 1);
        assertEquals("Banana", list.get(1));
    }

    @Test
    void deleteByIndex() {
        list.add("Ant");
        list.add("Bat");
        list.deleteByIndex(1);
        assertEquals(1, list.getSize());
        assertEquals("Ant", list.get(0));
    }

    @Test
    void deleteByValue() {
        list.add("Ant");
        list.add("Bat");
        assertTrue(list.deleteByValue("Bat"));
        assertEquals(1, list.getSize());
        assertEquals("Ant", list.get(0));
    }

    @Test
    void deleteByValueNotFound() {
        list.add("Ant");
        list.add("Bat");
        assertFalse(list.deleteByValue("Cat"));
    }

    @Test
    void toArray() {
        list.add("Ant");
        list.add("Bat");
        String[] array = list.toArray();
        assertEquals(2, array.length);
        assertEquals("Ant", array[0]);
        assertEquals("Bat", array[1]);
    }
}
