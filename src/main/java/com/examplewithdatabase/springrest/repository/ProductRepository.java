package com.examplewithdatabase.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examplewithdatabase.springrest.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
