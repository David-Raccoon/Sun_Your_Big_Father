package main;

public class Student {
    Major major;
    String id;
    String name;

    Progress progress;

    public Student(String id, String name, String majorName) {
        this.major = DataBase.getDataBase().getMajorByName(majorName);
        this.id = id;
        this.name = name;
    }

    void print() {
        System.out.println(id + ", " + name + ", " + major.getName());
    }
}
