package com.examplewithdatabase.springrest.controller;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examplewithdatabase.springrest.dto.ApiResponse;
import com.examplewithdatabase.springrest.entities.Product;

import com.examplewithdatabase.springrest.repository.ProductRepository;

import jakarta.validation.Valid;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/public/products")
public class ProductController {
	
	@Autowired 
	ProductRepository productRepository;
	
	//Create
	@PostMapping
	 public ResponseEntity<ApiResponse<Product>> addProducts(@RequestBody Product product){
		Product savedProduct = productRepository.save(product);
		
		 return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true, "Product created", savedProduct));
	 }
	
	//Read 
	@GetMapping
	 public ResponseEntity<ApiResponse<List<Product>>> getAllProducts(){
		List<Product> products = productRepository.findAll();
		 return ResponseEntity.ok(new ApiResponse<>(true, "Products retrieved", products));
	 }
	
	//Request a product by id
	@GetMapping("/{id}")
	 public ResponseEntity<ApiResponse<Product>> getProduct(@PathVariable int id){
		 
		 return  productRepository.findById(id)
				 .map(product -> ResponseEntity.ok(
						 new ApiResponse<>(true, "Product found", product)))
				 .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
	                        .body(new ApiResponse<>(false, "Product not found", null)));
	 }
	
	//Request a product by name 
	///api/public/products?name=Asus
	//select * from product where name like "Asus%";
@GetMapping("/product")
	 public List<Product> getProductByName(@RequestParam @Valid String name ){
		 //Product products = productRepository.findByName(name);
		 //return name;
	//String productName = name;
				 return productRepository.findByNameContaining(name);
						
	 }
	 
/* .map(product -> ResponseEntity.ok(
						     new ApiResponse<>(true, "Product found", product)))
						 .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
								 .body(new ApiResponse<>(false, "Product not found", null)));*/
	//update
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<Product>> updateProduct(@PathVariable int id,@Valid @RequestBody Product product) {
		 if (!productRepository.existsById(id)) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                    .body(new ApiResponse<>(false, "Product not found", null));
	        }
		// Ensure the ID matches the path variable
		product.setId(id); 
		Product updatedProduct  = productRepository.save(product);
		return ResponseEntity.ok(new ApiResponse<>(true, "Product updated", updatedProduct ));
	     
	   
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<Product>> deleteProduct(@PathVariable int id){
		if (!productRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false, "Product not found", null));
        }
		
		  productRepository.deleteById(id);
		 return ResponseEntity.ok(new ApiResponse<>(true, "Product deleted", null));
	 }
	

}
