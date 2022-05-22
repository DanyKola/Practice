package com.example.demo.db.service.impl;

import com.example.demo.db.repository.CustomerRepository;
import com.example.demo.db.service.api.CustomerService;
import com.example.demo.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.getAll();
    }

    @Override
    public Customer getCustomer(int id) {
        return customerRepository.getId(id);
    }

    @Override
    public Integer addCustomer(Customer customer) {
        return customerRepository.add(customer);
    }
}
