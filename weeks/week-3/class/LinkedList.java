public class LinkedList<E> {
    private Node<E> front; // the kick-off reference, starting point for any algorithms
    private Node<E> end;
    private int size;

    public LinkedList() {
        clear();
    }

    public void clear() {
        front = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void addAtFront(E data) {
        Node<E> newNode = new Node<E>(data);
        newNode.next = front;  // newNode points to front
        front = newNode;        // front points to newNode
        size++;
    }

//    public void add(E data) {
//        if (front == null) { // empty list case
//            addAtFront(data);
//        } else {
//            Node<E> newNode = new Node<E>(data);
//            Node<E> current = front;
//            while (current.next != null) {
//                current = current.next;
//            }
//            current.next = newNode;
//        }
//        size++;
//    }

    // BABLY LINKED LIST -- Front -> End  || End -> Front -- it has two ways (uma via de mao dupla, uma rua de vai e volta)
    // CIRCULAR LINKED LIST -- ends points to the same front is pointing - (rotatória)

    public void add(E data) {
        if (front == null) { // empty list case
            addAtFront(data);
        } else {
            Node<E> current = end;

        }

    }

    public void deleteBack(E value){
        
    }

    // TODO : everything
    public E get(int index) {
        return null;
    }

    // delete later, this is just for fun
    public int count() {
        int count = 0;
        Node<E> current = front;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    // ------------------------------------------
    private static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }


}
