package com.examplewithdatabase.springrest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Product {
	//Auto increment primary key id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
private int id; 
    @NotBlank(message = "Productname cannot be empty")
    @Size(min = 5, max = 100)
private String name;
    @Size(max = 500)
private String description;
    @Min(0)
private double price;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
} 
}