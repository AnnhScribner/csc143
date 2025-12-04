public record Student(int id, String name, double gpa, boolean isEnrolled)
            implements Comparable<Student> {

    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Student)) {
            return false;
        } else if (this == other) {
            return true;
        } else {
            Student otherStudent = (Student)other;
            return this.compareTo(otherStudent) == 0;
        }
    }

}
