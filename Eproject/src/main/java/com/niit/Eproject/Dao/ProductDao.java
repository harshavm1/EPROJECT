package com.niit.Eproject.Dao;

import java.util.List;

import com.niit.Eproject.Model.Product;

public interface ProductDao {
	
	public boolean savdeorupdateProduct(Product product);
	public boolean deleteProduct(Product product);
	public Product getProduct(String prodId);
	public List<Product> productList();
	public List<Product> getProductsById(String catId);
	public List<Product> getProductsBySupplierId(String suppId);

}
