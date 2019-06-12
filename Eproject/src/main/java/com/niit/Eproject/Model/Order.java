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
@Table(name="Orders")
@Component
public class Order {

	@Id
	private String orderId;
	private String orderGrandTotal;
	
	public Order() {
	       this.orderId="ORD"+UUID.randomUUID().toString().substring(30).toUpperCase();
		}
	
	@OneToMany
	private List<OrderItems> orderItems;
	
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
	
	@OneToOne
	@JoinColumn(name="payId")
	private Pay pay;
	
	@OneToOne
	@JoinColumn(name="billId")
	private Billing billiing;
	
	@OneToOne
	@JoinColumn(name="shipId")
	private Shipping shipping;
	
	public Pay getPay() {
		return pay;
	}
	public void setPay(Pay pay) {
		this.pay = pay;
	}
	public Billing getBilliing() {
		return billiing;
	}
	public void setBilliing(Billing billiing) {
		this.billiing = billiing;
	}
	public Shipping getShipping() {
		return shipping;
	}
	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}
	public List<OrderItems> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderGrandTotal() {
		return orderGrandTotal;
	}
	public void setOrderGrandTotal(String orderGrandTotal) {
		this.orderGrandTotal = orderGrandTotal;
	}
	
	
	
}
