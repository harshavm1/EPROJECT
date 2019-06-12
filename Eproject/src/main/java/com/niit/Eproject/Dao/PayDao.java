package com.niit.Eproject.Dao;

import java.util.List;

import com.niit.Eproject.Model.Pay;

public interface PayDao {

	public boolean savdeorupdatePay(Pay pay);
	public boolean deleteOrderPay(Pay pay);
	public Pay getPay(String payId);
	public List<Pay> payList();
}
