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

    public ArrayList<Course> getBasicCompulsory() {
        return basicCompulsory;
    }

    public void setBasicCompulsory(ArrayList<Course> basicCompulsory) {
        this.basicCompulsory = basicCompulsory;
    }

    public ArrayList<Course> getMajorCompulsory() {
        return majorCompulsory;
    }

    public void setMajorCompulsory(ArrayList<Course> majorCompulsory) {
        this.majorCompulsory = majorCompulsory;
    }

    public ArrayList<Course> getMajorElective() {
        return majorElective;
    }

    public void setMajorElective(ArrayList<Course> majorElective) {
        this.majorElective = majorElective;
    }

    public ArrayList<ArrayList<Course>> getModules() {
        return modules;
    }

    public void setModules(ArrayList<ArrayList<Course>> modules) {
        this.modules = modules;
    }

    public ArrayList<Integer> getModuleCourseCount() {
        return moduleCourseCount;
    }

    public void setModuleCourseCount(ArrayList<Integer> moduleCourseCount) {
        this.moduleCourseCount = moduleCourseCount;
    }

    public int getBasicCompulsoryCredits() {
        return basicCompulsoryCredits;
    }

    public void setBasicCompulsoryCredits(int basicCompulsoryCredits) {
        this.basicCompulsoryCredits = basicCompulsoryCredits;
    }

    public int getMajorCompulsoryCredits() {
        return majorCompulsoryCredits;
    }

    public void setMajorCompulsoryCredits(int majorCompulsoryCredits) {
        this.majorCompulsoryCredits = majorCompulsoryCredits;
    }

    public int getMajorElectiveCredits() {
        return majorElectiveCredits;
    }

    public int getElectiveCredits() {
        return electiveCredits;
    }

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
