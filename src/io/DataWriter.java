package io;

import java.io.File;
import java.io.IOException;
import java.util.List;

// Abstract base class for all data writers
public abstract class DataWriter<T> {
    public abstract void writeData(List<T> data, File file) throws IOException;
    
    // Template method pattern - common validation logic
    protected void validateOutput(List<T> data, File file) throws IOException {
        if (data == null || data.isEmpty()) {
            throw new IOException("No data to write");
        }
        
        if (file == null) {
            throw new IOException("Output file cannot be null");
        }
        
        // Create parent directories if they don't exist
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            if (!parentDir.mkdirs()) {
                throw new IOException("Cannot create output directory: " + parentDir.getAbsolutePath());
            }
        }
    }
}