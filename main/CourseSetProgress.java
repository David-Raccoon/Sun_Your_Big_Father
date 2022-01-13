package main;

import java.util.ArrayList;

public class CourseSetProgress {
    private String typeName;

    ArrayList<Course> courses = new ArrayList<>();

    private int creditsTaken;
    private int numberTaken;

    private int creditsRequired;
    private int numberRequired;

    private int progress;

    public CourseSetProgress(String typeName, int creditsRequired, int numberRequired) {
        this.typeName = typeName;
        this.creditsRequired = creditsRequired;
        this.numberRequired = numberRequired;
    }

    public void addCourse(Course c) {
        courses.add(c);
        creditsTaken += c.getCredit();
        numberTaken += 1;
        computeProgress();
    }

    private void computeProgress() {
        if (numberRequired == -1)
            progress = creditsTaken > creditsRequired ? 100 : (int) ((float) creditsTaken / creditsRequired * 100);
        else
            progress = numberTaken > numberRequired ? 100 : (int) ((float) numberTaken / numberRequired * 100);
    }

    public String summaryToJSON() {
        String result = "{\n";
        result += "\"课程类型\": " + typeName + ",\n";
        result += "\"已修学分\":" + creditsTaken + ",\n";
        result += "\"已修课程数量\":" + numberTaken + ",\n";
        result += "\"要求学分/课程数量\":" + (numberRequired == -1 ? creditsRequired : numberRequired) + ",\n";
        result += "\"进度情况\":\"" + progress + "%\"\n";
        result += "}";
        return result;
    }

    public String detailToJSON() {
        String result = typeName;
        result += ": [\n";
        for (Course c : courses) {
            result += "{\n";
            result += "\"课程\": \"" + c.getName() + "\",\n";
            result += "\"学分\": \"" + c.getCredit() + "\",\n";
            result += "\"备注\": \"" + c.getRemark() + "\"\n";
            result += "},\n";
        }

        if (numberRequired == -1)
            result += "{\n" +
                    "\"总结\": \"" + "要求" + creditsRequired + "学分, 缺少" +
                    (Math.max(creditsRequired - creditsTaken, 0)) +
                    "学分.\",\n" +
                    "\"备注\": \"" + progress + "%\"\n" +
                    "}\n";
        else
            result += "{\n" +
                    "\"总结\": \"" + "要求" + numberRequired + "门课, 缺少" +
                    (Math.max(numberRequired - numberTaken, 0)) +
                    "门课.\",\n" +
                    "\"备注\": \"" + progress + "%\"\n" +
                    "}\n";

        result += "]\n";
        return result;
    }
}
