package com.niit.Eproject.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
@Component
public class Product {
	
 @Transient
 private MultipartFile pimg;
 
	public MultipartFile getPimg() {
	return pimg;
}
public void setPimg(MultipartFile pimg) {
	this.pimg = pimg;
}
	@Id
	private String prodId;
	private String prodName;
	private int quantity;
	private float price;
	
	public Product()
	{
		this.prodId="PRODUCT"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	@ManyToOne
	@JoinColumn(name="catId")
	public Category category;

	@ManyToOne
	@JoinColumn(name="suppId")
	public Supplier supplier;

	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	
}
