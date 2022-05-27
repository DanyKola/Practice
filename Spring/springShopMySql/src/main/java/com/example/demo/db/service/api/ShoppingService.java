package com.example.demo.db.service.api;

import com.example.demo.db.service.api.request.BuyProductRequest;
import com.example.demo.db.service.api.response.BuyProductResponse;
public interface ShoppingService {
    BuyProductResponse buyProduct(BuyProductRequest request);
}