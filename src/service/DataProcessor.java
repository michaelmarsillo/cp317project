package service;

import model.*;
import java.util.*;

// Service component for data processing
public class DataProcessor {
    private final GradeCalculator calculator;
    
    public DataProcessor() {
        this.calculator = new GradeCalculator();
    }
    
    public List<StudentGrade> processGrades(List<Student> students, List<Course> courses) {
        if (students == null || courses == null) {
            throw new IllegalArgumentException("Students and courses lists cannot be null");
        }
        
        // Create lookup map for students
        Map<String, Student> studentMap = new HashMap<>();
        for (Student student : students) {
            studentMap.put(student.getStudentId(), student);
        }
        
        List<StudentGrade> grades = new ArrayList<>();
        
        // Process each course
        for (Course course : courses) {
            Student student = studentMap.get(course.getStudentId());
            if (student != null) {
                double finalGrade = calculator.calculateFinalGrade(course);
                grades.add(new StudentGrade(
                    student.getStudentId(),
                    student.getStudentName(),
                    course.getCourseCode(),
                    finalGrade
                ));
            }
        }
        
        return grades;
    }
}