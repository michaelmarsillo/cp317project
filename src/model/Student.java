//
package model;

public class Student {
    private String studentId;
    private String studentName;
    
    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }
    
    public String getStudentId() { 
        return studentId; 
    }
    public String getStudentName() { 
        return studentName; 
    }
    
    @Override
    public String toString() {
        return "Student{id='" + studentId + "', name='" + studentName + "'}";
    }
}
