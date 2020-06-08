package com.example.obuvkastore.repositories;

import com.example.obuvkastore.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
