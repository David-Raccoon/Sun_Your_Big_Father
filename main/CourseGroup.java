package main;

import java.util.ArrayList;

public class CourseGroup {
    ArrayList<Course> basicCompulsory = new ArrayList<>();
    ArrayList<Course> majorCompulsory = new ArrayList<>();
    ArrayList<Course> majorElective = new ArrayList<>();
    // 第n个模块课需要达到的门数
    ArrayList<ArrayList<Course>> modules = new ArrayList<>();
    ArrayList<Integer> moduleCourseCount = new ArrayList<>();

    int basicCompulsoryCredits = 0;
    int majorCompulsoryCredits = 0;
    int majorElectiveCredits = 0;
    int electiveCredits = 0;

    public void addBasicCompulsory(Course course) {
        basicCompulsory.add(course);
        basicCompulsoryCredits += course.getCredit();
    }

    public void addMajorCompulsory(Course course) {
        majorCompulsory.add(course);
        majorCompulsoryCredits += course.getCredit();
    }

    public void addMajorElective(Course course) {
        majorElective.add(course);
    }

    public void addModule(int courseCount) {
        modules.add(new ArrayList<>());
        moduleCourseCount.add(courseCount);
    }

    public void addCourseAtModule(int i, Course course) {
        modules.get(i).add(course);
    }

    public void setMajorElectiveCredits(int majorElectiveCredits) {
        this.majorElectiveCredits = majorElectiveCredits;
    }

    public void setElectiveCredits(int electiveCredits) {
        this.electiveCredits = electiveCredits;
    }

    public void print() {
        System.out.println("[Basic Compulsory] " + basicCompulsoryCredits);
        for (Course course : basicCompulsory)
            course.print();
        System.out.println("[Major Compulsory] " + majorCompulsoryCredits);
        for (Course course : majorCompulsory)
            course.print();
        System.out.println("[Major Compulsory] " + majorElectiveCredits);
        for (Course course : majorElective)
            course.print();
        assert moduleCourseCount.size() == modules.size();
        for (int i = 0; i < moduleCourseCount.size(); i++) {
            System.out.println("[Module " + (i + 1) + "]" + " " + moduleCourseCount.get(i));
            for(Course course : modules.get(i))
                course.print();
        }
        System.out.println("[Other Elective] " + electiveCredits);
    }
}
