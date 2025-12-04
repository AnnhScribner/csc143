public class LinkedStudentList {

    private ListStudentNode front;

    // post: constructs an empty list
    public LinkedStudentList() {
        front = null;
    }

    public Student get(int index) {
        return nodeAt(index).data;
    }

    public int indexOf(Student value) {
        int index = 0;
        ListStudentNode current = front;
        while (current != null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public void add(Student value) {
        if (front == null) {
            front = new ListStudentNode(value);
        } else {
            ListStudentNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListStudentNode(value);
        }
    }

    public void add(int index, Student value) {
        if (index == 0) {
            front = new ListStudentNode(value, front);
        } else {
            ListStudentNode current = nodeAt(index - 1);
            current.next = new ListStudentNode(value, current.next);
        }
    }

    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListStudentNode current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    private ListStudentNode nodeAt(int index) {
        ListStudentNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    //----------------------------------------------------------------------
    //      EXAM METHODS START HERE
    //----------------------------------------------------------------------

    /**
     * Note:  difficulty level --> easy
     *
     * Obtains a count of enrolled students.  Full credit solutions will
     * not call any other methods in this class, nor create/use additional
     * global variables.
     *
     * @return count of enrolled students; 0 is a valid possibility
     */
    public int getEnrolledCount() {
        return -1;
    }

    /**
     * Note:  difficulty level --> easy
     *
     * Collects the average of student GPAs.  Full credit solutions will
     * not call any methods in this class, nor create/use additional global
     * variables.
     *
     * @return average GPA, or -1.0 if the list is empty
     */
    public double calcAverageGpa() {
        return -1.0;
    }

    /**
     * Note:  difficulty level --> medium
     *
     * Creates and returns a list of students on the Dean's List,
     * students who have a 3.5 or greater GPA.
     *
     * @return  list of students on the Dean's List; null if the list is empty or there are no
     *          students meeting the criteria
     */
    public LinkedStudentList generateDeansList() {
        return null;
    }

    /**
     * Note:  difficulty level --> hard
     * This problem is too hard for our exam, but it's good practice
     * for linked-list thinking.  Test your solution carefully!
     *
     * Removes all non-enrolled students from the list,
     * leaving other students in the same order they were before.
     *
     * Full-credit solutions will not create and use any other data
     * structures, e.g., an array, another LinkedList, ArrayList,
     * String used as a data structure, etc.
     *
     * Full-credit solutions will not traverse the list multiple
     * times, in this method or in helper methods called.
     */
    public void removeNonEnrolled() {
    }

    //----------------------------------------------------------------------
    //      EXAM METHODS END HERE
    //----------------------------------------------------------------------

    private static class ListStudentNode {
        public Student data;
        public ListStudentNode next;

        public ListStudentNode(Student data) {
            this(data, null);
        }

        public ListStudentNode(Student data, ListStudentNode next) {
            this.data = data;
            this.next = next;
        }

    }
}
