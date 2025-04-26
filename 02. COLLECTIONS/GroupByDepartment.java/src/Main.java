import java.util.*;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

class GroupByDepartment {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR"),
                new Employee("David", "Finance"),
                new Employee("Eve", "IT")
        );

        Map<String, List<Employee>> groupedByDept = new HashMap<>();

        for (Employee emp : employees) {
            String dept = emp.getDepartment();

            groupedByDept.putIfAbsent(dept, new ArrayList<>());

            groupedByDept.get(dept).add(emp);
        }

        for (String dept : groupedByDept.keySet()) {
            System.out.println(dept + ": " + groupedByDept.get(dept));
        }
    }
}
