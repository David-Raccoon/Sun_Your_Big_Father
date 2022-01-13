package main;

import java.util.ArrayList;

public class DataBase {
    static DataBase dataBase = null;

    ArrayList<Student> students;
    ArrayList<Course> courses;
    ArrayList<LearnRecord> learnRecords;
    ArrayList<Major> majors;

    public ArrayList<LearnRecord> getLearnRecords() {
        return learnRecords;
    }

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

    public Major getMajorByName(String name) {
        for (Major major : majors) {
            if (major.getName().equals(name))
                return major;
        }
        assert false;
        // should not reach here
        return null;
    }

    public Course getCourseByCode(String code) {
        for (Course course : courses) {
            if (course.getCode().equals(code))
                return course;
        }
        assert false;
        // should not reach here
        return null;
    }

    public Student getStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equals(name))
                return student;
        }
        assert false;
        // should not reach here
        return null;
    }
}
