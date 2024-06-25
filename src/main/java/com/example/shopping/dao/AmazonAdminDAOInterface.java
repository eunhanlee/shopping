package com.example.shopping.dao;

import com.example.shopping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmazonAdminDAOInterface extends JpaRepository<Product, Long> {

}
