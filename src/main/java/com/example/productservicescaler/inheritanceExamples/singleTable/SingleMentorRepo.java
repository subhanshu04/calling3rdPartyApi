package com.example.productservicescaler.inheritanceExamples.singleTable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SingleMentorRepo extends JpaRepository<Mentor,Long> {
}
