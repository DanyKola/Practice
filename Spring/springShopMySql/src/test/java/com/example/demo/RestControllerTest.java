package com.example.demo;

import com.example.demo.domain.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@AutoConfigureMockMvc
public class RestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void customer() throws Exception {
        Customer customer = new Customer("Pavel", "Novák", "Pavel@pavel.cz", "Křivoklátksá, Křivoklát", 34, "78907654");

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

        Customer returnedCustomer = objectMapper.readValue( customerJson, Customer.class);

    }
}
