package com.example.productservicescaler.controllers;

import com.example.productservicescaler.services.CategoryService;
import com.example.productservicescaler.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController( ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable Long id){
        return "";
    }
    @GetMapping("")
    public String getAllProducts(){
        return null;
    }
    @PostMapping("")
    public String addNewProduct(){
        return null;
    }

    @PatchMapping("/{product_id}")
    public String updateProduct(@PathVariable String product_id){
        return null;
    }

    @PutMapping("/{product_id}")
    public String replaceProduct(@PathVariable String product_id){
        return null;
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        return "Deleting a product with id: " + productId;
    }
}
