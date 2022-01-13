package main;

public class Student {
    private Major major;
    private String id;
    private String name;

    private Progress progress;

    public Student(String id, String name, String majorName) {
        this.major = DataBase.getDataBase().getMajorByName(majorName);
        this.id = id;
        this.name = name;
        progress = new Progress(major, id);
    }

    public String getName() {
        return name;
    }

    public void changeMajor(Major major) {
        this.major = major;
        progress = new Progress(major, id);
    }

    public String getProgressJSON() {
        String json = "{\n";
        json += "\"学号\": \"" + id + "\",\n";
        json += "\"学生名\": \"" + name + "\",\n";
        json += "\"专业\": \"" + major.getName() + "\",\n";
        json += "\"进度汇总\": [\n";
        json += progress.getCompulsory().summaryToJSON() + ",\n" +
                progress.getMajorElective().summaryToJSON() + ",\n" +
                progress.getModule1().summaryToJSON() + ",\n" +
                progress.getModule2().summaryToJSON() + ",\n" +
                progress.getOther().summaryToJSON() + "\n],";
        json += "\"进度详情\": {\n";
        json += progress.getCompulsory().detailToJSON() + ",\n" +
                progress.getMajorElective().detailToJSON() + ",\n" +
                progress.getModule1().detailToJSON() + ",\n" +
                progress.getModule2().detailToJSON() + ",\n" +
                progress.getOther().detailToJSON() + "\n}";
        json += "\n}";
        return json;
    }
}
