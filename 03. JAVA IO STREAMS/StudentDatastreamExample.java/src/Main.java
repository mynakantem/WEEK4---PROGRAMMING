import java.io.*;

class StudentDataStreamExample {
    public static void main(String[] args) {
        String filename = "students.dat";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {

            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(8.7);

            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(9.1);

            dos.writeInt(103);
            dos.writeUTF("Charlie");
            dos.writeDouble(7.9);

            System.out.println("Student details written successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Reading student details...");

        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            while (dis.available() > 0) {
                int rollNo = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll No: " + rollNo + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
