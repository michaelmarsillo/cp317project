import io.*;
import model.*;
import service.*;
import java.io.File;
import java.util.List;

/**
 * Simple command-line grade calculator program.
 * Reads CourseFile.txt and NameFile.txt, calculates grades, 
 * and outputs results sorted by student ID to GradeOutput.csv
 */
public class GradeCalculatorMain {
    
    public static void main(String[] args) {
        try {
            System.out.println("Grade Calculator - Starting...");
            
            // Initialize components
            StudentReader studentReader = new StudentReader();
            CourseReader courseReader = new CourseReader();
            GradeWriter gradeWriter = new GradeWriter();
            DataProcessor dataProcessor = new DataProcessor();
            
            // Define file paths
            File studentFile = new File("NameFile.txt");
            File courseFile = new File("CourseFile.txt");
            File outputFile = new File("GradeOutput.csv");
            
            // Read student data
            System.out.println("Reading student data from NameFile.txt...");
            List<Student> students = studentReader.readData(studentFile);
            System.out.println("Loaded " + students.size() + " students");
            
            // Read course data
            System.out.println("Reading course data from CourseFile.txt...");
            List<Course> courses = courseReader.readData(courseFile);
            System.out.println("Loaded " + courses.size() + " course records");
            
            // Process grades
            System.out.println("Processing grades...");
            List<StudentGrade> grades = dataProcessor.processGrades(students, courses);
            System.out.println("Processed " + grades.size() + " grade records");
            
            if (grades.isEmpty()) {
                System.out.println("Warning: No grades to process. Check if student IDs match between files.");
                return;
            }
            
            // Write results (automatically sorted by student ID)
            System.out.println("Writing results to GradeOutput.csv...");
            gradeWriter.writeData(grades, outputFile);
            
            System.out.println("Grade processing completed successfully!");
            System.out.println("Results saved to: " + outputFile.getName());
            System.out.println("Total records processed: " + grades.size());
            
        } catch (Exception e) {
            System.err.println("Error processing grades: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
} 