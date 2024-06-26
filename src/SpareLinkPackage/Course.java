package SpareLinkPackage;

public class Course {
    private int semester;
    private int block; // default to Day1
    private String name;
    private String teacher;
    private String room;
    
    // constructors
    public Course(int s, int b, String n, String tr, String r) {
        semester = s;
        block = b;
        name = n;
        teacher = tr;
        room = r;
    }
    
    public Course() {
        semester = 0;
        block = 0;
        name = "";
        teacher = "";
        room = "";
    }
    
    // getters
    public int getSemester() {
        return semester;
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
    
    // setters
    public void setSemester(int s) {
        semester = s;
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

    // for debugging purposes
    public String toString() {
        return "- " + name + ", " + semester + ", " + block + ", " + teacher + ", " + room + "\n";
    }

    // check if the course is a spare
    public boolean isSpare(){
        return name.contains("SPAR");
    }
}
