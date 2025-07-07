package io;

import model.StudentGrade;
import java.io.*;
import java.util.*;

// Inheritance - extends DataWriter
public class GradeWriter extends DataWriter<StudentGrade> {
    @Override
    public void writeData(List<StudentGrade> grades, File file) throws IOException {
        validateOutput(grades, file);
        
        // Sort by student ID as required
        List<StudentGrade> sortedGrades = new ArrayList<>(grades);
        sortedGrades.sort(Comparator.comparing(StudentGrade::getStudentId));
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // Write header
            writer.write("Student ID,Student Name,Course Code,Final Grade");
            writer.newLine();
            
            // Write data
            for (StudentGrade grade : sortedGrades) {
                writer.write(String.format("%s,%s,%s,%.1f",
                    grade.getStudentId(),
                    grade.getStudentName(),
                    grade.getCourseCode(),
                    grade.getFinalGrade()));
                writer.newLine();
            }
        }
    }
}