package com.example.shopping.controller;


import com.example.shopping.entity.Product;
import com.example.shopping.service.AmazonAdminServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AmazonAdminController {

    @Autowired
    private AmazonAdminServiceInterface adminInterface;

    @PostMapping("addProduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = adminInterface.createProductService(product);
        return ResponseEntity.ok(createdProduct);
    }

    @DeleteMapping("deleteProduct")
    public ResponseEntity<Void> deleteProduct(@RequestParam Long id) {
        adminInterface.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

//    @PutMapping
//    public ResponseEntity<Product> editProduct(@RequestBody Product product) {
//        Product editedProduct = adminInterface.editProduct(product);
//        return ResponseEntity.ok(editedProduct);
//    }

    @GetMapping("viewAll")
    public ResponseEntity<List<Product>> getAllList() {
        List<Product> productList = adminInterface.getAllProductService();
        return ResponseEntity.ok(productList);
    }

//    @PutMapping
//    public ResponseEntity<Product> blockUser(@RequestBody AmazonUser amazonUser) {
//        adminInterface.blockUser(amazonUser);
//        return ResponseEntity.ok().build();
//    }
}
