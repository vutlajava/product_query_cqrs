package com.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.query.entity.Product;

@Repository
public interface ProductQueryRepository extends JpaRepository<Product,Long>{

}
