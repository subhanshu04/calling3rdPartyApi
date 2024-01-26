package com.example.productservicescaler.inheritanceExamples.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="joined_ta")
@PrimaryKeyJoinColumn(name="user_id")
public class TA extends User {
    int rating;
}
