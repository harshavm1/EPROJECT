package com.niit.Eproject.Dao;

import java.util.List;

import com.niit.Eproject.Model.CartItems;

public interface CartItemsDao {

	public boolean saveorupdatecartitems(CartItems cartitems);
	public boolean deletecartitems(CartItems cartitems);
	public List<CartItems> getcartitems(String cItemsId);
	public CartItems getcartitem(String cItemsId);
	public List<CartItems> cartitemsList();
	public List<CartItems> getCartItemsByProductId(String prodId);
	public List<CartItems> cartitemsList(String cartID); 
}
