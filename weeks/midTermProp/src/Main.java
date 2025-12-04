import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ArrayStudentList studentArrayList = new ArrayStudentList();
        studentArrayList.add(new Student(12345, "Chris Campos", 3.7, true));
        studentArrayList.add(new Student(56459, "Dana De La Rosa", 4.0, false));
        studentArrayList.add(new Student(29182, "Lupe Lopez", 3.2, true));
        studentArrayList.add(new Student(82903, "Peyton Pedroza", 2.9, true));

        // Question #1
        Student[] enrolledStudents = studentArrayList.getEnrolledArray();
        System.out.printf("Enrolled students: %d\n", enrolledStudents.length);
        System.out.println(Arrays.toString(enrolledStudents));


        LinkedStudentList students = new LinkedStudentList();
        students.add(new Student(12345, "Chris Campos", 3.7, true));
        students.add(new Student(56459, "Dana De La Rosa", 4.0, false));
        students.add(new Student(29182, "Lupe Lopez", 3.2, true));
        students.add(new Student(82903, "Peyton Pedroza", 2.9, true));

        // Question #1
        System.out.printf("Enrollment count: %d\n", students.getEnrolledCount());
        // Question #2
        System.out.printf("Average GPA: %.2f\n", students.calcAverageGpa());
        // Question #3
        LinkedStudentList deansList = students.generateDeansList();
        System.out.println("Check contents of deansList to see Dean's List students");
        // Question #4
        students.removeNonEnrolled();
        System.out.println("Check contents of students; should not only contain enrolled students");
    }

}
