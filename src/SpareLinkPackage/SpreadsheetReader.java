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
                } else {
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
                            } else {
                                newCourse.setBlock((int)(tempSched.charAt(10)-'A'+1)); // coop
                            }
                            break;
                        case 8:
                            newCourse.setName(cell.getStringCellValue());
                            break;
                        case 9:
                            newCourse.setTeacher(cell.getStringCellValue());
                            break;
                        case 11:
                            newCourse.setRoom(cell.getStringCellValue());
                            break;
                    }
                    cellNum++;
                }
                newStudent.addCourse(newCourse);
            }
            studentList.addAll(studentMap.values());
        }
        finally {
            if (wb != null) {
                try {
                    wb.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return studentList;
    }
}
