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
public class OrderItems {

	
	
	@Id
	private String oItemId;
	
	public OrderItems() {
	       this.oItemId="ORDITM"+UUID.randomUUID().toString().substring(30).toUpperCase();
		}
	
	@ManyToOne
	@JoinColumn(name="orderId")
	private Order order;
	
	@OneToOne
	@JoinColumn(name="payId")
	private Pay pay;
	
	@OneToOne
	@JoinColumn(name="shipId")
	private Shipping shipping;
     
	private String prodId;
	
	
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getoItemId() {
		return oItemId;
	}

	public void setoItemId(String oItemId) {
		this.oItemId = oItemId;
	}

	public Pay getPay() {
		return pay;
	}

	public void setPay(Pay pay) {
		this.pay = pay;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	
	
	
}
