package com.example.productservicescaler.services;

import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    String getSingleProduct(Long productId);
    String getAllProducts();
}
