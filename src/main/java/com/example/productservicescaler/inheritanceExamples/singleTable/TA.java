package com.example.productservicescaler.inheritanceExamples.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="single_ta")
@DiscriminatorValue("1")
public class TA extends User {
    int rating;
}
