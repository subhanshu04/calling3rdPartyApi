package com.example.productservicescaler.services;

import com.example.productservicescaler.dtos.AddCartProductDto;
import com.example.productservicescaler.dtos.CartProductDto;
import com.example.productservicescaler.models.Cart;
import com.example.productservicescaler.models.Product;
import com.example.productservicescaler.models.ProductQuantity;
import com.example.productservicescaler.repositories.CartRepo;
import com.example.productservicescaler.repositories.ProductQuantityRepo;
import com.example.productservicescaler.repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartService {
    private CartRepo cartRepo;
    private ProductRepo productRepo;
    private ProductQuantityRepo productQuantityRepo;

    public CartService(CartRepo cartRepo, ProductRepo productRepo, ProductQuantityRepo productQuantityRepo) {
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
        this.productQuantityRepo = productQuantityRepo;
    }

    public Cart addToCart(List<AddCartProductDto> addCartProductDtoList,String username){
        Optional<Cart> cartOptional = cartRepo.findByUsername(username);
        Cart cart;
        Map<Long, Long> productQuantity = new HashMap<>();
        if(cartOptional.isPresent()) {
            cart = cartOptional.get();
            productQuantity = cart.getProductQuantity();
        }
        else{
            cart = new Cart();
            cart.setUsername(username);
        }
        for(AddCartProductDto addCartProductDto : addCartProductDtoList){
            Long productId = addCartProductDto.getProductId();;
            Long quantity = addCartProductDto.getQuantity();
            if(productQuantity.containsKey(productId)){
                productQuantity.put(productId,productQuantity.get(productId)+quantity);
            }
            else{
                productQuantity.put(productId,quantity);
            }
        }
        cart.setProductQuantity(productQuantity);
        return cartRepo.save(cart);
    }

    public List<CartProductDto> getCart(String username){
        Optional<Cart> optionalCart = cartRepo.findByUsername(username);
        if(optionalCart.isEmpty()){
            return new ArrayList<>();
        }
        Cart cart = optionalCart.get();
        List<CartProductDto> cartProductDtoList = new ArrayList<>();
        Map<Long,Long> productQuantity = cart.getProductQuantity();
        for(Long productId : productQuantity.keySet()){
            Product product = productRepo.findById(productId).get();
            CartProductDto cartProductDto = CartProductDto.from(product);
            cartProductDto.setQuantity(productQuantity.get(productId));
            cartProductDtoList.add(cartProductDto);
        }
        return cartProductDtoList;
    }
}
