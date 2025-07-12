# Grade Calculator

A Java CLI application that calculates final grades for students based on test scores and final exam results.

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

## How it Works

- Reads student data from a txt file
- Reads course grades from a txt file  
- Calculates final grades using: **Tests (60%) + Final Exam (40%)**
- Outputs results sorted by Student ID

## How to Run

2. Run From: `GradeCalculatorMain.java`
3. Use our simple terminal UI to watch the process!

## File Format

**NameFile.txt:**
```
StudentID, StudentName
12345678, John Smith
22345678, Jane Doe
```

**CourseFile.txt:**
```
StudentID, CourseCode, Test1, Test2, Test3, FinalExam
12345, CS101, 85, 90, 78, 88
23456, CS101, 92, 87, 94, 91
```

## Grade Calculation

- Each test: 20% (3 tests = 60% total)
- Final exam: 40%
- Final grade = (Test1 + Test2 + Test3) × 20% + FinalExam × 40%

## Team
Built by our group for CP317 @ [Laurier](https://wlu.ca)
- **[Michael Marsillo](https://www.linkedin.com/in/michaelmarsillo)** 
- **[Tony Taseski](https://www.linkedin.com/in/a-taseski)**
- **[Gurshan Sidhar](https://www.linkedin.com/in/gurshan-sidhar)**
- **[Sahil Minhas](https://www.linkedin.com/in/sahilminhas/)** 