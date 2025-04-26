package filecopy;

import java.io.*;

public class DummyFileCreator {
    public static void main(String[] args) {
        // ✅ Give path of a *new* file, not your project file
        String filePath = "C:\\Users\\mynak\\Desktop\\java projects\\week6\\day5\\dummy_large_file.dat";

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            // Create a 100MB dummy file
            byte[] buffer = new byte[1024]; // 1KB buffer
            for (int i = 0; i < 100 * 1024; i++) { // 100 MB = 100 * 1024 KB
                fos.write(buffer);
            }
            System.out.println("Dummy file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }
}
