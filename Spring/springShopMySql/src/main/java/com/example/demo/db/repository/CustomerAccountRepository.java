package com.example.demo.db.repository;

import com.example.demo.domain.CustomerAccount;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class CustomerAccountRepository {

    JdbcTemplate jdbcTemplate;

    public void add(CustomerAccount customerAccount){
        final String sql = "insert into customer_account (customer_id, money) values (?,?)";
        jdbcTemplate.update(sql,customerAccount.getCustomerId(), customerAccount.getMoney());

    }
    @Nullable
    public Double getMoney (int customerId){
        final  String sql = "SELECT money FROM customer_account WHERE customer_is = "+ customerId;
        try {
            return jdbcTemplate.queryForObject(sql, Double.class);
        } catch (DataAccessException e){
            return null;
        }
    }

    public void setMoney(int customerId, double money){
        final String sql = "UPDATE customer_account SET money = ? WHERE customer_id =? ";
        jdbcTemplate.update(sql, money, customerId);
    }

}
