package SpareLinkPackage;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SpreadsheetReader {
    public ArrayList<Student> getStudentList() throws EncryptedDocumentException, IOException {
        File file = new File("directory");
        FileInputStream fis = new FileInputStream(file);
        
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheetAt(0);
        
        ArrayList<Student> studentList = new ArrayList<Student>();
        
        boolean firstLine = true;
        int studentNum = sheet.getRow(1).getCell(0).getNumericCellValue();
        for(Row row : sheet) {
            if(firstLine) {
                firstLine = false;
                continue;
            }
            int cellNum = 0;
            Student newStudent = new Student();
            Course newCourse = new Course();
            for(Cell cell : row) {
                switch(cellNum) {
                    case(0):
                        
                        newStudent.setStudentNumber(cell.getNumericCellValue());
                        break;
                    case(2):
                        newStudent.setStudentName(cell.getStringCellValue());
                        break;
                    case(3):
                        newStudent.setStudentName(cell.getStringCellValue() + newStudent.getName());
                        break;
                    case(4):
                        newStudent.setStudentGender(cell.getStringCellValue());
                        break;
                    case(5):
                        newStudent.setStudentGrade(cell.getNumericCellValue());
                        break;
                    case(20): // term
//                        newStudent.setStudentGrade(cell.getNumericCellValue());
                        break;
                    case(21): // schedule
//                        newStudent.setStudentGrade(cell.getNumericCellValue());
                        break;
                    case(22):
                        newCourse.setCourse(cell.getStringCellValue());
                        break;
                    case(23):
                        newCourse.setTeacher(cell.getStringCellValue());
                        break;
                    case(24):
                        newCourse.setRoom(cell.getStringCellValue());
                        break;
                    
                }
                
                cellNum++;
            }
        }
    }
}