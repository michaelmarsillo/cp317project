package model;

// Combines student info with calculated final grade for a specific course.

public class StudentGrade {
    private String studentId;
    private String studentName;
    private String courseCode;
    private double finalGrade;
    
    //Student Grade constructor
    public StudentGrade(String studentId, String studentName, String courseCode, double finalGrade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseCode = courseCode;
        this.finalGrade = finalGrade;
    }
    
    public String getStudentId() { 
        return studentId; 
    }
    public String getStudentName() { 
        return studentName; 
    }
    public String getCourseCode() { 
        return courseCode; 
    }
    public double getFinalGrade() { 
        return finalGrade; 
    }
    
    @Override
    public String toString() {
        return String.format("StudentGrade{id='%s', name='%s', course='%s', grade=%.1f}", 
                           studentId, studentName, courseCode, finalGrade);
    }
}
