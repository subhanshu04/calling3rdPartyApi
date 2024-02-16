package com.example.productservicescaler.controllers;

import com.example.productservicescaler.dtos.AddCartProductDto;
import com.example.productservicescaler.dtos.CartProductDto;
import com.example.productservicescaler.models.Cart;
import com.example.productservicescaler.services.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody List<AddCartProductDto> addCartProductDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        cartService.addToCart(addCartProductDto,username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CartProductDto>> getCart(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return new ResponseEntity<>(cartService.getCart(username),HttpStatus.OK);
    }
}
