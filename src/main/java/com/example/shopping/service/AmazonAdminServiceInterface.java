package com.example.shopping.service;

import com.example.shopping.entity.AmazonUser;
import com.example.shopping.entity.Product;

import java.util.List;

public interface AmazonAdminServiceInterface {
    Product createProductService(Product product);

    List<Product> getAllProductService();

    void deleteProduct(Long id);

    Product editProduct(Product product);

    void blockUser(AmazonUser amazonUser);

}
