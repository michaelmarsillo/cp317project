package io;

import model.StudentGrade;
import java.io.*;
import java.util.*;

// extends DataWriter
public class GradeWriter extends DataWriter<StudentGrade> {
    @Override
    public void writeData(List<StudentGrade> grades, File file) throws IOException {
        validateOutput(grades, file);
        
        // Sort by student ID as required
        List<StudentGrade> sortedGrades = new ArrayList<>(grades);
        sortedGrades.sort(Comparator.comparing(StudentGrade::getStudentId));
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // Write title and header
            writer.write("=".repeat(80));
            writer.newLine();
            writer.write(String.format("%30s", "GRADE CALCULATION RESULTS"));
            writer.newLine();
            writer.write("=".repeat(80));
            writer.newLine();
            writer.newLine();
            
            // Write formatted header with proper spacing
            writer.write(String.format("%-12s | %-25s | %-12s | %-12s", 
            "Student ID", "Student Name", "Course Code", "Final Grade"));
            writer.newLine();
            writer.write("-".repeat(80));
            writer.newLine();
            
            // Write data with consistent formatting
            for (StudentGrade grade : sortedGrades) {
                writer.write(String.format("%-12s | %-25s | %-12s | %8.1f%%",
                    grade.getStudentId(),
                    grade.getStudentName(),
                    grade.getCourseCode(),
                    grade.getFinalGrade()));
                writer.newLine();
            }
            
            // Write footer
            writer.newLine();
            writer.write("-".repeat(80));
            writer.newLine();
            writer.write(String.format("Total Records Processed: %d", sortedGrades.size()));
            writer.newLine();
            writer.write("=".repeat(80));
        }
    }
}