// Class ArrayIntList can beused to store a list of integers.

public class ArrayIntList {
    public static final int DEFAULT_CAPACITY = 100;
    private int[] elementData; // list of integers
    private int size;                // number of elements in the list


    // pre : capacity >= 0 (throws IllegalArgumentException if not)
    // post : constructs an empty list with the given capacity
    public ArrayIntList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        elementData = new int[capacity];
        size = 0;
    }

    // post : constructs an empty list of default capacity
    public ArrayIntList() {
        this(DEFAULT_CAPACITY);
    }

    // post : returns the current number of elements in the list
    public int getSize() {
        return size;
    }

    // pre : 0 <= index < size()
    // post : returns the integer at the given index in the list
    public int getElement(int index) {
        return elementData[index];
    }

    // pre : size() < capacity (throws IllegalStateException if not)
    // post : appends the given value to the end og the list
    public void add(int value) {
        checkCapacity(size + 1);
        elementData[size] = value; // appending the value in the index size
        size++; // increase size to be able to add more future values
        // if I don't increase the size, this method will keep appending the value to the same index
    }

    // pre : size() < capacity && 0 <= index <= size() (throws IllegalStateException if not)
    // post : inserts the given value at the given index, shifting
    // subsequent values right
    public void add(int index, int value) {
        checkCapacity(size + 1);
        for (int i = size + 1; i <= index + 1; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }

    public void addAll(ArrayIntList other) {
        checkCapacity(size + other.size);
        for (int i = 0; i < other.size; i++) {
            add(other.elementData[i]);
        }
    }

    // post : returns the position of the first occurrence of the
    // given value (-1 if not found)
    public int indexOf(int target) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // pre : <= index  < size()
    // post : removes value at the given index, shifting
    // subsequent value left
    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }

    // post : checks that the underlying array has the given capacity
    // throwing an IllegalStateException if it does not
    private void checkCapacity(int capacity) {
        if (capacity > elementData.length) {
            throw new IllegalStateException("Exceeds list capacity.");
        }
    }

    // post : throws an IllegalOutOfBoundsException if the given index is
    // not a legal index of the current list
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }

    public boolean contains(int value) {
        return indexOf(value) >= 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void set(int index, int value) {
        checkIndex(index);
        elementData[index] = value;
    }

    public void clear() {
        size = 0;
    }

    // post : returns comma-separated, bracketed version of list
    @Override
    public String toString() {
        String result = "";
        if (size == 0) {
            result += "[]";
        } else {
            result = "[" + elementData[0];
            for (int i = 1; i < size; i++) {
                result += ", " + elementData[i];
            }
            result += "]";
        }

        return result;
    }
}
