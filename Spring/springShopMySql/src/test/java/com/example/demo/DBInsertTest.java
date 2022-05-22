package com.example.demo;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Merchant;
import com.example.demo.domain.Product;
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
import java.sql.Timestamp;
import java.time.Instant;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class DBInsertTest {

    private final String insertCustomer = "INSERT INTO customer(name, surname,email, address, age, phone_number) values (?, ?,?,?,?,?)";
    private final String insertMerchand = "INSERT INTO merchant(name, email, address) values (?,?,?)";
    private final String insertProduct = "INSERT INTO product(merchant_id, name, description, price, create_at,available) values (?,?,?,?,?,?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Test
    public void createCustomer(){
        Customer customer = new Customer();
        customer.setName("Jan");
        customer.setSurname("Novák");
        customer.setAddress("U pole30, Praha 10");
        customer.setEmail("novak@novak.cz");
        customer.setAge(12);
        customer.setPhoneNumber("333333333");

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(insertCustomer);
                ps.setString(1, customer.getName());
                ps.setString(2, customer.getSurname());
                ps.setString(3, customer.getAddress());
                ps.setString(4, customer.getEmail());
                ps.setInt(5, customer.getAge());
                ps.setString(6, customer.getPhoneNumber());

              return ps;
            }
        });
    }

    @Test
    public void createMerchant(){
        Merchant merchant = new Merchant();
        merchant.setName("Marko");
        merchant.setEmail("marko@marko.com");
        merchant.setAddress("U pole 3, Praha 2");

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement psm = con.prepareStatement(insertMerchand);
                psm.setString(1, merchant.getName());
                psm.setString(2, merchant.getEmail());
                psm.setString(3, merchant.getAddress());
              return psm;
            }
        });


    }
    @Test
    public void createProduct(){
        Product product = new Product();
        product.setMerchantId(1);
        product.setName("Pero Parker");
        product.setDescription("Stříbrná barva");
        product.setPrice(356.90);
        product.setCreatedAt(Timestamp.from(Instant.now()));
        product.setAvailable(10);

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(insertProduct);
                ps.setInt(1, product.getMerchantId());
                ps.setString(2, product.getName());
                ps.setString(3, product.getDescription());
                ps.setDouble(4,product.getPrice() );
                ps.setTimestamp(5, product.getCreatedAt());
                ps.setInt(6, product.getAvailable());
                return ps;
            }
        });

    }

}
