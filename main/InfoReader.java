package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InfoReader {

    final static String courseInfoName = "Courses_Info.txt";
    final static String learnRecordInfoName = "Learning.txt";
    final static String studentsInfoName = "Students_Info.txt";
    final static String[] majorNames = {"Computer Science", "Network Engineering", "Software Engineering"};

    static ArrayList<Student> readStudentInfo(Scanner in) {
        ArrayList<Student> students = new ArrayList<>();
        while (in.hasNext()) {
            String[] content = in.nextLine().split(", ");
            students.add(new Student(content[0], content[1], content[2]));
        }
        return students;
    }

    static ArrayList<Course> readCourseInfo(Scanner in) {
        ArrayList<Course> courses = new ArrayList<>();
        while (in.hasNext()) {
            String[] content = in.nextLine().split(", ");
            courses.add(new Course(content[0], content[1], Integer.valueOf(content[2])));
        }
        return courses;
    }

    static Major readMajorInfo(String majorName, Scanner in) {
        Major major = new Major(majorName);
        CourseGroup courseGroup = new CourseGroup();
        // [Basic Compulsory]
        String line = in.nextLine();
        assert line.split(" ")[0].equals("[Basic");
        line = in.nextLine();
        while (line.charAt(0) != '[') {
            courseGroup.addBasicCompulsory(DataBase.getDataBase().getCourseByCode(line));
            line = in.nextLine();
        }
        // [Major Compulsory]
        assert line.split(" ")[0].equals("[Major");
        line = in.nextLine();
        while (line.charAt(0) != '[') {
            courseGroup.addMajorCompulsory(DataBase.getDataBase().getCourseByCode(line));
            line = in.nextLine();
        }
        // [Major Elective]
        courseGroup.setMajorElectiveCredits(Integer.parseInt(line.split(" ")[2]));
        line = in.nextLine();
        while (line.charAt(0) != '[') {
            courseGroup.addMajorElective(DataBase.getDataBase().getCourseByCode(line));
            line = in.nextLine();
        }
        // [Module n]
        int moduleIndex = 0;
        while (!line.split(" ")[0].equals("[Other")) {
            courseGroup.addModule(Integer.parseInt(line.split(" ")[2]));
            line = in.nextLine();
            while (line.charAt(0) != '[') {
                courseGroup.addCourseAtModule(moduleIndex, DataBase.getDataBase().getCourseByCode(line));
                line = in.nextLine();
            }
            moduleIndex++;
        }
        courseGroup.setElectiveCredits(Integer.parseInt(line.split(" ")[2]));
        major.setCourseGroup(courseGroup);
        return major;
    }

    static ArrayList<LearnRecord> readLearnRecordInfo(Scanner in) {
        ArrayList<LearnRecord> learnRecords = new ArrayList<>();
        while (in.hasNext()) {
            String[] content = in.nextLine().split(", ");
            learnRecords.add(new LearnRecord(content[0], content[1]));
        }
        return learnRecords;
    }

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Course> courses = readCourseInfo(new Scanner(new FileInputStream(courseInfoName)));
        DataBase.getDataBase().setCourses(courses);

        ArrayList<Major> majors = new ArrayList<>();
        for (String majorName : majorNames)
            majors.add(readMajorInfo(majorName, new Scanner(new FileInputStream(majorName + ".txt"))));
        DataBase.getDataBase().setMajors(majors);

        ArrayList<LearnRecord> learnRecords = readLearnRecordInfo(new Scanner(new FileInputStream(learnRecordInfoName)));
        DataBase.getDataBase().setLearnRecords(learnRecords);

        ArrayList<Student> students = readStudentInfo(new Scanner((new FileInputStream(studentsInfoName))));
        DataBase.getDataBase().setStudents(students);



        DataBase.getDataBase().print();
    }
}
