package SpareLinkPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileMemoryManager {
    private static final String CONFIG_FILE = "config.properties";
    private static final String FILE_KEY = "selectedFilePath";

    // Save the selected File object to a properties file
    public static void saveFile(File file) {
        if (file != null) {
            Properties properties = new Properties();
            properties.setProperty(FILE_KEY, file.getAbsolutePath());

            try (FileOutputStream out = new FileOutputStream(CONFIG_FILE)) {
                properties.store(out, "Selected File Path");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Load the saved File object from the properties file
    public static File loadFile() {
        Properties properties = new Properties();
        try (FileInputStream in = new FileInputStream(CONFIG_FILE)) {
            properties.load(in);
            String filePath = properties.getProperty(FILE_KEY);
            if (filePath != null) {
                return new File(filePath);
            }
        } catch (FileNotFoundException e) {
            // Handle the case where the file does not exist
            System.out.println("Configuration file not found. It will be created when saving a file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Clear the saved file path (optional if needed)
    public static void clearFile() {
        File file = new File(CONFIG_FILE);
        if (file.exists()) {
            file.delete();
        }
    }
}
