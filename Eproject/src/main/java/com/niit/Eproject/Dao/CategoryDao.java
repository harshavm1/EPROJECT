package com.niit.Eproject.Dao;

import java.util.List;

import com.niit.Eproject.Model.Category;

public interface CategoryDao {
	
	public boolean savdeorupdateCategory(Category category);
	public boolean deleteCategory(Category category);
	public Category getCategory(String catId);
	public List<Category> catlist();
	

}
