package com.example.productservicescaler.inheritanceExamples.singleTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="single_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
//User_type is used to distinguish between different users.
//We can define value using DiscrimatorValue
@DiscriminatorColumn(name="user_type",discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("4")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
}
