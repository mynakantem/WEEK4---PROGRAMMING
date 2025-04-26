import java.io.*;

class ReadUserInputToFile {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                FileWriter writer = new FileWriter("userDetails.txt")
        ) {
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            writer.write("User Details:\n");
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");

            System.out.println("Information saved successfully into userDetails.txt!");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
