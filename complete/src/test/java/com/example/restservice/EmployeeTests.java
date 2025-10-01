package com.example.restservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTests {

    @Test
    public void employeeDefaultConstructorShouldCreateEmptyEmployee() {
        Employee employee = new Employee();
        
        assertNotNull(employee);
        assertNull(employee.getEmployee_id());
        assertNull(employee.getFirst_name());
        assertNull(employee.getLast_name());
        assertNull(employee.getEmail());
        assertNull(employee.getTitle());
    }

    @Test
    public void employeeParameterizedConstructorShouldSetAllFields() {
        Employee employee = new Employee("EMP001", "John", "Doe", "john.doe@company.com", "Software Engineer");
        
        assertEquals("EMP001", employee.getEmployee_id());
        assertEquals("John", employee.getFirst_name());
        assertEquals("Doe", employee.getLast_name());
        assertEquals("john.doe@company.com", employee.getEmail());
        assertEquals("Software Engineer", employee.getTitle());
    }

    @Test
    public void employeeSettersShouldUpdateFields() {
        Employee employee = new Employee();
        
        employee.setEmployee_id("EMP002");
        employee.setFirst_name("Jane");
        employee.setLast_name("Smith");
        employee.setEmail("jane.smith@company.com");
        employee.setTitle("Product Manager");
        
        assertEquals("EMP002", employee.getEmployee_id());
        assertEquals("Jane", employee.getFirst_name());
        assertEquals("Smith", employee.getLast_name());
        assertEquals("jane.smith@company.com", employee.getEmail());
        assertEquals("Product Manager", employee.getTitle());
    }

    @Test
    public void employeeGettersShouldReturnCorrectValues() {
        Employee employee = new Employee("EMP003", "Michael", "Johnson", "michael.johnson@company.com", "Data Scientist");
        
        assertEquals("EMP003", employee.getEmployee_id());
        assertEquals("Michael", employee.getFirst_name());
        assertEquals("Johnson", employee.getLast_name());
        assertEquals("michael.johnson@company.com", employee.getEmail());
        assertEquals("Data Scientist", employee.getTitle());
    }

    @Test
    public void employeeWithNullValuesShouldHandleCorrectly() {
        Employee employee = new Employee(null, null, null, null, null);
        
        assertNull(employee.getEmployee_id());
        assertNull(employee.getFirst_name());
        assertNull(employee.getLast_name());
        assertNull(employee.getEmail());
        assertNull(employee.getTitle());
    }

    @Test
    public void employeeWithEmptyStringsShouldHandleCorrectly() {
        Employee employee = new Employee("", "", "", "", "");
        
        assertEquals("", employee.getEmployee_id());
        assertEquals("", employee.getFirst_name());
        assertEquals("", employee.getLast_name());
        assertEquals("", employee.getEmail());
        assertEquals("", employee.getTitle());
    }
}

