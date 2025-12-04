/**
 * @author Anna Scribner
 * @version May 4, 2025
 *
 * CircularLinkedListTest is a unit test class that validates the functionality of the CircularLinkedList class.
 * Various test methods ensure the core operations of a circular linked list, such as construction, adding,
 * retrieving, removing, and iterating, are implemented correctly.
 *
 * The test cases also account for boundary conditions, exceptions, and edge cases to ensure robustness.
 */

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class CircularLinkedListTest {

    /**
     * Tests the constructors of the CircularLinkedList class.
     *
     * Assertions are used to validate the correctness of list size, expected exceptions,
     * and proper initialization of the list with provided values.
     */
    @Test
    public void testConstructors() {
        CircularLinkedList<Integer> emptyConstructor = new CircularLinkedList<>();
        assertEquals(0, emptyConstructor.size());
        assertThrows(IllegalArgumentException.class, () -> {
            emptyConstructor.get(0);
        });

        CircularLinkedList<String> constructor = new CircularLinkedList<>("Orange", "Banana", "Dragonfruit", "Açaí");
        assertEquals(4, constructor.size());
    }

    /**
     * Tests the size method of the CircularLinkedList class.
     */
    @Test
    public void size() {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        assertEquals(0, list.size());

        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        list.add("Kiwi");

        assertEquals(4, list.size());

        CircularLinkedList<Integer> listInt = new CircularLinkedList<>();
        listInt.add(2);
        listInt.add(0);
        assertEquals(2, listInt.size());

    }

    /**
     * Tests the functionality of the add and get methods in the CircularLinkedList class.
     */
    @Test
    void addAndGet() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        list.add(2);
        list.add(15);
        list.add(10);
        list.add(1);
        list.add(0);

        assertThrows(IllegalArgumentException.class, () -> {
            list.get(-1);
        });
        assertEquals(2, list.get(0));
        assertEquals(15, list.get(1));
        assertEquals(10, list.get(2));
        assertEquals(1, list.get(3));
        assertEquals(0, list.get(4));
        assertThrows(IllegalArgumentException.class, () -> {
            list.get(5);
        });

    }

    /**
     * Tests the remove(int position) method of the CircularLinkedList class.
     *
     * Assertions ensure:
     * - IllegalArgumentExceptions are correctly thrown for invalid indices.
     * - The size of the list is updated correctly after each removal.
     * - The removed elements are no longer present in the list.
     */
    @Test
    public void testRemovePosition() {
        CircularLinkedList<String> list1 = new CircularLinkedList<>();
        assertThrows(IllegalArgumentException.class, () -> {
            list1.remove(0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            list1.remove(-1);
        });
        list1.add("Banana");
        list1.remove(0);
        assertEquals(0, list1.size());
        assertFalse(list1.contains("Banana"));

        list1.add("Apple");
        list1.add("Kiwi");
        list1.add("Orange");
        list1.add("Pineapple");

        list1.remove(0);
        assertEquals(3, list1.size());
        assertFalse(list1.contains("Apple"));

        list1.remove(2);
        assertEquals(2, list1.size());
        assertFalse(list1.contains("Pineapple"));

        CircularLinkedList<Integer> list2 = new CircularLinkedList<>();
        list2.add(2);
        list2.add(0);
        list2.add(-10);
        list2.add(98);
        list2.add(-5);

        list2.remove(4);
        list2.remove(3);
        list2.remove(2);
        list2.remove(1);
        list2.remove(0);

        assertEquals(0, list2.size());
        assertFalse(list2.contains(2));
        assertFalse(list2.contains(0));
        assertFalse(list2.contains(-10));
        assertFalse(list2.contains(98));
        assertFalse(list2.contains(-5));

        CircularLinkedList<Integer> l = new CircularLinkedList<>(2, 4, 19, 5);
        assertThrows(IllegalArgumentException.class, () -> {
            l.remove(4);
        });
        CircularLinkedList<Integer> li = new CircularLinkedList<>(2, 4, 19, 20);
        li.remove(2);
        assertFalse(li.contains(19));
        assertEquals(3, li.size());
    }

    /**
     * Tests the remove(E value) method of the CircularLinkedList class.
     *
     * Assertions ensure the correctness of list size, presence or absence of elements, and proper behavior of the remove method.
     */
    @Test
    public void testRemoveValue() {
        CircularLinkedList<Integer> list1 = new CircularLinkedList<>();
        assertFalse(list1.remove((Integer) 2));
        assertEquals(0, list1.size());

        list1.add(2);
        assertFalse(list1.remove((Integer) 1));
        assert (list1.remove((Integer) 2));
        assertEquals(0, list1.size());
        assertFalse(list1.contains(2));

        CircularLinkedList<Integer> list2 = new CircularLinkedList<>();
        list2.add(2);
        list2.add(1);
        list2.add(-2);
        list2.add(0);
        assert (list2.remove((Integer) 2));
        assertFalse(list2.contains(2));
        assert (list2.remove((Integer) 1));
        assertFalse(list2.contains(1));
        assert (list2.remove((Integer) (-2)));
        assertFalse(list2.contains(-2));
        assert (list2.remove((Integer) 0));
        assertFalse(list2.contains(0));

        list2 = new CircularLinkedList<>();
        list2.add(2);
        list2.add(1);
        list2.add(-2);
        list2.add(0);
        assert (list2.remove((Integer) 0));
        assertFalse(list2.contains(0));
        assert (list2.remove((Integer) (-2)));
        assertFalse(list2.contains(-2));
        assert (list2.remove((Integer) 1));
        assertFalse(list2.contains(1));
        assert (list2.remove((Integer) 2));
        assertFalse(list2.contains(2));

        CircularLinkedList<String> l = new CircularLinkedList<>("Hi", "Salut", "Oi", "Hola");
        assert (l.remove("Salut"));
    }

    /**
     * Tests the contains method of the CircularLinkedList class.
     *
     * Assertions ensure that the contains method behaves as expected for a variety of scenarios.
     */
    @Test
    public void testContains() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(2);
        list.add(0);
        list.add(-10);

        assert (list.contains(2));
        assert (list.contains(0));
        assert (list.contains(-10));
        assertFalse(list.contains(123));

        CircularLinkedList<String> list2 = new CircularLinkedList<>();
        assertFalse(list2.contains("Strawberry"));
        list2.add("Strawberry");
        assert (list2.contains("Strawberry"));
    }

    /**
     * Tests the iterator functionality of the CircularLinkedList class.
     *
     * Assertions confirm the correct sequence of returned elements, behavior of the
     * hasNext and next methods, and functionality of the circular iteration.
     */
    @Test
    public void testIterator() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        Iterator<Integer> iterator = list.iterator();
        assertFalse(iterator.hasNext());
        assertNull(iterator.next());

        list.add(2);
        list.add(0);
        list.add(-10);
        list.add(5);

        iterator = list.iterator();
        assertEquals(2, iterator.next());
        assertEquals(0, iterator.next());
        assertEquals(-10, iterator.next());
        assertEquals(5, iterator.next());
        assertEquals(2, iterator.next());
    }
}