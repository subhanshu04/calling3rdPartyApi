package com.example.productservicescaler.inheritanceExamples.mappedSuperClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MappedMentorRepo extends JpaRepository<Mentor,Long> {
}
