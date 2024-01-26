package com.example.productservicescaler.controllers;

import com.example.productservicescaler.convertDTOs.FakeStoreDTOAndProduct;
import com.example.productservicescaler.clients.FakeStoreClient.FakeStoreProductDTO;
import com.example.productservicescaler.dtos.ProductDTO;
import com.example.productservicescaler.exceptions.WrongIdException;
import com.example.productservicescaler.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController( ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getSingleProduct(@PathVariable Long id) throws WrongIdException {
        Optional<ProductDTO> response = productService.getSingleProduct(id);
        if(response.isEmpty()){
            throw new WrongIdException("Wrong Id is provided.");
        }
        else{
            return new ResponseEntity<>(response.get(),HttpStatus.OK);
        }
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
                                @PathVariable Long product_id) throws WrongIdException {
        ProductDTO productDTO =
                FakeStoreDTOAndProduct.convertFakeStoreProductDTOToProduct(fakeStoreProductDTO);
        ProductDTO response = productService.updateProduct(product_id,productDTO);
        if(response==null){
            throw new WrongIdException("Wrong Id is provided");
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/{product_id}")
    public ResponseEntity<ProductDTO> replaceProduct(@RequestBody FakeStoreProductDTO fakeStoreProductDTO,
                                                     @PathVariable Long product_id) throws WrongIdException {
        ProductDTO productDTO =
                FakeStoreDTOAndProduct.convertFakeStoreProductDTOToProduct(fakeStoreProductDTO);
        ProductDTO response = productService.replaceProduct(product_id,productDTO);
        if(response==null){
            throw new WrongIdException("Wrong Id is provided");
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        return "Deleting a product with id: " + productId;
    }
}
