# Grade Calculator

A Java Swing application that calculates final grades for students based on test scores and final exam results.

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

## How it Works

- Reads student data from a CSV file
- Reads course grades from a CSV file  
- Calculates final grades using: **Tests (60%) + Final Exam (40%)**
- Outputs results sorted by Student ID

## How to Run

2. Run: `java ui/GradeAppUi`
3. Use the GUI to select your input files and save location

## File Format

**NameFile.txt:**
```
StudentID,StudentName
12345,John Smith
23456,Jane Doe
```

**CourseFile.txt:**
```
StudentID,CourseCode,Test1,Test2,Test3,FinalExam
12345,CS101,85,90,78,88
23456,CS101,92,87,94,91
```

## Grade Calculation

- Each test: 20% (3 tests = 60% total)
- Final exam: 40%
- Final grade = (Test1 + Test2 + Test3) × 20% + FinalExam × 40%
