package com.example.demo.db.service.impl;

import com.example.demo.db.service.api.*;
import com.example.demo.db.service.api.request.BuyProductRequest;
import com.example.demo.db.service.api.response.BuyProductResponse;
import com.example.demo.domain.BoughtProduct;
import com.example.demo.domain.Customer;
import com.example.demo.domain.Product;
import org.springframework.stereotype.Service;

@Service
public class ShoppingServiceImpl implements ShoppingService {

    private final ProductService productService;
    private final CustomerService customerService;
    private final CustomerAccountService customerAccountService;
    private final BoughtProductService boughtProductService;

    public ShoppingServiceImpl(ProductService productService, CustomerService customerService, CustomerAccountService customerAccountService, BoughtProductService boughtProductService) {
        this.productService = productService;
        this.customerService = customerService;
        this.customerAccountService = customerAccountService;
        this.boughtProductService = boughtProductService;
    }

    @Override
    public BuyProductResponse buyProduct(BuyProductRequest request) {
        int productId = request.getProductId();
        int customerId = request.getCustomerId();

        Product product = productService.get(productId);
        if (product == null) {
            return new BuyProductResponse(false, "Product s id: " + productId + " neexistuje");
        }

        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            return new BuyProductResponse(false, "Zákazník s id: " + customerId + " neexistuje");
        }

        if (product.getAvailable() < request.getQuantity()) {
            return new BuyProductResponse(false, "Není dostatek produktů na skladu");
        }


        Double customerMoney = customerAccountService.getMoney(customerId);
        if (customerMoney == null) {
            return new BuyProductResponse(false, "Zákazník s id: " + customerId + " nemá dostatek peněz");
        } else {

            double totalPriceOfRequest = product.getPrice() * request.getQuantity();
            if (customerMoney >= totalPriceOfRequest) {

                productService.updateAvailableInternal(productId, product.getAvailable() - request.getQuantity());
                customerAccountService.setMoney(customerId, customerMoney - totalPriceOfRequest);
                boughtProductService.add(new BoughtProduct(productId, customerId, request.getQuantity()));
                return new BuyProductResponse(true);

            } else {
                return new BuyProductResponse(false, "Customer with id: " + customerId + " doesn't have enough money");
            }
        }
    }
}