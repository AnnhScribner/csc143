import java.util.Arrays;

public class ArrayIntList implements ArrayIntListInterface {
    // CONSTANT S//
    private static final int DEFAULT_CAPACITY = 100;
    private static final int EXPANSION_MULTIPLIER = 2;

    // INSTANCE DATA //
    private int[] elementData;
    private int size;

    // CONSTRUCTORS //
    public ArrayIntList() {

        this(DEFAULT_CAPACITY);
    }

    public ArrayIntList(int initialCapacity) {
        elementData = new int[initialCapacity]; // array full of zeros
        size = 0;
    }

    // PUBLIC METHODS //
    public boolean add(int element) {
        ensureCapacity(size + 1); // size plus one element that I want to add
        elementData[size++] = element;
        //size++; -> it will increment AFTER we use the expression
        // ++size; -> it will increment BEFORE using the expression
        return true;
    }

    public boolean addAll(ArrayIntList other) {
        // TODO
        ensureCapacity(other.size);
        return true;
    }

    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Invalid index; must be 0 to size");
        }
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = element;
        size++;
    }

    public int remove(int index) {
        checkIndex(index);
        int returnElement = elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[index + 1];
        }
        size--;
        return returnElement;
    }

    public int size() {
        return size;
    }

    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int element) {
        return indexOf(element) >= 0;
    }

    public void clear() {
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    public int set(int index, int element) {
        checkIndex(index);
        int returnElement = elementData[index];
        elementData[index] = element;
        return returnElement;
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + elementData[0];
            for (int i = 1; i < size; i++) {
                result += ", " + elementData[i];
            }
            result += "]";
            return result;
        }
    }

    public void stutter(){
            for(int  i = size; i > 0; i -= 2){
                size++;
                    elementData[i] = elementData[i - 1];
            }
            for(int i = size; i > 0; i--){
                elementData[i] = elementData[i - 1];
            }
    }

    // PRIVATE METHODS //
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index; must be 0 to size - 1");
        }
    }

    private void ensureCapacity(int desiredCapacity) {
        // three possibilities;
        // (1) nothing needs to be done
        // (2) planned expansion is enough
        // (3) planned expansion is not enough
        if (desiredCapacity > elementData.length) {  // takes care of case (1)
            int newCapacity = Math.max(elementData.length * EXPANSION_MULTIPLIER + 1, // maybe i don't need +1, something to think more about
                    desiredCapacity); // takes care of case (2)
            elementData = Arrays.copyOf(elementData, newCapacity); // ----------------
        }
    }
}
