package com.niit.Eproject;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Eproject.Dao.CategoryDao;
import com.niit.Eproject.Dao.ProductDao;
import com.niit.Eproject.Dao.SupplierDao;
import com.niit.Eproject.Model.Category;
import com.niit.Eproject.Model.Product;
import com.niit.Eproject.Model.Supplier;

public class ProductTest {
	
	public static void main(String args[])
	{
		
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Product prod=(Product)ctx.getBean("product");
		ProductDao prodDao=(ProductDao)ctx.getBean("productDao");
		
		Category cat=(Category)ctx.getBean("category");
		CategoryDao catDao=(CategoryDao)ctx.getBean("categoryDao");
		
		Supplier supp=(Supplier)ctx.getBean("supplier");
		SupplierDao supDao=(SupplierDao)ctx.getBean("supplierDao");
		
		
		prod.setProdId("p1011");
		prod.setProdName("mobile");
		cat=catDao.getCategory("c101");
		prod.setCategory(cat);
		supp=supDao.getSupplier("supp101");
		prod.setSupplier(supp);
		
		if(prodDao.savdeorupdateProduct(prod)==true)
		{
			System.out.println("product is saved");
		}
		else
		{
			System.out.println("product not saved");
		}
		
		prod.setProdId("p1012");
		prod.setProdName("pc");
		cat=catDao.getCategory("c101");
		prod.setCategory(cat);
		supp=supDao.getSupplier("supp101");
		prod.setSupplier(supp);
		
		
		if(prodDao.savdeorupdateProduct(prod)==true)
		{
			System.out.println("product is saved");
		}
		else
		{
			System.out.println("product not saved");
		}
		
		prod=prodDao.getProduct("p1011");
		if(prod==null)
		{
			System.out.println("product not exists");
		}
		else
		{
			System.out.println("prodid:"+prod.getProdId());
			System.out.println("prodname:"+prod.getProdName());
		}
		
		List<Product> prodlist=prodDao.productList();
		for(Product c:prodlist)
		{
			System.out.println("prodid:"+c.getProdId());
			System.out.println("prodname:"+c.getProdName());
		
		}
		
	}

}
