import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomHashMapStringStringTest {
    private CustomHashMapStringString map;

    @BeforeEach
    void setUp() {
        map = new CustomHashMapStringString();
    }

    @Test
    void putValue() {
        map.putValue("Key1", "Value1");
        assertTrue(map.hasKey("Key1"));
        assertEquals("Value1", map.getValue("Key1"));
    }

    @Test
    void deleteByKey() {
        map.putValue("Key1", "Value1");
        map.deleteByKey("Key1");
        assertFalse(map.hasKey("Key1"));
    }

    @Test
    void deleteByKeyNotFound() {
        assertThrows(KeyNotFoundException.class, () -> map.deleteByKey("Key1"));
    }

    @Test
    void getValue() {
        map.putValue("Key1", "Value1");
        assertEquals("Value1", map.getValue("Key1"));
    }

    @Test
    void getValueNotFound() {
        assertThrows(KeyNotFoundException.class, () -> map.getValue("Key1"));
    }

    @Test
    void hasKey() {
        map.putValue("Key1", "Value1");
        assertTrue(map.hasKey("Key1"));
        assertFalse(map.hasKey("Key2"));
    }

    @Test
    void getAllKeys() {
        map.putValue("Key1", "Value1");
        map.putValue("Key2", "Value2");
        assertArrayEquals(new String[]{"Key1", "Key2"}, map.getAllKeys());
    }

    @Test
    void getAllKeyValPairs() {
        map.putValue("Key1", "Value1");
        map.putValue("Key2", "Value2");
        Pair<String, String>[] expected = new Pair[]{
                new Pair<>("Key1", "Value1"),
                new Pair<>("Key2", "Value2")
        };
        assertArrayEquals(expected, map.getAllKeyValPairs());
    }

    @Test
    void getSize() {
        map.putValue("Key1", "Value1");
        map.putValue("Key2", "Value2");
        assertEquals(2, map.getSize());
    }
}
