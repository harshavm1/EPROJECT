package com.niit.Eproject.Dao;

import java.util.List;

import com.niit.Eproject.Model.Card;

public interface CardDao
{
	public boolean saveorupdate(Card card);
	public boolean delete(Card card);
	public Card getCard(String cardId);
	public List<Card> cardlist();

}
