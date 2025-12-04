/**
 *
 * @author Anna Scribner
 * @version April 27, 2025
 * <p>
 * A class that tests the SortedArrayList class
 */

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SortedArrayListTest {
    private SortedArrayList<Integer> arrInt;
    private SortedArrayList<String> arrString;

    @Test
    public void getTwoParameters() {
        Integer[] arr = new Integer[0];
        Integer[] newArr = arrInt.get((Integer) 5, arr);

        assertEquals(1, newArr.length);

        String[] str = new String[0];
        String[] newStr = arrString.get("Banana", str);

        assertEquals(1, newStr.length);

        str = new String[0];
        newStr = arrString.get("Dragon Fruit", str);
        assertEquals(0, newStr.length);
    }

    @Test
    public void size() {
    }

    @Test
    public void isEmpty() {
        assert (!arrInt.isEmpty());
        arrInt.clear();
        assert (arrInt.isEmpty());
    }

    @Test
    public void clear() {
        arrInt.clear();
        assertEquals(0, arrInt.size());
    }

    @Test
    public void contains() {
    }

    @Test
    public void indexOf() {
        assertEquals(3, arrInt.indexOf(10));
        assertEquals(0, arrInt.indexOf(0));
        assertEquals(-2, arrInt.indexOf(1));

        assertEquals(0, arrString.indexOf("Avocado"));
        assertEquals(3, arrString.indexOf("Pineapple"));

        SortedArrayList<String> str = new SortedArrayList<String>();
        str.add("Anna");
        str.add("Anna");
        str.add("Anna");
        str.add("Anna");

        assertEquals(0, str.indexOf("Anna"));

    }

    @Test
    public void addAll() {
        Integer[] elements = new Integer[]{3, 4, 7};
        SortedArrayList<Integer> t = new SortedArrayList<>();

        t.addAll(Arrays.asList(elements));
        assertEquals(elements.length, t.size());

        for (int num : elements) {
            assert (t.contains(num));
        }

        Arrays.sort(elements);

        for (int i = 0; i < t.size(); i++) {
            assertEquals(elements[i], t.get(i));
        }

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            arrInt.addAll(null);
        });
        assertEquals("This collection cannot be null.", exception.getMessage());

    }

    @Test
    public void addAndGet() {
        SortedArrayList<Integer> arr = new SortedArrayList<Integer>();
        arr.add(2);
        arr.add(1);
        arr.add(5);
        assertEquals((Integer) 1, arr.get(0));
        assertEquals((Integer) 2, arr.get(1));
        assertEquals((Integer) 5, arr.get(2));

        SortedArrayList<String> arr1 = new SortedArrayList<String>();
        arr1.add("Banana");
        arr1.add("Orange");
        arr1.add("Anna");

        assertEquals("Anna", arr1.get(0));
        assertEquals("Banana", arr1.get(1));
        assertEquals("Orange", arr1.get(2));
    }

    @Test
    public void remove() {
        arrInt.remove(2);
        assertEquals(3, arrInt.size());

        arrString.remove(2);
        assertEquals(3, arrString.size());
    }

    @Test
    public void iterator() {
        int i = 0;

        Iterator<Integer> iterator = arrInt.iterator();

        while (iterator.hasNext()) {
            int num = (int)iterator.next();

            assertEquals(arrInt.get(i), (Integer) num);
            i++;
        }

    }

    @Test
    public void toArray() {
        Integer[] arr = new Integer[5];
        arr = arrInt.toArray(arr);

        int i = 0;
        Iterator<Integer> iterator = arrInt.iterator();

        while (iterator.hasNext()) {
            int num = (int)iterator.next();
            assertEquals((Integer) num, arr[i]);
            i++;
        }

        arr = new Integer[2];
        arr = arrInt.toArray(arr);

        i = 0;
        iterator = arrInt.iterator();

        while (iterator.hasNext()) {
            int num = (int)iterator.next();
            assertEquals((Integer) num, arr[i]);
            i++;
        }

    }


    @Before
    public void setUp() throws Exception {
        arrInt = new SortedArrayList<>();
        arrInt.add(5);
        arrInt.add(2);
        arrInt.add(10);
        arrInt.add(0);

        arrString = new SortedArrayList<>();
        arrString.add("Banana");
        arrString.add("Pineapple");
        arrString.add("Avocado");
        arrString.add("Orange");
    }


}