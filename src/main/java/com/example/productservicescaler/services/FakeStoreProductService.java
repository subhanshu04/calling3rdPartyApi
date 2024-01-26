package com.example.productservicescaler.services;

import com.example.productservicescaler.clients.FakeStoreClient.FakeStoreClient;
import com.example.productservicescaler.convertDTOs.FakeStoreDTOAndProduct;
import com.example.productservicescaler.clients.FakeStoreClient.FakeStoreProductDTO;
import com.example.productservicescaler.dtos.ProductDTO;
import com.example.productservicescaler.exceptions.WrongIdException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class FakeStoreProductService implements ProductService{

    private FakeStoreClient fakeStoreClient;

    public FakeStoreProductService(FakeStoreClient fakeStoreClient) {
        this.fakeStoreClient = fakeStoreClient;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return fakeStoreClient.getAllProducts();
    }

    @Override
    public Optional<ProductDTO> getSingleProduct(Long productId) {
        return fakeStoreClient.getSingleProduct(productId);
    }

    @Override
    public ProductDTO addNewProduct(FakeStoreProductDTO fakeStoreProductDto) {
        return fakeStoreClient.addNewProduct(fakeStoreProductDto);
    }

    @Override
    public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {
        return fakeStoreClient.updateProduct(productId,productDTO);
    }

    @Override
    public ProductDTO replaceProduct(Long productId, ProductDTO productDTO) {
        return fakeStoreClient.replaceProduct(productId,productDTO);
    }

    @Override
    public String deleteProduct(Long productId) {
        return null;
    }

}
