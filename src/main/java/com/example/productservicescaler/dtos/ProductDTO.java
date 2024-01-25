package com.example.productservicescaler.dtos;

import com.example.productservicescaler.models.Category;
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
}
