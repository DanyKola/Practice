package com.example.demo.db.repository;

import com.example.demo.db.mapper.BoughtProductRowMapper;
import com.example.demo.domain.BoughtProduct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.List;

@Component
public class BoughtProductRepository {
    private  final JdbcTemplate jdbcTemplate;
    private final BoughtProductRowMapper boughtProductRowMapper;

    public BoughtProductRepository(JdbcTemplate jdbcTemplate, BoughtProductRowMapper boughtProductRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.boughtProductRowMapper = boughtProductRowMapper;
    }

    public void add(BoughtProduct boughtProduct){
        final  String sql ="INSERT INTO bought_product(product_id, customer_id, quantity,bought_at) value (?,?,?,?)";
        jdbcTemplate.update(sql, boughtProduct.getProductId(), boughtProduct.getCustomerId(), boughtProduct.getQuantity(),boughtProduct.getBoughtAt());

    }

    public List<BoughtProduct> getAllByCustomerId(int customerId){
        final String sql = "SELECT * FROM bought_product WHERE customer_id = "+customerId;
        return jdbcTemplate.query(sql, boughtProductRowMapper);
    }
}
