public class LinkedIntList<E{
    private ListNode<E> front;
    private int size;


    private static class ListNode<T>{
        public T data;
        public ListNode<T> next;
    }
}