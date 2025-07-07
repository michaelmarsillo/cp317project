package io;

import model.Course;
import java.io.*;
import java.util.*;

// Inheritance - extends DataReader
public class CourseReader extends DataReader<Course> {
    @Override
    public List<Course> readData(File file) throws IOException {
        validateFile(file);
        
        List<Course> courses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;
            
            while ((line = br.readLine()) != null) {
                lineNumber++;
                try {
                    validateLineFormat(line, 6, lineNumber);
                    
                    String[] parts = line.split(",");
                    String studentId = parts[0].trim();
                    String courseCode = parts[1].trim();
                    
                    // Defensive programming - validate required fields
                    if (studentId.isEmpty() || courseCode.isEmpty()) {
                        throw new IOException("Student ID and course code cannot be empty at line " + lineNumber);
                    }
                    
                    double test1 = parseGrade(parts[2].trim(), "Test 1", lineNumber);
                    double test2 = parseGrade(parts[3].trim(), "Test 2", lineNumber);
                    double test3 = parseGrade(parts[4].trim(), "Test 3", lineNumber);
                    double finalExam = parseGrade(parts[5].trim(), "Final Exam", lineNumber);
                    
                    courses.add(new Course(studentId, courseCode, test1, test2, test3, finalExam));
                } catch (IOException e) {
                    throw e; // Re-throw IOException
                } catch (Exception e) {
                    throw new IOException("Error parsing line " + lineNumber + ": " + e.getMessage());
                }
            }
        }
        
        if (courses.isEmpty()) {
            throw new IOException("No valid course records found in file");
        }
        
        return courses;
    }
    
    private double parseGrade(String gradeStr, String fieldName, int lineNumber) throws IOException {
        try {
            double grade = Double.parseDouble(gradeStr);
            // Defensive programming - validate grade range
            if (grade < 0 || grade > 100) {
                throw new IOException("Invalid " + fieldName + " grade at line " + lineNumber + 
                                    ": " + grade + " (must be between 0 and 100)");
            }
            return grade;
        } catch (NumberFormatException e) {
            throw new IOException("Invalid " + fieldName + " grade format at line " + lineNumber + 
                                ": '" + gradeStr + "' is not a valid number");
        }
    }
}