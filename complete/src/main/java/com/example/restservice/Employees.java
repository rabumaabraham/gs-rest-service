package com.example.restservice;

import java.util.List;
import java.util.ArrayList;

public class Employees {
    private List<Employee> employees;

    public Employees() {
        this.employees = new ArrayList<>();
    }

    public Employees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
}

