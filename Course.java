
import java.util.Enumeration;
import java.util.Vector;

public class Course {
    private String title;
    private Vector<CourseRecord> courseRecords;

    Course() {
        courseRecords = new Vector<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void addCourseRecord(CourseRecord cr) {
        courseRecords.addElement(cr);
    }

    public Enumeration<CourseRecord> getCourseRecords() {
        return courseRecords.elements();
    }

    // Menampilkan seluruh mahasiswa
    public void printCourseStudents() {
        System.out.println("Daftar Mahasiswa:");

        Enumeration<CourseRecord> records = getCourseRecords();

        while (records.hasMoreElements()) {
            CourseRecord cr = records.nextElement();
            System.out.println(cr.getStudent().getName());
        }
    }

    // Menampilkan mahasiswa dengan rata-rata nilai terbaik
    public void printBestStudent() {
        Enumeration<CourseRecord> records = getCourseRecords();

        String bestStudent = "";
        double bestAverage = -1;

        while (records.hasMoreElements()) {
            CourseRecord cr = records.nextElement();
            Enumeration<Assignment> assignments =
                cr.getAssignments();

            double total = 0;
            int count = 0;

            while (assignments.hasMoreElements()) {
                Assignment a = assignments.nextElement();

                try {
                    total += a.getMark();
                    count++;
                } catch (NotYetSetException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (count > 0) {
                double average = total / count;

                if (average > bestAverage) {
                    bestAverage = average;
                    bestStudent = cr.getStudent().getName();
                }
            }
        }

        if (bestAverage >= 0) {
            System.out.println("Mahasiswa Terbaik: " + bestStudent);
            System.out.println("Rata-rata Nilai: " + bestAverage);
        } else {
            System.out.println("Belum ada nilai mahasiswa.");
        }
    }

    // Menampilkan mahasiswa yang layak mengikuti ujian akhir
    public void printFinalExamStudents() {
        Enumeration<CourseRecord> records = getCourseRecords();

        System.out.println("Mahasiswa Layak Ujian Akhir:");

        while (records.hasMoreElements()) {
            CourseRecord cr = records.nextElement();
            Enumeration<Assignment> assignments =
                cr.getAssignments();

            double total = 0;
            int count = 0;

            while (assignments.hasMoreElements()) {
                Assignment a = assignments.nextElement();

                try {
                    total += a.getMark();
                    count++;
                } catch (NotYetSetException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (count > 0) {
                double average = total / count;

                if (average >= 60) {
                    System.out.println(cr.getStudent().getName());
                }
            }
        }
    }
}
