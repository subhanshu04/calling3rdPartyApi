package com.example.productservicescaler.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCartProductDto {
    private Long productId;
    private Long quantity;
}
