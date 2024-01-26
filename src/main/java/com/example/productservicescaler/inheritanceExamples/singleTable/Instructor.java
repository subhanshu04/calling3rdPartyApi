package com.example.productservicescaler.inheritanceExamples.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="single_instructor")
@DiscriminatorValue("3")
public class Instructor extends User {
    String batchName;
}
