/**
 *
 * @author Anna Scribner
 * @version April 27, 2025
 */

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;


/**
 * A class that wraps ArrayList and maintains sorted order with additional methods
 * @param <E> type of the elements
 */
public class SortedArrayList<E extends Comparable<E>> implements SortedArrayListInterface<E> {

    /**
     * data in this list
     */
    private ArrayList<E> elementData;

    /**
     * Default capacity for the ArrayList
     */
    public static final int DEFAULT_CAPACITY = 100;

    /**
     * SortedArrayList constructor with no parameters
     * post: constructs an empty list of default capacity
     */
    public SortedArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * SortedArrayList constructor with one parameter
     * if capacity >= 0 (throws IllegalArgumentException if not)
     * @param capacity constructs an empty list with the given capacity
     */
    public SortedArrayList(int capacity) {
        elementData = new ArrayList<E>(capacity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return elementData.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return elementData.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        elementData.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(E value) {
        return elementData.contains(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int indexOf(E value) {
        int index = binarySearch(value);

        while (index > 0 && this.get(index).equals(this.get(index - 1))) {
            index = index - 1;
        }
        return index;
    }

    /**
     * Method helper for finding the index in the ArrayList, given the target value.
     *
     * @param target to be found
     * @return the index of the target value or negative index - 1 for where the
     * value could be
     */
    private int binarySearch(E target) {
        int min = 0;
        int max = size() - 1;

        int mid = -1;
        while (min <= max) {
            mid = (max + min) / 2;
            if (elementData.get(mid).equals(target)) {
                return mid;
            } else if (elementData.get(mid).compareTo(target) < 0) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
            mid = (max + min) / 2;
        }

        return -min - 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E get(int index) {
        return elementData.get(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E[] get(E value, E[] template) {
        int index = indexOf(value);
        ArrayList<E> save = new ArrayList<E>();

        while (index > 0 && this.get(index).equals(value)) {
            save.add(this.get(index));
            index++;
        }
        return save.toArray(Arrays.copyOf(template, save.size()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(E value) {
        int index = indexOf(value);
        if (index < 0) {
            index = Math.abs(index) - 1;
        }
        elementData.add(index, value);
    }

    /**
     * A method that adds all the elements from a given collection
     * @param items from the given collection
     *  pre: items is not null
     */
    public void addAll(Collection<E> items) {
        if (items == null) {
            throw new IllegalArgumentException("This collection cannot be null.");
        }
        for (E item : items) {
            this.add(item);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(int index) {
        elementData.remove(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return elementData.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E[] toArray(E[] array) {
        return elementData.toArray(array);
    }

}
