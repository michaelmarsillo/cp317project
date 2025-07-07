package controller;

import component.*;
import io.*;
import model.*;
import service.*;
import java.io.File;
import java.util.List;

// Encapsulation - Controller component that orchestrates the application
public class GradeAppController {
    private final StudentReader studentReader;
    private final CourseReader courseReader;
    private final GradeWriter gradeWriter;
    private final DataProcessor dataProcessor;
    private final FileComponent fileComponent;
    
    public GradeAppController() {
        this.studentReader = new StudentReader();
        this.courseReader = new CourseReader();
        this.gradeWriter = new GradeWriter();
        this.dataProcessor = new DataProcessor();
        this.fileComponent = new FileComponent();
    }
    
    public void processGrades() {
        try {
            // Select input files
            File studentFile = fileComponent.selectInputFile("Select Student File (NameFile.txt)");
            if (studentFile == null) {
                UIComponent.showWarning("No student file selected.");
                return;
            }
            
            File courseFile = fileComponent.selectInputFile("Select Course File (CourseFile.txt)");
            if (courseFile == null) {
                UIComponent.showWarning("No course file selected.");
                return;
            }
            
            // Read data
            UIComponent.showInfo("Reading student data...");
            List<Student> students = studentReader.readData(studentFile);
            
            UIComponent.showInfo("Reading course data...");
            List<Course> courses = courseReader.readData(courseFile);
            
            // Process grades
            UIComponent.showInfo("Processing grades...");
            List<StudentGrade> grades = dataProcessor.processGrades(students, courses);
            
            if (grades.isEmpty()) {
                UIComponent.showWarning("No grades to process. Check if student IDs match between files.");
                return;
            }
            
            // Select output file
            File outputFile = fileComponent.selectOutputFile("Save Grade Report");
            if (outputFile == null) {
                UIComponent.showWarning("No output file selected.");
                return;
            }
            
            // Write results
            UIComponent.showInfo("Writing results...");
            gradeWriter.writeData(grades, outputFile);
            
            UIComponent.showInfo("Grade processing completed successfully!\n" +
                               "Processed " + grades.size() + " grade records.\n" +
                               "Output saved to: " + outputFile.getName());
            
        } catch (Exception e) {
            UIComponent.showError("Error processing grades: " + e.getMessage());
        }
    }
}