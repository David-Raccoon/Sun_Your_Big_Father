package main;

import java.util.ArrayList;

public class DataBase {
    static DataBase dataBase = null;

    ArrayList<Student> students;
    ArrayList<Course> courses;
    ArrayList<LearnRecord> learnRecords;
    ArrayList<Major> majors;

    private DataBase() {
    }

    static DataBase getDataBase() {
        if (dataBase == null)
            dataBase = new DataBase();
        return dataBase;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void setLearnRecords(ArrayList<LearnRecord> learnRecords) {
        this.learnRecords = learnRecords;
    }

    public void setMajors(ArrayList<Major> majors) {
        this.majors = majors;
    }

    Major getMajorByName(String name) {
        for (Major major : majors) {
            if (major.getName().equals(name))
                return major;
        }
        assert false;
        // should not reach here
        return null;
    }

    Course getCourseByCode(String code) {
        for (Course course : courses) {
            if (course.getCode().equals(code))
                return course;
        }
        assert false;
        // should not reach here
        return null;
    }

    public void print() {
        System.out.println("======= Students =======");
        for (Student student : students)
            student.print();
        System.out.println("======= Courses =======");
        for (Course course : courses)
            course.print();
        System.out.println("======= Learning Records =======");
        for (LearnRecord learnRecord : learnRecords)
            learnRecord.print();
        System.out.println("======= Majors =======");
        for (Major major : majors)
            major.print();
    }
}
