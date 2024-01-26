package com.example.productservicescaler.services;

import com.example.productservicescaler.clients.FakeStoreClient.FakeStoreProductDTO;
import com.example.productservicescaler.dtos.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<ProductDTO> getAllProducts();

    Optional<ProductDTO> getSingleProduct(Long productId);

    ProductDTO addNewProduct(FakeStoreProductDTO fakeStoreProductDto);

    ProductDTO updateProduct(Long productId,ProductDTO product);
    ProductDTO replaceProduct(Long productId,ProductDTO product);
    String deleteProduct(Long productId);
}
