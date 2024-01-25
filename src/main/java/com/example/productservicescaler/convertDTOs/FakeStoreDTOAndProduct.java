package com.example.productservicescaler.convertDTOs;

import com.example.productservicescaler.dtos.FakeStoreProductDTO;
import com.example.productservicescaler.dtos.ProductDTO;
import com.example.productservicescaler.models.Category;
import com.example.productservicescaler.models.Product;


public class FakeStoreDTOAndProduct {
    public static ProductDTO convertFakeStoreProductDTOToProduct(FakeStoreProductDTO fakeStoreProductDTO){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setTitle(fakeStoreProductDTO.getTitle());
        productDTO.setPrice(fakeStoreProductDTO.getPrice());
        productDTO.setDescription(fakeStoreProductDTO.getDescription());
        productDTO.setImageUrl(fakeStoreProductDTO.getImage());
        productDTO.setCategory(fakeStoreProductDTO.getCategory());
        return productDTO;
    }
    public static FakeStoreProductDTO convertProductToFakeStoreProductDTO(ProductDTO productDTO){
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(productDTO.getTitle());
        fakeStoreProductDTO.setPrice(productDTO.getPrice());
        fakeStoreProductDTO.setDescription(productDTO.getDescription());
        fakeStoreProductDTO.setImage(productDTO.getImageUrl());
        fakeStoreProductDTO.setCategory(productDTO.getCategory());
        return fakeStoreProductDTO;
    }
}
