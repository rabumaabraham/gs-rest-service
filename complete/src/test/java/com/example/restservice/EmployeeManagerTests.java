package com.example.restservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeManagerTests {

    @BeforeEach
    public void setUp() {
        // Reset the employees list before each test
        Employees employees = EmployeeManager.getEmployees();
        employees.getEmployees().clear();
        
        // Re-add the default employees
        employees.addEmployee(new Employee("EMP001", "John", "Doe", "john.doe@company.com", "Software Engineer"));
        employees.addEmployee(new Employee("EMP002", "Jane", "Smith", "jane.smith@company.com", "Product Manager"));
        employees.addEmployee(new Employee("EMP003", "Michael", "Johnson", "michael.johnson@company.com", "Data Scientist"));
        employees.addEmployee(new Employee("EMP004", "Sarah", "Williams", "sarah.williams@company.com", "UX Designer"));
    }

    @Test
    public void getEmployeesShouldReturnEmployeesList() {
        Employees employees = EmployeeManager.getEmployees();
        
        assertNotNull(employees);
        assertNotNull(employees.getEmployees());
        assertEquals(4, employees.getEmployees().size());
        
        Employee firstEmployee = employees.getEmployees().get(0);
        assertEquals("EMP001", firstEmployee.getEmployee_id());
        assertEquals("John", firstEmployee.getFirst_name());
        assertEquals("Doe", firstEmployee.getLast_name());
        assertEquals("john.doe@company.com", firstEmployee.getEmail());
        assertEquals("Software Engineer", firstEmployee.getTitle());
    }

    @Test
    public void addEmployeeShouldAddNewEmployeeToList() {
        Employee newEmployee = new Employee("EMP005", "Alice", "Johnson", "alice.johnson@company.com", "DevOps Engineer");
        
        EmployeeManager.addEmployee(newEmployee);
        
        Employees employees = EmployeeManager.getEmployees();
        assertEquals(5, employees.getEmployees().size());
        
        Employee addedEmployee = employees.getEmployees().get(4);
        assertEquals("EMP005", addedEmployee.getEmployee_id());
        assertEquals("Alice", addedEmployee.getFirst_name());
        assertEquals("Johnson", addedEmployee.getLast_name());
        assertEquals("alice.johnson@company.com", addedEmployee.getEmail());
        assertEquals("DevOps Engineer", addedEmployee.getTitle());
    }

    @Test
    public void addMultipleEmployeesShouldAddAllEmployees() {
        Employee employee1 = new Employee("EMP005", "Alice", "Johnson", "alice.johnson@company.com", "DevOps Engineer");
        Employee employee2 = new Employee("EMP006", "Bob", "Wilson", "bob.wilson@company.com", "QA Engineer");
        
        EmployeeManager.addEmployee(employee1);
        EmployeeManager.addEmployee(employee2);
        
        Employees employees = EmployeeManager.getEmployees();
        assertEquals(6, employees.getEmployees().size());
        
        // Check the last two employees
        Employee addedEmployee1 = employees.getEmployees().get(4);
        assertEquals("EMP005", addedEmployee1.getEmployee_id());
        assertEquals("Alice", addedEmployee1.getFirst_name());
        
        Employee addedEmployee2 = employees.getEmployees().get(5);
        assertEquals("EMP006", addedEmployee2.getEmployee_id());
        assertEquals("Bob", addedEmployee2.getFirst_name());
    }
}

