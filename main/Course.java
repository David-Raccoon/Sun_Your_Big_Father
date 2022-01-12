package main;

public class Course {
    String code;
    String name;
    int credit;

    public Course(String code, String name, int credit) {
        this.code = code;
        this.name = name;
        this.credit = credit;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    void print() {
        System.out.println(this.code + ", " + this.name + ", " + this.credit);
    }
}
