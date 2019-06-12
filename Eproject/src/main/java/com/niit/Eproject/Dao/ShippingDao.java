package com.niit.Eproject.Dao;

import java.util.List;

import com.niit.Eproject.Model.Shipping;

public interface ShippingDao {

	public boolean savdeorupdateProduct(Shipping shipping);
	public boolean deleteProduct(Shipping shipping);
	public Shipping getShipping(String shipId);
	public List<Shipping> shippingList();
}
