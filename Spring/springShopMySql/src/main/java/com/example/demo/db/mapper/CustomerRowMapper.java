package com.example.demo.db.mapper;

import com.example.demo.domain.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setName(rs.getString("name"));
        customer.setSurname(rs.getString("surname"));
        customer.setEmail(rs.getString("email"));
        customer.setAddress(rs.getString("address"));
        customer.setAge(rs.getObject("age")==null?null :rs.getInt("age"));
        customer.setPhoneNumber(rs.getString("phone_number"));
        return customer;
    }

}
