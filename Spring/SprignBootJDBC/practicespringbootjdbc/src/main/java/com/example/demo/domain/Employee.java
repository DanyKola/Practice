package com.example.demo.domain;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Objects;

public class Employee {
    @Nullable
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String department;

    public Employee() {
    }

    public Employee(@NonNull String name, @NonNull String email, @NonNull String department) {
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getDepartment() {
        return department;
    }

    public void setDepartment(@NonNull String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() && getName().equals(employee.getName()) && getEmail().equals(employee.getEmail()) && getDepartment().equals(employee.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getDepartment());
    }
}
