package com.examplewithdatabase.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.examplewithdatabase.springrest.entities.Product;

import com.examplewithdatabase.springrest.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired 
	ProductRepository productRepository;
	
	//Create
	@PostMapping("/products/")
	 public Product addProducts(@RequestBody Product product){
		 return productRepository.save(product);
	 }
	
	//Read 
	@GetMapping("/products/")
	 public List<Product> getAllProducts(){
		 return productRepository.findAll();
	 }
	@GetMapping("/products/{id}")
	 public Product getProduct(@PathVariable int id){
		 return productRepository.findById(id).get();
	 }
	
	//update
	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
		
	    product.setId(id); // Ensure the ID matches the path variable
	    return productRepository.save(product);
	}
	//Delete
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable int id){
		  productRepository.deleteById(id);
	 }
	

}
