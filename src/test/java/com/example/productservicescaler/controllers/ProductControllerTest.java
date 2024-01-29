package com.example.productservicescaler.controllers;

import com.example.productservicescaler.dtos.ProductDTO;
import com.example.productservicescaler.exceptions.WrongIdException;
import com.example.productservicescaler.models.Product;
import com.example.productservicescaler.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    private ProductController productController;
    @MockBean
    private ProductService productService;

    @Test
    void testGetAllProductShouldReturnProductList(){
        //3A -> Arrange Act Assert
        //1A -> Arrange
        ProductDTO product = new ProductDTO();
        product.setTitle("Mobile");
        when(productService.getAllProducts()).thenReturn(List.of(product));

        //2A -> Act
        ResponseEntity<List<ProductDTO>> response =  productController.getAllProducts();
        List<ProductDTO> productDTOList = response.getBody();

        //3A -> Assert
        assertEquals(productDTOList.get(0).getTitle(),product.getTitle());
    }

    @Test
    void testGetAllProductShouldThrowException() throws WrongIdException {
        when(productService.getSingleProduct(any())).thenReturn(Optional.empty());

        assertThrows(WrongIdException.class,
                () -> productController.getSingleProduct(1L));

    }
}