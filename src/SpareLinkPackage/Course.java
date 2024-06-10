package SpareLinkPackage;

public class Course {
    private int term;
    private int block;
    private String name;
    private String teacher;
    private String room;
    
    public Course(int t, int b, String n, String tr, String r) {
        term = t;
        block = b;
        name = n;
        teacher = tr;
        room = r;
    }
    
    public Course() {
        term = 0;
        block = 0;
        name = "";
        teacher = "";
        room = "";
    }
    
    public int getTerm() {
        return term;
    }
    
    public int getBlock() {
        return block;
    }
    
    public String getName() {
        return name;
    }
    
    public String getTeacher() {
        return teacher;
    }
    
    public String getRoom() {
        return room;
    }
    
    public void setTerm(int t) {
        term = t;
    }
    
    public void setBlock(int b) {
        block = b;
    }
    
    public void setName(String n) {
        name = n;
    }
    
    public void setTeacher(String tr) {
        teacher = tr;
    }
    
    public void setRoom(String r) {
        room = r;
    }
}
