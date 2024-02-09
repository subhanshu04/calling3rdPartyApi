package com.example.productservicescaler.clients.AuthenticationClient;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMapAdapter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class AuthenticationClientService {
    private RestTemplateBuilder restTemplateBuilder;

    public AuthenticationClientService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public String validate(String token){
        RestTemplate restTemplate = restTemplateBuilder.build();
        MultiValueMapAdapter<String,String> headers = new MultiValueMapAdapter<>(new HashMap<>());
        headers.add(
                "AUTH_TOKEN",token
        );
        HttpEntity<String> request = new HttpEntity(token,headers);
        ResponseEntity<String> response = restTemplate.postForEntity(
                "http://localhost:9000/authentication/validate",
                request,
                String.class
        );

        return response.getBody();
    }
}
