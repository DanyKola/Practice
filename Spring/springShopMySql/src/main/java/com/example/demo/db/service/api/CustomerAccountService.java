package com.example.demo.db.service.api;

import com.example.demo.domain.CustomerAccount;
import org.springframework.lang.Nullable;

public interface CustomerAccountService {

    void addCustomerAcount(CustomerAccount customerAccount);

    @Nullable
    double getMoney(int customerId);


    void setMoney(int customerId, double money);
}
