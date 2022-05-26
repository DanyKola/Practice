package com.example.demo.db.service.impl;

import com.example.demo.db.repository.CustomerAccountRepository;
import com.example.demo.db.service.api.CustomerAccountService;
import com.example.demo.db.service.api.CustomerService;
import com.example.demo.domain.Customer;
import com.example.demo.domain.CustomerAccount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerAccountServiceImpl implements CustomerAccountService {
    private final CustomerAccountRepository customerAccountRepository;

    public CustomerAccountServiceImpl(CustomerAccountRepository customerAccountRepository) {
        this.customerAccountRepository = customerAccountRepository;
    }


    @Override
    public void addCustomerAcount(CustomerAccount customerAccount) {
        customerAccountRepository.add(customerAccount);
    }

    @Override
    public double getMoney(int customerId) {
        return customerAccountRepository.getMoney(customerId);
    }

    @Override
    public void setMoney(int customerId, double money) {
        customerAccountRepository.setMoney(customerId, money);
    }

}
