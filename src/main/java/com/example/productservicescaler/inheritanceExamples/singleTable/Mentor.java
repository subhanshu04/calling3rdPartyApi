package com.example.productservicescaler.inheritanceExamples.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="single_mentor")
@DiscriminatorValue("2")
public class Mentor extends User {
    int menteeList;
}
