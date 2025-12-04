/**
 * @author Anna Scribner
 * @version May 4, 2025
 * <p>
 * A generic circular linked list
 *
 * @param <E> the type of elements stored in the list
 */

import java.util.Iterator;

public class CircularLinkedList<E> implements CircularLinkedListInterface<E>, Iterable<E> {
    /**
     * The front field represents the first node in the circular linked list.
     */
    private Node<E> front;
    /**
     * The end field represents the last node in the circular linked list.
     */
    private Node<E> end;
    /**
     * Represents the current number of elements in the circular linked list.
     */
    private int size;

    /**
     * Constructs an empty CircularLinkedList.
     * Initializes the list with front and end to null
     * and the size of the list to 0.
     */
    public CircularLinkedList() {
        front = null;
        end = null;
        size = 0;
    }

    /**
     * Constructs a CircularLinkedList containing the specified elements.
     * Adds each provided element to the list by calling the add method.
     *
     * @param elements the elements to be added to the list
     */
    @SafeVarargs
    public CircularLinkedList(E... elements) {
        for (E element : elements) {
            add(element);
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E get(int position) {
        // negative position
        if (position < 0) {
            throw new IllegalArgumentException("Position out of bounds");
        }

        if (front == null) {
            throw new IllegalArgumentException("List is empty");
        }

        // general cases
        Node<E> current = front;
        int i = 0;
        do {
            if (i == position) {
                return current.data;
            }
            current = current.next;
            i++;
        } while (current != front);

        // in case it leaves the while loop, so it exceeded the bounds
        throw new IllegalArgumentException("Position out of bounds");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(E value) {
        if (front == null) {
            front = new Node<E>(value);
            end = front;
        } else {
            end.next = new Node<E>(value);
            end = end.next;
        }
        end.next = front;
        size++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(E value) {
        if (front == null) {
            return false;
        }

        // special case where there's only one element
        if (front == end) {
            if (front.data.equals(value)) {
                front = null;
                end = null;
                size--;
                return true;
            }
        }

        Node<E> current = front;
        do {
            if (current.next.data.equals(value)) {
                if (current.next == front) {
                    front = front.next;
                    end.next = front;
                } else if (current.next == end) {
                    end = current;
                    end.next = front;
                } else {
                    current.next = current.next.next;
                }
                size--;
                return true;
            }
            current = current.next;
        } while (current != front);

        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("Position out of bounds");
        }
        if (front == null) {
            throw new IllegalArgumentException("List is empty");
        }
        // special case where position equals 0
        if (position == 0) {
            if (front == end) {
                front = null;
                end = null;
            } else {
                front = front.next;
                end.next = front;
            }
            size--;
        } else {
            Node<E> current = front;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
                if (current.next == front) {
                    throw new IllegalArgumentException("Position out of bounds, position is " + position);
                }
            }

            if (current.next == end) {
                end = current;
                end.next = front;
            } else {
                current.next = current.next.next;
            }
            size--;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return new CircularLinkedListIterator();
    }

    /**
     * Checks whether the specified element is in the circular linked list.
     *
     * @param value the element to be checked
     *
     * @return true if the specified value exists in the list, false otherwise
     */
    public boolean contains(E value) {
        if (front == null) {
            return false;
        }

        Node<E> current = front;
        do {
            if (current.data.equals(value)) {
                return true;
            }
            current = current.next;
        }
        while (current != front);

        return false;
    }

    /**
     * An iterator for a circular linked list.
     * <p>
     * This iterator maintains a reference to the current node in the circular linked list
     * It starts from the front of the list and wraps around once the end is reached.
     */
    private class CircularLinkedListIterator implements Iterator<E> {
        /**
         * Represents the current node in the circular linked list during iteration.
         */
        private Node<E> current;

        /**
         * Constructs a new iterator for a circular linked list.
         *
         * The iterator initializes the current node reference to the front node
         * of the circular linked list, allowing traversal of the list starting
         * from this point. The iteration wraps around the list due to its circular nature.
         */
        public CircularLinkedListIterator() {
            current = front;
        }

        /**
         * Determines if there are more elements to iterate over in the circular linked list.
         *
         * @return true if there is at least one element in the list, false otherwise
         */
        public boolean hasNext() {
            return front != null;
        }

        /**
         * Retrieves the next element in the circular linked list and advances the iterator.
         *
         * If the iterator has no more elements to traverse (when `hasNext()` returns false),
         * this method will return null.
         *
         * @return the next element in the iteration, or null if no elements are left
         */
        public E next() {
            if (!hasNext()) {
                return null;
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }

    /**
     * Represents a single node in a generic linked list structure.
     *
     * @param <T> The type of data stored in this node.
     */
    private static class Node<T> {
        /**
         * The data stored in this node.
         */
        public T data;
        /**
         * A reference to the next node in the linked list.
         */
        public Node<T> next;

        /**
         * Constructs a new node with the specified data.
         *
         * @param data the data to be stored in the node
         */
        public Node(T data) {
            this.data = data;
            next = null;
        }
    }
}
