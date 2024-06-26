package SpareLinkPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Student {
    private String name;
    private String gender;
    private int studentNumber;
    private int grade;
    private ArrayList<Course> courses = new ArrayList<>();
    
    // constructors
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
    
    // getters
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
    

    // setters
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

    // sort courses (increasing semester, increasing block)
    public void sortCourses() {
        Collections.sort(courses, new Comparator<Course>() {
            @Override
            public int compare(Course c1, Course c2) {
                if(c1.getSemester() != c2.getSemester()) {
                    return Integer.compare(c1.getSemester(), c2.getSemester());
                }
                else {
                    return Integer.compare(c1.getBlock(), c2.getBlock());
                }
            }
        });
    }

    // get the block that has a spare (-1 if no spare)
    public int spareIndex(boolean Sem2){
        int i=0;
        if(Sem2){
            i=4;
        }
        for(;i<this.getCourses().size();i++){
            if(this.getCourse(i).isSpare()){
                return i;
            }
        }
        return -1;
    }

    // for debugging purposes
    public String toString() {
        String temp = studentNumber + ", " + name + ", " + grade + ", " + gender + "\n";
        for(Course c : courses) {
            temp += c;
        }
        return temp;
    }
}
