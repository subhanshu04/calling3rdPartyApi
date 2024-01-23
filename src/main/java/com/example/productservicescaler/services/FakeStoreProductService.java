package com.example.productservicescaler.services;

import com.example.productservicescaler.dtos.ProductDTO;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public String getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public String addNewProduct(ProductDTO productDto) {
        return null;
    }

    @Override
    public String updateProduct(Long productId) {
        return null;
    }

    @Override
    public String deleteProduct(Long productId) {
        return null;
    }

    @Override
    public String getAllProducts() {
        return null;
    }
}
