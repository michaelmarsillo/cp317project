package service;

import model.Course;

// Encapsulation - Service component for grade calculation
public class GradeCalculator {
    private static final double TEST_WEIGHT = 0.20; // 20% each
    private static final double FINAL_WEIGHT = 0.40; // 40%
    
    public double calculateFinalGrade(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        
        double testAverage = (course.getTest1() + course.getTest2() + course.getTest3()) / 3.0;
        double finalGrade = (testAverage * TEST_WEIGHT * 3) + (course.getFinalExam() * FINAL_WEIGHT);
        
        // Round to one decimal place
        return Math.round(finalGrade * 10.0) / 10.0;
    }
    
    public double getTestWeight() { return TEST_WEIGHT; }
    public double getFinalWeight() { return FINAL_WEIGHT; }
}