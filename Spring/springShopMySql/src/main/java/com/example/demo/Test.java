package com.example.demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class Test {

    private JdbcTemplate jdbcTemplate;

    public Test(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        //vyzkoušení
        this.jdbcTemplate.execute("select * from customer");
    }
}
