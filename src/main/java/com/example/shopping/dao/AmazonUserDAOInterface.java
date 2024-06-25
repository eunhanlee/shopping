package com.example.shopping.dao;


import com.example.shopping.entity.AmazonUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AmazonUserDAOInterface extends JpaRepository<AmazonUser, String> {

    @Query("from com.example.shopping.entity.AmazonUser a where a.id=:uid and a.password=:pass")
    AmazonUser loginUser(@Param("uid") String id, @Param("pass") String password);

    Optional<AmazonUser> findOptionalById(String id);
}
