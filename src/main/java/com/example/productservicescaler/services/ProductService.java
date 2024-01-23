package com.example.productservicescaler.services;

import com.example.productservicescaler.dtos.ProductDTO;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    String getAllProducts();

    String getSingleProduct(Long productId);

    String addNewProduct(ProductDTO productDto);

    String updateProduct(Long productId);

    String deleteProduct(Long productId);
}
