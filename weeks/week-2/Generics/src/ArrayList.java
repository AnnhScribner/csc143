import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class ArrayList<E> implements Iterable<E> {
    // CONSTANT S//
    private static final int DEFAULT_CAPACITY = 100;
    private static final int EXPANSION_MULTIPLIER = 2;

    // INSTANCE DATA //
    private E[] elementData;
    private int size;

    // CONSTRUCTORS //
    public ArrayList() {

        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked") // this is to make Xlint to ignore the casting i did in the method
    public ArrayList(int initialCapacity) {
        elementData = (E[]) new Object[initialCapacity]; // array full of zeros  ----> Xlint is not happy with this, but this is how i have to do
        size = 0;
    }

    // PUBLIC METHODS //
    public boolean add(E element) {
        ensureCapacity(size + 1); // size plus one element that I want to add
        elementData[size++] = element;
        //size++; -> it will increment AFTER we use the expression
        // ++size; -> it will increment BEFORE using the expression
        return true;
    }

    public boolean addAll(ArrayList other) {
        // TODO
        ensureCapacity(other.size);
        return true;
    }

    public void add(int index, E element) {
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

    public E remove(int index) {
        checkIndex(index);
        E returnElement = elementData[index];
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
            if (elementData[i].equals(element)) {
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

    public E get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    public E set(int index, E element) {
        checkIndex(index);
        E returnElement = elementData[index];
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

    // it is going to return an object that uses iterator interface
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator {

        private int position;
        private boolean removeOk = false;


        public ArrayListIterator() {
            position = 0;
        }

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("next has no more elements");
            }
            removeOk = true;
            return elementData[position++];
        }

        @Override
        public void remove() {
            if (!removeOk) {
                throw new IllegalStateException("Remove not allowed at this time");
            }
            ArrayList.this.remove(position - 1);
            position--;
            removeOk = false;
        }

        @Override
        public void forEachRemaining(Consumer action) {
            Iterator.super.forEachRemaining(action);
        }
    }
}
