package com.niit.Eproject.Dao;

import java.util.List;

import com.niit.Eproject.Model.Supplier;

public interface SupplierDao {
	
	public boolean saveorupdatesupplier(Supplier supplier);
	public boolean deletesupplier(Supplier supplier);
	public Supplier getSupplier(String suppId);
	public List<Supplier> supplierList();
}
