import java.util.NoSuchElementException;

public class HashSetQueue<T> {
    private Node<T> front;
    private Node<T> end;
    private HashSet<T> set;

    public HashSetQueue() {
        clear();
    }

    public boolean add(T element) {
        if (set.contains(element)) {
            return false;
        }

        set.add(element);
        if (front == null) {
            front = new Node<T>(element);
            end = front;
        } else {
            end.next = new Node<T>(element);
            end = end.next;
        }
        return true;
    }

    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("HashSetQueue is empty.");
        }

        T saveData = front.data;
        set.remove(saveData);
        front = front.next;
        if (front == null) {
            end = null;
        }
        return saveData;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }

        return front.data;
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public void clear() {
        set = new HashSet<T>();
        front = null;
        end = null;
    }

    public int size() {
        return set.size();
    }

    public String toString() {
        Node<T> current = front;

        String s = "";

        while (current != null) {
            s += "\n" + current.data.toString();
            current = current.next;
        }
        return s;
    }

    private static class Node<E> {
        public E data;
        public Node<E> next;

        public Node(E data) {
            this.data = data;
            next = null;
        }
    }
}
