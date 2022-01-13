package main;

public class Course {
    private String code;
    private String name;
    private int credit;
    private String remark = "null";

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

    public String getRemark() {
        return remark;
    }

    void print() {
        System.out.println(this.code + ", " + this.name + ", " + this.credit);
    }
}
