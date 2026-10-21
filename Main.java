
public class Main {
    public static void main(String[] args) {

        Course course = new Course();
        course.setTitle("Pemrograman Java");

        Student s1 = new Student();
        s1.setName("Andi");

        Student s2 = new Student();
        s2.setName("Budi");

        Student s3 = new Student();
        s3.setName("Citra");

        Assignment a1 = new Assignment();
        a1.setMark(90);

        Assignment a2 = new Assignment();
        a2.setMark(85);

        Assignment a3 = new Assignment();
        a3.setMark(70);

        Assignment a4 = new Assignment();
        a4.setMark(75);

        Assignment a5 = new Assignment();
        a5.setMark(50);

        Assignment a6 = new Assignment();
        a6.setMark(55);

        CourseRecord cr1 = new CourseRecord();
        cr1.setStudent(s1);
        cr1.addAssignment(a1);
        cr1.addAssignment(a2);

        CourseRecord cr2 = new CourseRecord();
        cr2.setStudent(s2);
        cr2.addAssignment(a3);
        cr2.addAssignment(a4);

        CourseRecord cr3 = new CourseRecord();
        cr3.setStudent(s3);
        cr3.addAssignment(a5);
        cr3.addAssignment(a6);

        course.addCourseRecord(cr1);
        course.addCourseRecord(cr2);
        course.addCourseRecord(cr3);

        System.out.println("Course: " + course.getTitle());
        System.out.println();

        course.printCourseStudents();

        System.out.println();
        course.printBestStudent();

        System.out.println();
        course.printFinalExamStudents();
    }
}
