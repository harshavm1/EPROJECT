package com.niit.Eproject.Dao;

import java.util.List;

import com.niit.Eproject.Model.Order;

public interface OrderDao {

	public boolean savdeorupdateOrder(Order order);
	public boolean deleteOrder(Order order);
	public Order getOrder(String orderId);
	public List<Order> orderlist();
}
