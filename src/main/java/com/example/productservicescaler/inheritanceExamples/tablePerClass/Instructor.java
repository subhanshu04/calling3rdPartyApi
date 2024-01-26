package com.example.productservicescaler.inheritanceExamples.tablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tbc_instructor")
public class Instructor extends User{
    String batchName;
}
