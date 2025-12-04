public class ArrayIntList {
    private int[] elementData;
    private int size;

    // construct a new empty list of capacity 10
    public ArrayIntList() { ... }

    // add to end of list
    public void add(int value) { ... }

    // throw IndexOutOfBoundsException if index not between min/max inclusive
    private void checkIndex(int index, int min, int max) { ... }

    // ensure that elementData.length >= capacity
    private void ensureCapacity(int capacity) { ... }
    ...

    // your code goes here
}