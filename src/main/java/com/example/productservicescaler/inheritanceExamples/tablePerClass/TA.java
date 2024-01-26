package com.example.productservicescaler.inheritanceExamples.tablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tbc_ta")
public class TA extends User{
    int rating;
}
