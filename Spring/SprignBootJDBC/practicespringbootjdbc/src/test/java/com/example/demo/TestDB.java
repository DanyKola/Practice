package com.example.demo;
import com.example.demo.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)

public class TestDB {

    private final String sqlInsertEmployee = "INSERT INTO employees (name, email, department) VALUES (?,?,?)";


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void createEmployee(){
        Employee employee = new Employee();
        employee.setName("Václav Mrkvièka");
        employee.setEmail("mrkvicka@mrkvicka.cz");
        employee.setDepartment("IT");

    jdbcTemplate.update(new PreparedStatementCreator() {
        @Override
        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
            PreparedStatement ps =con.prepareStatement(sqlInsertEmployee);

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getDepartment());
            return ps;
        }
    });
    }

}
