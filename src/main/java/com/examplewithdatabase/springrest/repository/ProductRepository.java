package com.examplewithdatabase.springrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examplewithdatabase.springrest.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByNameContainingIgnoreCase(String name);// Combines partial matching("LIKE %) with case-insensitivity.
    List<Product> findByNameContaining(String name);
    Product findByName(String name);


}
