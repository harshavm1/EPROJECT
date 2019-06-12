package com.niit.Eproject.Dao;

import java.util.List;

import com.niit.Eproject.Model.Cart;

public interface CartDao {

	public boolean saveorupdatecartg(Cart cart);
	public boolean deletecart(Cart cart);
	public Cart getcart(String cartId);
	public List<Cart> cartList();
}
