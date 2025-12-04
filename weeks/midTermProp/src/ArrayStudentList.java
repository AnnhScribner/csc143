import java.util.Arrays;

public class ArrayStudentList {
    private Student[] elementData; // list of values
    private int size;        // current number of elements in the list

    public static final int DEFAULT_CAPACITY = 100;

    public ArrayStudentList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStudentList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        elementData = new Student[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Student get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    public int indexOf(Student value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Student value) {
        return indexOf(value) >= 0;
    }

    public void add(Student value) {
        ensureCapacity(size + 1);
        elementData[size] = value;
        size++;
    }

    public void add(int index, Student value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        ensureCapacity(size + 1);
        for (int i = size; i >= index + 1; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[size - 1] = null;
        size--;
    }

    public void set(int index, Student value) {
        checkIndex(index);
        elementData[index] = value;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    public void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = elementData.length * 2 + 1;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }

    //----------------------------------------------------------------------
    //      EXAM METHODS START HERE
    //----------------------------------------------------------------------

    /**
     * Note:  difficulty level --> medium
     *
     * Generates an array that contains only enrolled students.
     * This array must be "right sized" meaning its length must be
     * exactly right hold just the enrolled students (with no
     * nulls at the end).
     *
     * Full-credit solutions will not create and use any other data
     * structures besides a single array to be returned, i.e., no other
     * ArrayList or String used as a data structure, etc.
     */
    public Student[] getEnrolledArray() {
        return null;
    }

    //----------------------------------------------------------------------
    //      EXAM METHODS END HERE
    //----------------------------------------------------------------------
}
