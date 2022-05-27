package com.example.demo.service;

import com.example.demo.domain.Employee;
import com.example.demo.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServisImpl implements ServiceEm {

    private final Repository repository;

    public ServisImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> getEmployees() {
        return repository.getEmployeesRepisitory();
    }

    @Override
    public Employee getEmployee(int id) {
        return repository.getEmployeeRepository(id);
    }

    @Override
    public Integer addEmployee(Employee employee) {
        return repository.addEmployeeRepository(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        repository.deleteEmployeeRepository(id);
    }

    @Override
    public void updateEmployee(Employee employee, int id) {
        repository.updateEmployeeRepository(employee,id);
    }
}
