package com.example.productservicescaler.dtos;

import com.example.productservicescaler.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartProductDto {
    private String title;
    private double price;
    private String description;
    private Long quantity;

    public static CartProductDto from(Product product){
        CartProductDto cartProductDto = new CartProductDto();
        cartProductDto.setTitle(product.getTitle());
        cartProductDto.setPrice(product.getPrice());
        cartProductDto.setDescription(product.getDescription());
        cartProductDto.setQuantity(null);
        return cartProductDto;
    }
}
