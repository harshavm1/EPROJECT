package com.niit.Eproject.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class CartItems {
	
	@Id
	private String cItemsId;
	private float cItemsPrice;
	
	@ManyToOne
	@JoinColumn(name="cartId")
	private Cart cart;
	
	@OneToOne
	@JoinColumn(name="prodId")
	
	private Product product;
	
	public CartItems() {
	   this.cItemsId="cartItem"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getcItemsId() {
		return cItemsId;
	}
	public void setcItemsId(String cItemsId) {
		this.cItemsId = cItemsId;
	}
	public float getcItemsPrice() {
		return cItemsPrice;
	}
	public void setcItemsPrice(float cItemsPrice) {
		this.cItemsPrice = cItemsPrice;
	}
	
	
	
}
