package com.example.productservicescaler.dtos;

import com.example.productservicescaler.models.Category;
import com.example.productservicescaler.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageUrl;

    public static ProductDTO from(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setTitle(product.getTitle());
        productDTO.setCategory(product.getCategory().getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setImageUrl(product.getImageUrl());
        productDTO.setDescription(product.getDescription());
        return productDTO;
    }
}
