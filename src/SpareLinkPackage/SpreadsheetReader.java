package SpareLinkPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
// spreadsheet libraries
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class SpreadsheetReader {
    // method to get the student list (takes in a string parameter of the file name)
    public static ArrayList<Student> getStudentList(String filePath) throws EncryptedDocumentException, IOException {
        // initializing variables
        File file = new File(filePath);

        FileInputStream fis = null;
        XSSFWorkbook wb = null;
        ArrayList<Student> studentList = new ArrayList<>();
        
        // try catch to ensure that the spreadsheet is not empty (it is necessary for the program to work)
        try {
            fis = new FileInputStream(file);
            wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheetAt(0);
            // a map is kept to ensure that the same student does not appear mutliple times
            Map<Integer, Student> studentMap = new HashMap<>();
        
            // variables for edge case checking
            boolean firstLine = true;
            boolean isCoop = false;
            boolean isCareers = false;
            // iterate through each row
            for(Row row : sheet) {
                // the first line contains titles so we skip it
                if(firstLine) {
                    firstLine = false;
                    continue;
                }
                
                int cellNum = 0; // to keep track of current cell
                // to help check if a student is already added in the list or not (makes sure to not add the same student again)
                int currentStudentNum = (int)row.getCell(0).getNumericCellValue(); // get Student ID
                Student newStudent;
                
                // if student exists, do not add again
                if(studentMap.containsKey(currentStudentNum)) {
                    newStudent = studentMap.get(currentStudentNum);
                }
                else {
                    newStudent = new Student();
                    newStudent.setStudentNumber(currentStudentNum);
                    studentMap.put(currentStudentNum, newStudent);
                }

                // init a course object
                Course newCourse = new Course();
                // iterate through the cells in each row
                for(Cell cell : row) {
                    switch(cellNum) {
                        case 1: // get Student Last Name
                            newStudent.setName(cell.getStringCellValue());
                            break;
                        case 2: // get Student First Name and concatenate to Last Name
                            newStudent.setName(cell.getStringCellValue() + " " + newStudent.getName());
                            break;
                        case 3: // get gender
                            newStudent.setGender(cell.getStringCellValue());
                            break;
                        case 4: // get grade
                            newStudent.setGrade((int)cell.getNumericCellValue());
                            break;
                        case 6: // get semester number
                            newCourse.setSemester((int)(cell.getStringCellValue().charAt(1)-'0'));
                            break;
                        case 7:  // get Block number
                            String tempSched = cell.getStringCellValue();
                            if(tempSched.length() == 15) {
                                newCourse.setBlock((int)(tempSched.charAt(5)-'A'+1));
                            }
                            else {
                                newCourse.setBlock((int)(tempSched.charAt(10)-'A'+1)); // edge case for coop since it is formatted differently
                                isCoop = true;
                            }
                            break;
                        case 8: // get course code
                            String tempName = cell.getStringCellValue();
                            newCourse.setName(tempName);
                            if(tempName.contains("GLC2O")) { // edge case if the course is Careers (cannot display both Civics and Careers at once, so we chose to only display Civics)
                                isCareers = true;
                            }
                            break;
                        case 9: // get teacher
                            newCourse.setTeacher(cell.getStringCellValue());
                            break;
                        case 10: // get room number
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
                // check if the course is careers or coop
                if(!isCareers) {
                    newStudent.addCourse(newCourse);
                }
                if(isCoop) {
                    newStudent.addCourse(newCourse);
                    newStudent.addCourse(new Course(newCourse.getSemester(), newCourse.getBlock()+1, newCourse.getName(), newCourse.getTeacher(), newCourse.getRoom()));
                }
                isCareers = false;
                isCoop = false;
                // sort the students courses from increasing sem and increasing block number
                newStudent.sortCourses();
            }
            // add students to the list (which will be returned)
            studentList.addAll(studentMap.values());
        }
        // catch to make sure the spreadsheet is not empty or does not exist
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
