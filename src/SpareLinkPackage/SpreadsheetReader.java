package SpareLinkPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class SpreadsheetReader {
    public static void main(String[] args)  throws EncryptedDocumentException, IOException {
        ArrayList<Student> students = getStudentList("sampleFile.xlsx");
        for(Student s : students) {
            System.out.println(s);
        }
    }
    public static ArrayList<Student> getStudentList(String filePath) throws EncryptedDocumentException, IOException {
        File file = new File(filePath);

        FileInputStream fis = null;
        XSSFWorkbook wb = null;
        ArrayList<Student> studentList = new ArrayList<>();

        try {
            fis = new FileInputStream(file);
            wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheetAt(0);
        
            Map<Integer, Student> studentMap = new HashMap<>();
        
            boolean firstLine = true;
            boolean isCoop = false;
            boolean isCareers = false;
            for(Row row : sheet) {
                if(firstLine) {
                    firstLine = false;
                    continue;
                }
                
                int cellNum = 0;
                int currentStudentNum = (int)row.getCell(0).getNumericCellValue();
                Student newStudent;
                
                if(studentMap.containsKey(currentStudentNum)) {
                    newStudent = studentMap.get(currentStudentNum);
                }
                else {
                    newStudent = new Student();
                    newStudent.setStudentNumber(currentStudentNum);
                    studentMap.put(currentStudentNum, newStudent);
                }

                Course newCourse = new Course();
                for(Cell cell : row) {
                    switch(cellNum) {
                        case 1:
                            newStudent.setName(cell.getStringCellValue());
                            break;
                        case 2:
                            newStudent.setName(cell.getStringCellValue() + " " + newStudent.getName());
                            break;
                        case 3:
                            newStudent.setGender(cell.getStringCellValue());
                            break;
                        case 4:
                            newStudent.setGrade((int)cell.getNumericCellValue());
                            break;
                        case 6:
                            newCourse.setSemester((int)(cell.getStringCellValue().charAt(1)-'0'));
                            break;
                        case 7: 
                            String tempSched = cell.getStringCellValue();
                            if(tempSched.length() == 15) {
                                newCourse.setBlock((int)(tempSched.charAt(5)-'A'+1));
                            }
                            else {
                                newCourse.setBlock((int)(tempSched.charAt(10)-'A'+1)); // coop
                                isCoop = true;
                            }
                            break;
                        case 8:
                            String tempName = cell.getStringCellValue();
                            newCourse.setName(tempName);
                            if(tempName.contains("GLC2O")) {
                                isCareers = true;
                            }
                            break;
                        case 9:
                            newCourse.setTeacher(cell.getStringCellValue());
                            break;
                        case 10:
                            try { // rooms can have letters or just be numbers so this try-catch is necessary
                                newCourse.setRoom(cell.getStringCellValue());
                            }
                            catch(IllegalStateException e) {
                                newCourse.setRoom(String.valueOf((int) cell.getNumericCellValue()));
                            }
                            break;
                    }
                    cellNum++;
                }
                if(!isCareers) {
                    newStudent.addCourse(newCourse);
                }
                if(isCoop) {
                    newStudent.addCourse(newCourse);
                    newStudent.addCourse(new Course(newCourse.getSemester(), newCourse.getTerm(), newCourse.getBlock()+1, newCourse.getName(), newCourse.getTeacher(), newCourse.getRoom()));
                }
                isCareers = false;
                isCoop = false;
                newStudent.sortCourses();
            }
            studentList.addAll(studentMap.values());
        }
        finally {
            if(wb != null) {
                try {
                    wb.close();
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null) {
                try {
                    fis.close();
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return studentList;
    }
}
