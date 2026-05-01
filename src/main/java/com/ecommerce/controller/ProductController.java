package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/products")

public class ProductController {
	
	@Autowired
	private ProductService service;
	
@PostMapping
public Product addProduct(@RequestBody Product product) {
	return service.save(product);
}
@GetMapping
public List<Product> getAllProducts(){
	return service.getAll();
}
@GetMapping("/{id}")
public Product getProduct(@PathVariable Long id) {
	return service.getById(id);
}
		
@DeleteMapping("/{id}")
public String deleteProduct(@PathVariable Long id) {
			service.delete(id);
	return "Deleted successfully";
}
@PutMapping("/{id}")
 public Product updateProduct(@PathVariable Long id,@RequestBody Product product) {
	Product existing=service.getById(id);
	existing.setName(product.getName());
	existing.setPrice(product.getPrice());
	existing.setDescription(product.getDescription());
	

	
	return service.save(existing);
}
}
