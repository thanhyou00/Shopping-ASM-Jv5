package com.fpoly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
