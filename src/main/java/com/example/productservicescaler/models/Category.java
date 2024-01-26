package com.example.productservicescaler.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Category extends BaseModel{
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Product> productList;
}
