package com.example.demo.repository;

import com.example.demo.domain.Employee;
import com.example.demo.mapper.Mapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class Repository {

    private final JdbcTemplate jdbcTemplate;
    private final Mapper mapper = new Mapper();

    public Repository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Employee getEmployeeRepository(int id){
        final String sql = "SELECT * FROM employees WHERE employee.id =" +id;
        try {
            return jdbcTemplate.queryForObject(sql,mapper);
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public Integer addEmployeeRepository(Employee employee){
        final String sql = "INSERT INTO employees (name, email, department) VALUES (?,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, employee.getName());
                ps.setString(2, employee.getEmail());
                ps.setString(3, employee.getDepartment());
                return ps;
            }
        }, keyHolder);
        if (keyHolder.getKey()!=null){
            return keyHolder.getKey().intValue();
        } else {
            return null;
        }

        }

    public List<Employee> getEmployeesRepisitory(){
        final String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, mapper);
    }

    public void updateEmployeeRepository(Employee employee, int id){
        final String sql = "UPDATE employees SET name = ?, email = ?, department=? WHERE id=?";
        jdbcTemplate.update(sql, employee.getName(), employee.getEmail(), employee.getDepartment(), id);
    }

    public void deleteEmployeeRepository(int id){
        final String sql = "DELETE FROM employees WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


}
