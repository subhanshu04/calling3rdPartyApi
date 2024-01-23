package com.example.productservicescaler.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class BaseModel {
    private Long id;
    private Date createAt;
    private Date lastUpdateAt;
    private boolean isDeleted;
}
