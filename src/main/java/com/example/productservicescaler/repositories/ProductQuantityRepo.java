package com.example.productservicescaler.repositories;

import com.example.productservicescaler.models.ProductQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProductQuantityRepo extends JpaRepository<ProductQuantity,Long> {
}
