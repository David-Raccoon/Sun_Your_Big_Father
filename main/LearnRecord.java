package main;

public class LearnRecord {
    String studentId;
    String courseId;

    public LearnRecord(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    void print() {
        System.out.println(studentId + ", " + courseId);
    }
}
