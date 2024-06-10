package SpareLinkPackage;

import java.util.ArrayList;

public class Student {
    private String name;
    private String gender;
    private int studentNumber;
    private int grade;
    private ArrayList<Course> courses = new ArrayList<>();
    
    public Student(String n, String gen, int sn, int gr) {
        name = n;
        gender = gen;
        studentNumber = sn;
        grade = gr;
    }
    
    public Student() {
        name = "";
        gender = "Aviare";
        studentNumber = -1;
        grade = 0;
    }
    
    public String getName() {
        return name;
    }
    
    public String getGender() {
        return gender;
    }
    
    public int getStudentNumber() {
        return studentNumber;
    }
    
    public int getGrade() {
        return grade;
    }
    
    public void setName(String n) {
        name = n;
    }
    
    public void setGender(String gen) {
        gender = gen;
    }
    
    public void setStudentNumber(int sn) {
        studentNumber = sn;
    }
    
    public void setGrade(int gr) {
        grade = gr;
    }
}
