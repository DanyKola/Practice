package com.example.demo;

import com.example.demo.db.service.api.request.UpdateProductRequest;
import com.example.demo.domain.Customer;
import com.example.demo.domain.Merchant;
import com.example.demo.domain.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@AutoConfigureMockMvc
public class RestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private Merchant merchant;

    @Before //spustí před každou testovací metodou
    public void createMerchant() throws Exception {
        if (merchant == null) {
            merchant = new Merchant("Highlinger", "highlinger@highlinger.com", "U pole 2, KV");
            String id = mockMvc.perform(post("/merchant")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(merchant)))
                    .andExpect(status().isCreated())
                    .andReturn().getResponse().getContentAsString();

            merchant.setId(objectMapper.readValue(id, Integer.class));
        }
    }


    //CUSTOMER
    @Test
    public void customer() throws Exception {
        Customer customer = new Customer("Pavel", "Novak", "Pavel@pavel.cz", "Krivoklatksa, Krivoklat", 34, "78907654");


//Otestování přidání zákazníka - addCustomer
        String id = mockMvc.perform(post("/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();

        customer.setId(objectMapper.readValue(id, Integer.class));


//Otestování Get customer
        String customerJson = mockMvc.perform(get("/customer/" + customer.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        Customer returnedCustomer = objectMapper.readValue(customerJson, Customer.class);

        Assert.assertEquals(customer, returnedCustomer);

//Otestování GET Customers
        String listJsonCustomers = mockMvc.perform(get("/customer")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        List<Customer> customerList = objectMapper.readValue(listJsonCustomers, new TypeReference<List<Customer>>() {
        });
        assert customerList.size() == 1;
        Assert.assertEquals(customer, customerList.get(0));
    }

    //MERCHANT

    @Test
    public void merchant() throws Exception {
//add merchant
/*
    Merchant merchant = new Merchant("Highlinger", "highlinger@highlinger.com", "U pole 2, KV");
            String id = mockMvc.perform(post("/merchant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(merchant)))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();

        merchant.setId(objectMapper.readValue(id, Integer.class));
 */


//Get merchant

        String merchantJson = mockMvc.perform(get("/merchant/" + merchant.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(merchant)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        Merchant returnedMerchant = objectMapper.readValue(merchantJson, Merchant.class);

        Assert.assertEquals(merchant, returnedMerchant);

//Get merchants
        String listMerchantJson = mockMvc.perform(get("/merchant")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        List<Merchant> merchantList = objectMapper.readValue(listMerchantJson, new TypeReference<List<Merchant>>() {
        });
        assert merchantList.size() == 1;
        Assert.assertEquals(merchant, merchantList.get(0));

    }
//Product

    @Test
    public void product() throws Exception {
        Product product = new Product(merchant.getId(), "Fixa Higjligheter", "zelena barva", 23.8, 3);

//add product
        String id = mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();

        product.setId(objectMapper.readValue(id, Integer.class));


//get product
        String productJson = mockMvc.perform(get("/product/" + product.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        Product returnedProduct = objectMapper.readValue(productJson, Product.class);
        Assert.assertEquals(product, returnedProduct);


//get products
        String listJsonProduct = mockMvc.perform(get("/product")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        List<Product> productList = objectMapper.readValue(listJsonProduct, new TypeReference<List<Product>>() {
        });

        assert productList.size() == 1;
        Assert.assertEquals(product, productList.get(0));

// update product

        double updatePrice = product.getPrice() + 30.40;
        int updateAvailable = product.getAvailable() + 10;
        UpdateProductRequest updateProductRequest = new UpdateProductRequest(product.getName(), product.getDescription(), updatePrice, updateAvailable);

       mockMvc.perform(patch("/product/" + product.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateProductRequest)))
                .andExpect(status().isOk());

        String returnedUpdateProduct = mockMvc.perform(get("/product/" + product.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        Product updatedProduct = objectMapper.readValue(returnedUpdateProduct, Product.class);
        assert  updatePrice == updatedProduct.getPrice();
        assert updateAvailable == updatedProduct.getAvailable();

        //System.out.println(returnedUpdateProduct);


//delete product
    mockMvc.perform(delete("/product/" + product.getId())
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

        mockMvc.perform(get("/product/" + product.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        String listJsonProductTest = mockMvc.perform(get("/product")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        List<Product> productListTest = objectMapper.readValue(listJsonProductTest, new TypeReference<List<Product>>() {
        });
        assert productListTest.size()==0;


    }
}
