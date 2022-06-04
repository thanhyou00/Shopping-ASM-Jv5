package com.fpoly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
