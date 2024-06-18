package SpareLinkPackage;

public class Course {
    private int semester;
    private int term; // refers to before or after midterm (for courses like Civics and Careers). term = 0 is both terms.
    private int block; // default to Day1
    private String name;
    private String teacher;
    private String room;
    
    public Course(int s, int t, int b, String n, String tr, String r) {
        semester = s;
        term = t;
        block = b;
        name = n;
        teacher = tr;
        room = r;
    }
    
    public Course() {
        semester = 0;
        term = 0;
        block = 0;
        name = "";
        teacher = "";
        room = "";
    }
    
    public int getSemester() {
        return semester;
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
    
    public void setSemester(int s) {
        semester = s;
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

    public String toString() {
        return "- " + name + ", " + semester + ", " + block + ", " + teacher + ", " + room + "\n";
    }
}
