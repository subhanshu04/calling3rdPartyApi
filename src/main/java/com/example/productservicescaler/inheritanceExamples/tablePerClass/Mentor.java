package com.example.productservicescaler.inheritanceExamples.tablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tbc_mentor")
public class Mentor extends User{
    int menteeList;
}
