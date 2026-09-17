
import student.Student;
import course.Course;

public class Q7_1 {
    public static void main(String[] args) {
        Student s = new Student(101, "Dharshana", "CSE");
        Course c = new Course(201, "Java Programming", 4);
        System.out.println("=== Student Details ===");
        s.displayStudent();
        System.out.println();
        System.out.println("Course Details: ");
        c.displayCourse();
    }
}
