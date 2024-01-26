package com.example.productservicescaler.clients.FakeStoreClient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
