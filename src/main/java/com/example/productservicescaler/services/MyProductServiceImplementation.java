package com.example.productservicescaler.services;

import com.example.productservicescaler.clients.FakeStoreClient.FakeStoreProductDTO;
import com.example.productservicescaler.dtos.ProductDTO;
import com.example.productservicescaler.exceptions.CategoryNotPresentException;
import com.example.productservicescaler.models.Category;
import com.example.productservicescaler.models.Product;
import com.example.productservicescaler.repositories.CategoryRepo;
import com.example.productservicescaler.repositories.ProductRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class MyProductServiceImplementation implements ProductService{
    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;

    public MyProductServiceImplementation(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepo.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Product product : productList){
            productDTOList.add(ProductDTO.from(product));
        }
        return productDTOList;
    }

    @Override
    public Optional<ProductDTO> getSingleProduct(Long productId) {
        return Optional.empty();
    }

    @Override
    public ProductDTO addNewProduct(FakeStoreProductDTO fakeStoreProductDto) throws CategoryNotPresentException {
        String categoryName = fakeStoreProductDto.getCategory();
        Optional<Category> optionalCategory = categoryRepo.findByName(categoryName);
        if(optionalCategory.isEmpty()){
            throw new CategoryNotPresentException("");
        }
        Category category = optionalCategory.get();
        Product product = Product.from(fakeStoreProductDto);
        product.setCategory(category);
        Product productValue = productRepo.save(product);

        return ProductDTO.from(productValue);
    }

    @Override
    public ProductDTO updateProduct(Long productId, ProductDTO product) {
        return null;
    }

    @Override
    public ProductDTO replaceProduct(Long productId, ProductDTO product) {
        return null;
    }

    @Override
    public String deleteProduct(Long productId) {
        return null;
    }
}
