package model;

public class Course {
    private String studentId;
    private String courseCode;
    private double test1;
    private double test2;
    private double test3;
    private double finalExam;
    
    public Course(String studentId, String courseCode, double test1, double test2, double test3, double finalExam) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.test1 = test1;
        this.test2 = test2;
        this.test3 = test3;
        this.finalExam = finalExam;
    }
    
    public String getStudentId() { return studentId; }
    public String getCourseCode() { return courseCode; }
    public double getTest1() { return test1; }
    public double getTest2() { return test2; }
    public double getTest3() { return test3; }
    public double getFinalExam() { return finalExam; }
    
    @Override
    public String toString() {
        return "Course{studentId='" + studentId + "', courseCode='" + courseCode + "'}";
    }
}
