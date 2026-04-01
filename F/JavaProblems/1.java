package JavaProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemOne {

    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee("Alice", 50000));
        list.add(new Employee("bob", 70000));
        list.add(new Employee("rob", 40000));
        list.add(new Employee("john", 10000));

        // Melakukan proses filtering/sorting menggunakan Stream API
        List<Employee> sortedEmp = list
            .stream() // [1] Ubah list ke stream
            // Mengurutkan employee berdasarkan nama
            .sorted((e1, e2) -> e1.getName().compareTo(e2.getName())) // [2] & [3]
            // Mengumpulkan hasil akhir
            .collect(Collectors.toList()); // [4] & [5]

        for (Employee e : sortedEmp) {
            System.out.println(e);
        }
    }
}

// Asumsikan class Employee sudah memiliki getter getName() dan getSalary()
class Employee {

    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + "}";
    }
}
