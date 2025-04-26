import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Department=" + department + ", Salary=" + salary + "]";
    }
}

class EmployeeSerializationDemo {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(101, "Alice", "IT", 60000));
        employeeList.add(new Employee(102, "Bob", "HR", 50000));
        employeeList.add(new Employee(103, "Charlie", "Finance", 55000));

        String filename = "employees.ser";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employeeList);
            System.out.println("Employees have been serialized to " + filename);
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Employee> deserializedList = (List<Employee>) ois.readObject();

            System.out.println("\nDeserialized Employees:");
            for (Employee emp : deserializedList) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
