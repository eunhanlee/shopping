package com.example.shopping.service;

import com.example.shopping.dao.AmazonAdminDAOInterface;
import com.example.shopping.dao.AmazonUserDAOInterface;
import com.example.shopping.entity.AmazonUser;
import com.example.shopping.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AmazonAdminService implements AmazonAdminServiceInterface {

    @Autowired
    private AmazonAdminDAOInterface adminDAO;
    @Autowired
    private AmazonUserDAOInterface userDAO;

    @Override
    public Product createProductService(Product product) {
        adminDAO.save(product);
        return product;
    }

    @Override
    public List<Product> getAllProductService() {
        return adminDAO.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        adminDAO.deleteById(id);
    }

    @Override
    public Product editProduct(Product product) {
        Optional<Product> existingProductOpt = adminDAO.findById(product.getProductId());
        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();
            existingProduct.setProductName(product.getProductName());
            existingProduct.setProductDescription(product.getProductDescription());
            existingProduct.setProductPrice(product.getProductPrice());
            return adminDAO.save(existingProduct);
        }

        return null;
//            throw new ResourceNotFoundException("Product not found with id " + product.getId());
    }

    @Override
    public void blockUser(AmazonUser amazonUser) {


        Optional<AmazonUser> userOpt = userDAO.findOptionalById(amazonUser.getId());
        if (userOpt.isPresent()) {
            AmazonUser user = userOpt.get();
            user.setBlock(true);
            userDAO.save(user);
        } else {
//            throw new ResourceNotFoundException("User not found with id " + amazonUser.getId());
        }
    }
}
