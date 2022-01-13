package main;

import java.util.ArrayList;

public class CourseSetProgress {
    private String typeName;

    ArrayList<Course> courses= new ArrayList<>();

    private int creditsTaken;
    private int numberTaken;

    private int creditsRequired;
    private int numberRequired;


    public CourseSetProgress(String typeName, int creditsRequired, int numberRequired) {
        this.typeName = typeName;
        this.creditsRequired = creditsRequired;
        this.numberRequired = numberRequired;
    }

    public void addCourse(Course c) {
        courses.add(c);
        creditsTaken += c.getCredit();
        numberTaken += 1;
    }

    public String getJSON()
    {
        String result = typeName;
        result += ": [\n";
        for(Course c : courses){
            result += "{\n";
            result += "课程: " + c.getName() + ",\n";
            result += "学分: " + c.getCredit() + ",\n";
            result += "备注: " + c.getRemark() + "\n";
            result += "},\n";
        }

        if(numberRequired == -1)
            result += "{\n" +
                    "总结: " + "要求" + creditsRequired + "学分, 缺少" +
                    (creditsRequired - creditsTaken < 0 ? 0 : creditsRequired - creditsTaken) +
                    "学分.,\n" +
                    "备注: " + (creditsRequired - creditsTaken < 0 ? "100%" : (float)creditsTaken / creditsRequired * 100 + "%\n") +
                    "}\n";
        else
            result += "{\n" +
                    "总结: " + "要求" + creditsRequired + "门课, 缺少" +
                    (numberRequired - numberTaken < 0 ? 0 : numberRequired - numberTaken) +
                    "门课.,\n" +
                    "备注: " + (numberRequired - numberTaken < 0 ? "100%" : (float)numberTaken / numberRequired * 100 + "%\n") +
                    "}\n";

        result += "],\n";
        return result;
    }

}
