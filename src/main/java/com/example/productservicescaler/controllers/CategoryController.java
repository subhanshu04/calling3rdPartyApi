package com.example.productservicescaler.controllers;

import com.example.productservicescaler.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public String getAllCategories(){
        return null;
    }

    @GetMapping("/{category_id}")
    public String getProductsInCategory(@PathVariable Long category_id){
        return null;
    }
}
