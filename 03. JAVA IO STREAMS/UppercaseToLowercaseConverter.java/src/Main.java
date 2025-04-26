import java.io.*;

class UppercaseToLowercaseConverter {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }

            System.out.println("File converted successfully: All text is now lowercase!");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
