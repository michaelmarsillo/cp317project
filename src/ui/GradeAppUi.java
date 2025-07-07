package ui;

import component.UIComponent;
import controller.GradeAppController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Main UI uses composition with controller
public class GradeAppUi extends JFrame {
    private final GradeAppController controller;
    
    public GradeAppUi() {
        super("Grade Calculator Application");
        this.controller = new GradeAppController();
        initializeUI();
    }
    
    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        
        // Create main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Title
        JLabel titleLabel = UIComponent.createLabel("Grade Calculator", 
                                                   new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        
        // Instructions
        JTextArea instructions = new JTextArea();
        instructions.setText(
            "Instructions:\n" +
            "1. Click 'Process Grades' to start\n" +
            "2. Select the student file (NameFile.txt)\n" +
            "3. Select the course file (CourseFile.txt)\n" +
            "4. Choose where to save the output\n" +
            "5. The application will calculate and save final grades\n\n" +
            "Grade Calculation:\n" +
            "- Each test: 20% (3 tests total = 60%)\n" +
            "- Final exam: 40%\n" +
            "- Output sorted by Student ID"
        );
        instructions.setEditable(false);
        instructions.setBackground(getBackground());
        instructions.setFont(new Font("Arial", Font.PLAIN, 12));
        instructions.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JScrollPane scrollPane = new JScrollPane(instructions);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        JButton processButton = UIComponent.createButton("Process Grades", 
                                                        new Dimension(150, 40));
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.processGrades();
            }
        });
        
        JButton exitButton = UIComponent.createButton("Exit", 
                                                     new Dimension(100, 40));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        buttonPanel.add(processButton);
        buttonPanel.add(exitButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    public static void main(String[] args) {
        // Set look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
        } catch (Exception e) {
            // Use default look and feel
        }
        
        // Start application
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GradeAppUi().setVisible(true);
            }
        });
    }
}