package com.example.productservicescaler.services;

import org.springframework.stereotype.Service;

@Service
public class FakeStoreCategoryService implements CategoryService{
    @Override
    public String getAllCategories() {
        return null;
    }

    @Override
    public String getCategoryByProductId(Long productId) {
        return null;
    }
}
