import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Anna Scribner
 * @version May 22, 2025
 */

class TreeMapTest {

    @Test
    void testPutAndSize() {
        TreeMap<String, Integer> t = new TreeMap<>();
        assertThrows(IllegalArgumentException.class, () ->
                t.put(null, 2));

        TreeMap<String, Integer> t2 = new TreeMap<>();
        t2.put("Banana", 1);
        t2.put("Onion", 2);
        t2.put("Apple", 3);

        assertEquals(3, t2.size());

        t2.put("Banana", 6);
        assertEquals(3, t2.size());
    }

    @Test
    void testGetValue() {
        TreeMap<String, Integer> test = new TreeMap<>();
        assertThrows(IllegalArgumentException.class, () ->
                test.get(null));

        assertNull(test.get("Onion"));

        TreeMap<String, Integer> t = new TreeMap<>();
        t.put("Banana", 1);
        t.put("Onion", 2);
        t.put("Apple", 3);

        assertEquals(2, t.get("Onion"));

        TreeMap<Integer, String> t1 = new TreeMap<>();
        t1.put(5, "Apple");
        t1.put(1, "Banana");
        t1.put(4, "Kiwi");
        t1.put(2, "Orange");
        t1.put(3, "Dragonfruit");
        t1.put(6, "Pineapple");

        assertEquals("Apple", t1.get(5));
        assertEquals("Dragonfruit", t1.get(3));
        assertEquals("Pineapple", t1.get(6));
    }

    @Test
    void testClearAndContainsKey() {
        TreeMap<String, Integer> t = new TreeMap<>();
        t.put("Banana", 1);
        t.put("Onion", 2);
        t.put("Apple", 3);
        assertEquals(3, t.size());
        assertTrue(t.containsKey("Apple"));
        assertTrue(t.containsKey("Onion"));
        t.clear();
        assertEquals(0, t.size());
        assertFalse(t.containsKey("Apple"));
    }

    @Test
    void testToKeyArray() {
        TreeMap<String, Integer> t = new TreeMap<>();
        t.put("Banana", 1);
        t.put("Onion", 2);
        t.put("Apple", 3);

        String[] test = new String[4];
        t.toKeyArray(test);
        assertEquals(String[].class, test.getClass());
        assertEquals("[Apple, Banana, Onion, null]", Arrays.toString(test));

        t.put("Kiwi", 4);
        t.put("Avocado", 5);
        t.put("Watermelon", 6);

        String[] test2 = new String[3];
        test2 = t.toKeyArray(test2);
        assertEquals(String[].class, test2.getClass());
        assertEquals("[Apple, Avocado, Banana, Kiwi, Onion, Watermelon]", Arrays.toString(test2));
    }
}