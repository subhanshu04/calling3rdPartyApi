package com.example.productservicescaler.services;

import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public String getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public String getAllProducts() {
        return null;
    }
}
