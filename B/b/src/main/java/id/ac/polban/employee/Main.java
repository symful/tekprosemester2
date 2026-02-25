package id.ac.polban.employee;

import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.EmployeeService;

public class Main {
    public static void main(String[] args) {
        Department itDept = new Department("IT");
        Department hrDept = new Department("HR");

        EmploymentType fullTime = new EmploymentType("Full Time");
        EmploymentType partTime = new EmploymentType("Part Time");

        Employee emp1 = new Employee(1, "Alice", itDept, fullTime, 5000000);
        Employee emp2 = new Employee(2, "Bob", hrDept, partTime, 3000000);

        EmployeeService service = new EmployeeService();
        service.addEmployee(emp1);
        service.addEmployee(emp2);

        System.out.println("Employee 1: " + service.getEmployee(1).getName() + 
                           ", Dept: " + service.getEmployee(1).getDepartment().getName() +
                           ", Salary: " + service.getEmployee(1).getSalary());
        
        System.out.println("Raising salary for Employee 1 by 10%...");
        service.raiseSalary(1, 10);

        System.out.println("Employee 1 New Salary: " + service.getEmployee(1).getSalary());
        
        System.out.println("Total Employees: " + Employee.getEmployeeCount());
    }
}
