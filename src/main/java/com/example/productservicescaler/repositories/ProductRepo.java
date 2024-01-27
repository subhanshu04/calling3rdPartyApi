package com.example.productservicescaler.repositories;

import com.example.productservicescaler.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    Optional<Product> findProductByTitleContainsAndTitleStartingWith(
            String title, String title2);

    List<Product> findProductByCategory_DescriptionContains(String category_description2);
}
