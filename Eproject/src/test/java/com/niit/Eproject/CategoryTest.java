/*package com.niit.Eproject;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Eproject.Dao.CategoryDao;
import com.niit.Eproject.Model.Category;

public class CategoryTest {

	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Category cat=(Category)ctx.getBean("category");
		CategoryDao catDao=(CategoryDao)ctx.getBean("categoryDao");
		
		cat.setCatId("c101");
		cat.setCatName("cat1");
		
		if(catDao.savdeorupdateCategory(cat)==true)
		{
			System.out.println("Category is saved");
		}
		else
		{
			System.out.println("Category not saved");
		}
		
		cat.setCatId("c102");
		cat.setCatName("cat2");
		
		if(catDao.savdeorupdateCategory(cat)==true)
		{
			System.out.println("Category is saved");
		}
		else
		{
			System.out.println("Category not saved");
		}
		
		cat.setCatId("c103");
		cat.setCatName("cat3");
		
		if(catDao.savdeorupdateCategory(cat)==true)
		{
			System.out.println("Category is saved");
		}
		else
		{
			System.out.println("Category not saved");
		}
		
		
		cat=catDao.getCategory("c102");
		if(cat==null)
		{
			System.out.println("Category not exists");
		}
		else
		{
			System.out.println("CatID:"+cat.getCatId());
			System.out.println("CatName:"+cat.getCatName());
		}
		
		
		cat=catDao.getCategory("c103");
		if(cat==null)
		{
			System.out.println("Category not exists");
		}
		else
		{
			if(catDao.deleteCategory(cat)==true)
			{
				System.out.println("Category deleted");
			}
		}
		
		
		List<Category> catlist=catDao.catlist();
		for(Category c:catlist)
		{
			System.out.println("CatID:"+c.getCatId());
			System.out.println("CatName:"+c.getCatName());
		
		}
		
	}
	
}
*/