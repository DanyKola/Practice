package com.example.demo.db.service.impl;

import com.example.demo.db.repository.ProductRepository;
import com.example.demo.db.service.api.ProductService;
import com.example.demo.db.service.api.request.UpdateProductRequest;
import com.example.demo.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServisImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServisImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getProducts() {
        return productRepository.getAll();
    }

    @Override
    public Product get(int id) {
        return productRepository.get(id);
    }

    @Override
    public Integer add(Product product) {
        return productRepository.add(product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public void update(int id, UpdateProductRequest updateProductRequest) {
    productRepository.update(id, updateProductRequest);
    }

    @Override
    public void updateAvailableInternal(int id, int newAvailable) {

    }
}
