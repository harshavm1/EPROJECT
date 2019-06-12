package com.niit.Eproject.Dao;

import java.util.List;

import com.niit.Eproject.Model.OrderItems;

public interface OrderItemsDao {

	public boolean savdeorupdateOrderItems(OrderItems orderItems);
	public boolean deleteOrderItems(OrderItems orderItems);
	public OrderItems getOrderItems(String oItemId);
	public List<OrderItems> orderList();
}
