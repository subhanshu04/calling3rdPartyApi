package com.example.productservicescaler;


import com.example.productservicescaler.models.Category;
import com.example.productservicescaler.models.Product;
import com.example.productservicescaler.repositories.CategoryRepo;
import com.example.productservicescaler.repositories.ProductRepo;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ProductCategoryTest {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Transactional
    @Test
    void addProductCategory(){
//        Category category = new Category();
//        category.setName("Cloth");
//        category.setDescription("Clothing material stuff");
//        categoryRepo.save(category);
//        Product product = new Product();
//        product.setTitle("Pant");
//        product.setPrice(500);
//        product.setCategory(categoryRepo.findById(52L).get());
//        productRepo.save(product);
//        List<Category> categories = categoryRepo.findByIdIn(List.of(1L, 52L));
//        System.out.println("Category DB call completed");
//        for(Category category : categories){
//            List<Product> products = category.getProductList();
//            for(Product product : products){
//                System.out.println(product.getPrice());
//            }
//        }
//        System.out.println("Before explicit calling product");

        List<Product> product = productRepo
                .findProductByCategory_DescriptionContains("Clothing");
    }
}
