package component;

import java.io.File;

import javax.swing.JFileChooser;

public class FileComponent {
    private JFileChooser fileChooser;
    
    public FileComponent() {
        this.fileChooser = new JFileChooser();
        this.fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    }
    
    public File selectInputFile(String title) {
        fileChooser.setDialogTitle(title);
        int result = fileChooser.showOpenDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }
    
    public File selectOutputFile(String title) {
        fileChooser.setDialogTitle(title);
        int result = fileChooser.showSaveDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            // Ensure .csv extension
            if (!file.getName().toLowerCase().endsWith(".csv")) {
                file = new File(file.getAbsolutePath() + ".csv");
            }
            return file;
        }
        return null;
    }
}
