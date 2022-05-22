package com.example.demo.db.service.api;

import com.example.demo.domain.Customer;
import org.springframework.lang.Nullable;

import java.util.List;

public interface CustomerService {

   List<Customer> getCustomers();
   @Nullable
   Customer getCustomer(int id);

   //bude vracet generované id
    @Nullable
   Integer addCustomer (Customer customer);


}
