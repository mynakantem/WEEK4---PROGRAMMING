import java.io.*;

class FileReadWrite {
    public static void main(String[] args) {
        String sourceFile = "input.txt";
        String destinationFile = "output.txt";
        File inputFile = new File(sourceFile);
        if (!inputFile.exists()) {
            System.out.println("Source file '" + sourceFile + "' does not exist.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully to '" + destinationFile + "'.");

        } catch (IOException e) {
            System.out.println("An error occurred during file operation:");
            e.printStackTrace();
        }
    }
}
