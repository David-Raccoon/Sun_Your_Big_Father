package main;

import java.util.ArrayList;

public class Progress {
    private Major major;
    private String id;
    private CourseGroup group;
    private CourseSetProgress compulsory;
    private CourseSetProgress majorElective;
    private CourseSetProgress module1;
    private CourseSetProgress module2;
    private CourseSetProgress other;
    private ArrayList<Course> taken = new ArrayList<>();

    public Progress(Major major, String id) {
        this.major = major;
        this.id = id;

        group = major.getCourseGroup();
        compulsory = new CourseSetProgress("\"必修的基础课与专业基础课\"", group.getBasicCompulsoryCredits() + group.getMajorCompulsoryCredits(), -1);
        majorElective = new CourseSetProgress("\"专业选修课\"", group.getMajorElectiveCredits(), -1);
        module1 = new CourseSetProgress("\"模块课 1\"", -1, group.getModuleCourseCount().get(0));
        module2 = new CourseSetProgress("\"模块课 2\"", -1, group.getModuleCourseCount().get(1));
        other = new CourseSetProgress("\"任意选修课\"", group.getElectiveCredits(), -1);

        load();

        match();
    }

    private void load() {
        DataBase dataBase = DataBase.getDataBase();
        ArrayList<LearnRecord> records = dataBase.getLearnRecords();
        for (LearnRecord record : records) {
            if (record.studentId.equals(id))
                taken.add(dataBase.getCourseByCode(record.courseId));
        }
    }

    private void match() {
        for (Course c : taken) {
            if (group.getMajorCompulsory().contains(c) || group.getBasicCompulsory().contains(c))
                compulsory.addCourse(c);
            else if (group.getMajorElective().contains(c))
                majorElective.addCourse(c);
            else if (group.getModules().get(0).contains(c))
                module1.addCourse(c);
            else if (group.getModules().get(1).contains(c))
                module2.addCourse(c);
            else
                other.addCourse(c);
        }
    }

    public CourseSetProgress getCompulsory() {
        return compulsory;
    }

    public CourseSetProgress getMajorElective() {
        return majorElective;
    }

    public CourseSetProgress getModule1() {
        return module1;
    }

    public CourseSetProgress getModule2() {
        return module2;
    }

    public CourseSetProgress getOther() {
        return other;
    }

}
