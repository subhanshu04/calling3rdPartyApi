package com.example.productservicescaler.inheritanceExamples.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="joined_mentor")
@PrimaryKeyJoinColumn(name="user_id")
public class Mentor extends User {
    int menteeList;
}
