package com.example.restservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeesTests {

    private Employees employees;
    private Employee employee1;
    private Employee employee2;

    @BeforeEach
    public void setUp() {
        employees = new Employees();
        employee1 = new Employee("EMP001", "John", "Doe", "john.doe@company.com", "Software Engineer");
        employee2 = new Employee("EMP002", "Jane", "Smith", "jane.smith@company.com", "Product Manager");
    }

    @Test
    public void employeesDefaultConstructorShouldCreateEmptyList() {
        Employees employees = new Employees();
        
        assertNotNull(employees);
        assertNotNull(employees.getEmployees());
        assertTrue(employees.getEmployees().isEmpty());
    }

    @Test
    public void employeesParameterizedConstructorShouldSetEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        
        Employees employees = new Employees(employeeList);
        
        assertNotNull(employees);
        assertNotNull(employees.getEmployees());
        assertEquals(2, employees.getEmployees().size());
        assertEquals(employee1, employees.getEmployees().get(0));
        assertEquals(employee2, employees.getEmployees().get(1));
    }

    @Test
    public void addEmployeeShouldAddEmployeeToList() {
        employees.addEmployee(employee1);
        
        assertEquals(1, employees.getEmployees().size());
        assertEquals(employee1, employees.getEmployees().get(0));
    }

    @Test
    public void addMultipleEmployeesShouldAddAllEmployees() {
        employees.addEmployee(employee1);
        employees.addEmployee(employee2);
        
        assertEquals(2, employees.getEmployees().size());
        assertEquals(employee1, employees.getEmployees().get(0));
        assertEquals(employee2, employees.getEmployees().get(1));
    }

    @Test
    public void setEmployeesShouldReplaceEmployeeList() {
        employees.addEmployee(employee1);
        
        List<Employee> newEmployeeList = new ArrayList<>();
        newEmployeeList.add(employee2);
        
        employees.setEmployees(newEmployeeList);
        
        assertEquals(1, employees.getEmployees().size());
        assertEquals(employee2, employees.getEmployees().get(0));
    }

    @Test
    public void getEmployeesShouldReturnEmployeeList() {
        employees.addEmployee(employee1);
        employees.addEmployee(employee2);
        
        List<Employee> employeeList = employees.getEmployees();
        
        assertNotNull(employeeList);
        assertEquals(2, employeeList.size());
        assertEquals(employee1, employeeList.get(0));
        assertEquals(employee2, employeeList.get(1));
    }

    @Test
    public void employeesWithNullListShouldHandleCorrectly() {
        Employees employees = new Employees(null);
        
        assertNotNull(employees);
        assertNull(employees.getEmployees());
    }

    @Test
    public void setEmployeesWithNullShouldHandleCorrectly() {
        employees.addEmployee(employee1);
        employees.setEmployees(null);
        
        assertNull(employees.getEmployees());
    }
}

