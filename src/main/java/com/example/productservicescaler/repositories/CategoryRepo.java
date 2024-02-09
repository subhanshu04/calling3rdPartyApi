package com.example.productservicescaler.repositories;

import com.example.productservicescaler.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {

    @Override
    Optional<Category> findById(Long aLong);

    List<Category> findByIdBetween(Long idStart, Long idEnd);

    List<Category> findByIdIn(List<Long> ids);

    Optional<Category> findByName(String categoryName);
}
