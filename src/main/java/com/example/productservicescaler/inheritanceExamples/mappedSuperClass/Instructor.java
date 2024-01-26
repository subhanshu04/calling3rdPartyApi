package com.example.productservicescaler.inheritanceExamples.mappedSuperClass;

import jakarta.persistence.Entity;

@Entity(name="msc_instructor")
public class Instructor extends User {
    String batchName;
}
