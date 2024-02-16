package com.example.productservicescaler.models;

import com.example.productservicescaler.dtos.AddCartProductDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection(fetch = FetchType.LAZY)
    private Map<Long,Long> productQuantity = new HashMap<>();
    private String username;
}
