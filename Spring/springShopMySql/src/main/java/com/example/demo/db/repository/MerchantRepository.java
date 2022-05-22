package com.example.demo.db.repository;

import com.example.demo.db.mapper.MerchantRowMapper;
import com.example.demo.domain.Merchant;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Component
public class MerchantRepository {

    private final JdbcTemplate jdbcTemplate;
    private final MerchantRowMapper merchantRowMapper = new MerchantRowMapper();


    public MerchantRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Merchant> getMerchants() {
        final String sql = "select * from merchant";
        return jdbcTemplate.query(sql, merchantRowMapper);

    }

    public Merchant getMerchant(int id) {
        final String sql = "select * from merchant where merchant.id = " + id;
        try {
            return jdbcTemplate.queryForObject(sql, merchantRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Integer addMerchant(Merchant merchant) {
        final String sql = "insert into merchant(name,email,address) values(?,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, merchant.getName());
                preparedStatement.setString(2, merchant.getEmail());
                preparedStatement.setString(3, merchant.getAddress());
                return preparedStatement;
            }
        }, keyHolder);

        if (keyHolder.getKey() != null) {
            return keyHolder.getKey().intValue();
        } else {
            return null;
        }
    }
}