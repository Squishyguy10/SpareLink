package SpareLinkPackage;

public class Student {
    private String name;
    
    public Student(String n) {
        name = n;
    }
    
    public Student() {
        name = "";
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String n) {
        name = n;
    }
}
