package com.example.shopping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
    @Id
    private long productId;
    private String productName;
    private float productPrice;
    private String productDescription;

}
