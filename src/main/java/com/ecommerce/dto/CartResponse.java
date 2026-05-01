package com.ecommerce.dto;

public class CartResponse {
	private Long id;
	private Long productId;
	private int quantity;
	private String name;
	private double price;
	private String image_url;
	public CartResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartResponse(Long id, Long productId, int quantity, String name, double price, String image_url) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.name = name;
		this.price = price;
		this.image_url = image_url;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	@Override
	public String toString() {
		return "CartResponse [id=" + id + ", productId=" + productId + ", quantity=" + quantity + ", name=" + name
				+ ", price=" + price + ", image_url=" + image_url + "]";
	}
	
	

}
