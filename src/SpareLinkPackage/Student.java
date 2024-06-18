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
        courses.clear();
    }
    
    public Student() {
        name = "";
        gender = "";
        studentNumber = 0;
        grade = 0;
        courses.clear();
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

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public Course getCourse(int index) {
        return courses.get(index);
    }

    public int getNumCourses() {
        return courses.size();
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

    public void addCourse(Course c) {
        courses.add(c);
    }

    public String toString() {
        String temp = studentNumber + ", " + name + ", " + grade + ", " + gender + "\n";
        for(Course c : courses) {
            temp += c;
        }
        return temp;
    }
}
