/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpareLinkPackage;

import java.util.ArrayList;

/**
 *
 * @author aviare
 */
public class StudentDatabase {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private ArrayList<Student> StudentList = new ArrayList();
    public StudentDatabase(){
        StudentList.clear();
    }
    
    public ArrayList<Student> getList(){
        return StudentList;
    }
    public void setList(ArrayList<Student> list){
        StudentList = list;
    }
    public void addStudent(Student s){
        StudentList.add(s);
    }
    public int getStudentCount(){
        return StudentList.size();
    }
}
