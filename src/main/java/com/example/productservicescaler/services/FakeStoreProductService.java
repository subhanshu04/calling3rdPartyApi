package com.example.productservicescaler.services;

import com.example.productservicescaler.convertDTOs.FakeStoreDTOAndProduct;
import com.example.productservicescaler.dtos.FakeStoreProductDTO;
import com.example.productservicescaler.dtos.ProductDTO;
import com.example.productservicescaler.models.Category;
import com.example.productservicescaler.models.Product;
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

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod,String url, @Nullable Object request,
                                               Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.
                responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class);
        List<ProductDTO> products = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO : response.getBody()){
            ProductDTO productDTO = FakeStoreDTOAndProduct.convertFakeStoreProductDTOToProduct(fakeStoreProductDTO);
            products.add(productDTO);
        }
        return products;
    }

    @Override
    public ProductDTO getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        //Rest Template is used to call 3rd party APIs. It has GET POST PATCH methods.
        //Parameters are : url,response type,variable in url(if any)
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/{id}",
                FakeStoreProductDTO.class,
                productId
        );
        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();
        //Convert productDTO to product.
        //Why this implementation ?
        //Because my business layer should be independent. It should return my product,
        //We will create different DTOs based upon the output we want to send from controller.
        ProductDTO productDTO = FakeStoreDTOAndProduct.convertFakeStoreProductDTOToProduct(fakeStoreProductDTO);
        return productDTO;
    }

    @Override
    public ProductDTO addNewProduct(FakeStoreProductDTO fakeStoreProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                fakeStoreProductDto,
                FakeStoreProductDTO.class
        );
        ProductDTO productDTO = FakeStoreDTOAndProduct.convertFakeStoreProductDTOToProduct(response.getBody());
        return productDTO;
    }

    @Override
    public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {
//        restTemplate.put(
//                "https://fakestoreapi.com/products/{id}",
//                product,
//                productId
//        );
        /*
        Put and Patch method of RestTemplate class doesnt return anything
        Hence we will manually create method which returns entity. -> requestForEntity
        */

        ResponseEntity<FakeStoreProductDTO> response = requestForEntity(HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}",
                productDTO,
                FakeStoreProductDTO.class,
                productId
        );
        return FakeStoreDTOAndProduct.convertFakeStoreProductDTOToProduct(response.getBody());
    }

    @Override
    public ProductDTO replaceProduct(Long productId, ProductDTO productDTO) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response = requestForEntity(HttpMethod.PUT,
                "https://fakestoreapi.com/products/{id}",
                productDTO,
                FakeStoreProductDTO.class,
                productId
        );
        return FakeStoreDTOAndProduct.convertFakeStoreProductDTOToProduct(response.getBody());
    }

    @Override
    public String deleteProduct(Long productId) {
        return null;
    }
}
