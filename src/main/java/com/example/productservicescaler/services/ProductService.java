package com.example.productservicescaler.services;

import com.example.productservicescaler.dtos.FakeStoreProductDTO;
import com.example.productservicescaler.dtos.ProductDTO;
import com.example.productservicescaler.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductDTO> getAllProducts();

    ProductDTO getSingleProduct(Long productId);

    ProductDTO addNewProduct(FakeStoreProductDTO fakeStoreProductDto);

    ProductDTO updateProduct(Long productId,ProductDTO product);
    ProductDTO replaceProduct(Long productId,ProductDTO product);
    String deleteProduct(Long productId);
}
