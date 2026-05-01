package com.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="prod_seq")
@SequenceGenerator(name="prod_seq",sequenceName="product_seq",allocationSize=1)
	private Long id;
	private String name;
	private double price;
	private String description;
	@Column(name="discount")
	private int  discount;
	
	@Column(name="image_url")
	private String image_url;
	private String category;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Long id, String name, double price, String description, int discount, String image_url,
			String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.discount = discount;
		this.image_url = image_url;
		this.category = category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", discount=" + discount + ", image_url=" + image_url + ", category=" + category + "]";
	}
	
	
	
}
