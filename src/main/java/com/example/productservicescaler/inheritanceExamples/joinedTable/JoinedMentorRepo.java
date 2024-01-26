package com.example.productservicescaler.inheritanceExamples.joinedTable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JoinedMentorRepo extends JpaRepository<Mentor,Long> {
}
