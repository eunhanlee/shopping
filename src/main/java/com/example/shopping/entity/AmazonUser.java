package com.example.shopping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class AmazonUser {
    @Id
    private String id;
    private String name;
    private String password;
    private  String email;
    private Boolean block;

}
