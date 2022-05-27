package com.example.demo.db.service.api;
import com.example.demo.domain.BoughtProduct;
import java.util.List;


public interface BoughtProductService {

    void add(BoughtProduct boughtProduct);

    List<BoughtProduct> getAllByCustomerId(int customerId);
}