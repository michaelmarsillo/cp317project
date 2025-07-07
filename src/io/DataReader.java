package io;

import model.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

// Abstraction - Abstract base class for all data readers
public abstract class DataReader<T> {
    public abstract List<T> readData(File file) throws IOException;
    
    // Template method pattern - common validation logic
    protected void validateFile(File file) throws IOException {
        if (file == null) {
            throw new IOException("File cannot be null");
        }
        if (!file.exists()) {
            throw new IOException("File does not exist: " + file.getAbsolutePath());
        }
        if (!file.canRead()) {
            throw new IOException("Cannot read file: " + file.getAbsolutePath());
        }
    }
    
    // Defensive programming - validate line format
    protected void validateLineFormat(String line, int expectedParts, int lineNumber) throws IOException {
        if (line == null || line.trim().isEmpty()) {
            throw new IOException("Empty line at line number: " + lineNumber);
        }
        
        String[] parts = line.split(",");
        if (parts.length < expectedParts) {
            throw new IOException("Invalid format at line " + lineNumber + ": expected " + 
                                expectedParts + " parts, got " + parts.length);
        }
    }
}