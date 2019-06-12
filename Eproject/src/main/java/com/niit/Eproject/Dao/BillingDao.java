package com.niit.Eproject.Dao;

import java.util.List;

import com.niit.Eproject.Model.Billing;

public interface BillingDao {

	public boolean saveorupdatebilling(Billing billing);
	public boolean deletebilling(Billing billing);
	public Billing getBilling(String billId);
	public List<Billing> billingList();
}
