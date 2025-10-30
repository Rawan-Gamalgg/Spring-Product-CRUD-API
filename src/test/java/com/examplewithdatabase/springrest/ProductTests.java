package com.examplewithdatabase.springrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

import com.examplewithdatabase.springrest.entities.Product;
import com.examplewithdatabase.springrest.repository.ProductRepository;

@DataJpaTest
public class ProductTests {
    @Autowired
    private ProductRepository repo;
    
    @BeforeEach
    public void setUp() {
        repo.deleteAll();
        Product product = new Product("Iphone16", "Description", 32000);
        repo.save(product);
        
        System.out.println("=== Data after setup ===");
        repo.findAll().forEach(p -> System.out.println(p.getId() + "-" + p.getName() + " - " + p.getDescription() + " - " + p.getPrice()));
    }
	
	@Test @Commit 
	public void TestCreateProduct(){
		Product product = new Product("Iphone17", "", 44000 );
		Product savedProduct = repo.save(product);
		
		assertNotNull(savedProduct);
		
	}
	
	
	@Test
	@Commit 
	public void TestFindProductByNameExist(){
		String name = "Iphone16";
		Product product = repo.findByName(name);
		
		assertThat(name, is(product.getName()));
	}
	
	@Test
	@Commit 
	public void TestFindProductByNameNotExist(){
		String name = "Iphone1";
		Product product = repo.findByName(name);
		
		assertNull(product);
	}
	/*@Test
	public void TestUpdateProduct(){
		String name = "Iphone8+";
		int price = 44000;
		Product product = new Product(name, "", price);
		
		//Product product = repo.findByName(name);
		product.setPrice(price);
		
		assertNotNull(repo.save(product));
		
	}*/
	@Test
	public void TestDeleteProduct(){
	
		
	}
	
	
	

	

}
