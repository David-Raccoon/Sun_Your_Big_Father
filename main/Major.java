package main;

public class Major {
    String name;
    CourseGroup courseGroup;

    public Major(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CourseGroup getCourseGroup() {
        return courseGroup;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseGroup(CourseGroup courseGroup) {
        this.courseGroup = courseGroup;
    }

    public void print() {
        System.out.println(name);
        courseGroup.print();
    }
}
