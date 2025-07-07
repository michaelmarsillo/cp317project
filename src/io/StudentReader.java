package io;

import model.Student;
import java.io.*;
import java.util.*;

// Inheritance - extends DataReader
public class StudentReader extends DataReader<Student> {
    @Override
    public List<Student> readData(File file) throws IOException {
        validateFile(file);
        
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;
            
            while ((line = br.readLine()) != null) {
                lineNumber++;
                try {
                    validateLineFormat(line, 2, lineNumber);
                    
                    String[] parts = line.split(",");
                    String studentId = parts[0].trim();
                    String studentName = parts[1].trim();
                    
                    // Defensive programming - validate data
                    if (studentId.isEmpty() || studentName.isEmpty()) {
                        throw new IOException("Student ID and name cannot be empty at line " + lineNumber);
                    }
                    
                    students.add(new Student(studentId, studentName));
                } catch (IOException e) {
                    throw e; // Re-throw IOException
                } catch (Exception e) {
                    throw new IOException("Error parsing line " + lineNumber + ": " + e.getMessage());
                }
            }
        }
        
        if (students.isEmpty()) {
            throw new IOException("No valid student records found in file");
        }
        
        return students;
    }
}