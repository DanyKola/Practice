package com.example.demo.db.mapper;

import com.example.demo.domain.Merchant;
import com.example.demo.domain.Product;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MerchantRowMapper implements RowMapper<Merchant> {

    Merchant merchant = new Merchant();


    @Override
    public Merchant mapRow(ResultSet rs, int rowNum) throws SQLException {
        merchant.setId(rs.getInt("id"));
        merchant.setName(rs.getString("name"));
        merchant.setEmail(rs.getString("email"));
        merchant.setAddress(rs.getString("address"));

        return merchant;
    }
}
