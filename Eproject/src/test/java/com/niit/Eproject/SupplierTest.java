package com.niit.Eproject;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Eproject.Dao.CategoryDao;
import com.niit.Eproject.Dao.SupplierDao;
import com.niit.Eproject.Model.Category;
import com.niit.Eproject.Model.Supplier;

public class SupplierTest {

	public static void main(String args[])
			{
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Supplier supp=(Supplier)ctx.getBean("supplier");
		SupplierDao suppDao=(SupplierDao)ctx.getBean("supplierDao");
		
		supp.setSuppId("supp101");
		supp.setSuppName("kiran");
		supp.setAddress("karnataka");
		
		
		if(suppDao.saveorupdatesupplier(supp)==true)
		{
			System.out.println("supp is saved");
		}
		else
		{
			System.out.println("supp not saved");
		}
		
		
		supp.setSuppId("supp102");
		supp.setSuppName("rohit");
		supp.setAddress("ap");
		supp.setEmail("rohit@gmail.com");
		supp.setPassword("rohit123");
		supp.setAddress("hyderabad");
		
		
		if(suppDao.saveorupdatesupplier(supp)==true)
		{
			System.out.println("supp is saved");
		}
		else
		{
			System.out.println("supp not saved");
		}
		
	}

}
