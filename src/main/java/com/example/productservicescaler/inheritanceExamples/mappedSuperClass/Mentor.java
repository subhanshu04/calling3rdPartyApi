package com.example.productservicescaler.inheritanceExamples.mappedSuperClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="msc_mentor")
@PrimaryKeyJoinColumn(name="user_id")
public class Mentor extends User {
    int menteeList;
}
