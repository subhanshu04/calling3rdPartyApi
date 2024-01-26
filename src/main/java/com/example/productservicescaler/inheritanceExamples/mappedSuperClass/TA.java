package com.example.productservicescaler.inheritanceExamples.mappedSuperClass;

import jakarta.persistence.Entity;

@Entity(name="msc_ta")
public class TA extends User {
    int rating;
}
