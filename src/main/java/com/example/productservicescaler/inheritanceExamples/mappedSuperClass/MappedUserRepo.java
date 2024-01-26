package com.example.productservicescaler.inheritanceExamples.mappedSuperClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MappedUserRepo extends JpaRepository<User,Long> {
}
