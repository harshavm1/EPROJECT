package com.niit.Eproject.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Card 
{
	@Id
	private String cardId;
	private String cardName;
	private String cardNumber;
	private String expiryDate;
	private String nameonCard;

	
	
	@Transient
	private String cvv;

	@ManyToOne
	@JoinColumn(name="UserId")
	private User user;

	public Card()
	{
	this.cardId="CARD"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public String getCardId() {
	return cardId;
	}

	public void setCardId(String cardId) {
	this.cardId = cardId;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getNameonCard() {
		return nameonCard;
	}

	public void setNameonCard(String nameonCard) {
		this.nameonCard = nameonCard;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	
}
