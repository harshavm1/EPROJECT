package com.niit.Eproject.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart {
	@Id
	private String cartId;
	private float grandTotal;
	private int totalItems;
	
	@OneToMany(mappedBy="cart")
	private List<CartItems> cartitems;
	
	
	
	public List<CartItems> getCartitems() {
		return cartitems;
	}
	public void setCartitems(List<CartItems> cartitems) {
		this.cartitems = cartitems;
	}
	public Cart() {
       this.cartId="cart"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public float getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	
}
