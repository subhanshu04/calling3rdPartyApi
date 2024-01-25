package com.example.productservicescaler.controllers;

import com.example.productservicescaler.convertDTOs.FakeStoreDTOAndProduct;
import com.example.productservicescaler.dtos.FakeStoreProductDTO;
import com.example.productservicescaler.dtos.ProductDTO;
import com.example.productservicescaler.models.Product;
import com.example.productservicescaler.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController( ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getSingleProduct(@PathVariable Long id){
        return new ResponseEntity<>(productService.getSingleProduct(id), HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<ProductDTO> addNewProduct(@RequestBody FakeStoreProductDTO fakeStoreProductDTO){
        return new ResponseEntity<>(productService.addNewProduct(fakeStoreProductDTO),HttpStatus.OK);
    }

    @PatchMapping("/{product_id}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody FakeStoreProductDTO fakeStoreProductDTO,
                                @PathVariable Long product_id){
        ProductDTO productDTO =
                FakeStoreDTOAndProduct.convertFakeStoreProductDTOToProduct(fakeStoreProductDTO);
        return new ResponseEntity<>(productService.updateProduct(product_id,productDTO),HttpStatus.OK);
    }

    @PutMapping("/{product_id}")
    public ResponseEntity<ProductDTO> replaceProduct(@RequestBody FakeStoreProductDTO fakeStoreProductDTO,
                                                     @PathVariable Long product_id){
        ProductDTO productDTO =
                FakeStoreDTOAndProduct.convertFakeStoreProductDTOToProduct(fakeStoreProductDTO);
        return new ResponseEntity<>(productService.replaceProduct(product_id,productDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        return "Deleting a product with id: " + productId;
    }
}
