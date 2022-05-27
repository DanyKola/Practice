package com.example.demo.service;

import com.example.demo.domain.Employee;

import java.util.List;

public interface ServiceEm {

    List<Employee> getEmployees();

    Employee getEmployee(int id);

    Integer addEmployee(Employee employee);

    void deleteEmployee(int id);

    void updateEmployee(Employee employee, int id);
}
