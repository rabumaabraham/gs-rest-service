package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private static Employees employees;

    static {
        employees = new Employees();
        
        // Hard-coded employees
        employees.addEmployee(new Employee("EMP001", "John", "Doe", "john.doe@company.com", "Software Engineer"));
        employees.addEmployee(new Employee("EMP002", "Jane", "Smith", "jane.smith@company.com", "Product Manager"));
        employees.addEmployee(new Employee("EMP003", "Michael", "Johnson", "michael.johnson@company.com", "Data Scientist"));
        employees.addEmployee(new Employee("EMP004", "Sarah", "Williams", "sarah.williams@company.com", "UX Designer"));
    }

    public static Employees getEmployees() {
        return employees;
    }

    public static void addEmployee(Employee employee) {
        employees.addEmployee(employee);
    }
}

