package com.niit.Eproject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Eproject.Dao.CategoryDao;
import com.niit.Eproject.Dao.ShippingDao;
import com.niit.Eproject.Dao.UserDao;
import com.niit.Eproject.Model.Category;
import com.niit.Eproject.Model.Shipping;
import com.niit.Eproject.Model.User;

public class ShippingTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Shipping ship=(Shipping)ctx.getBean("shipping");
		ShippingDao shipDao=(ShippingDao)ctx.getBean("shippingDao");
		
		User user=(User)ctx.getBean("user");
		UserDao userDao=(UserDao)ctx.getBean("userDao");
		
		ship.setShipId("ship101");
		ship.setShipState("karnataka");
		ship.setShipCity("bangalore");
		user=userDao.getUser("us101");
		ship.setUser(user);
		
		if(shipDao.savdeorupdateProduct(ship)==true)
		{
			System.out.println("shipping is saved");
		}
		else
		{
			System.out.println("shipping not saved");
		}
		
		ship.setShipId("ship102");
		ship.setShipState("up");
		ship.setShipCity("lucknow");
		user=userDao.getUser("us102");
		ship.setUser(user);
		
		if(shipDao.savdeorupdateProduct(ship)==true)
		{
			System.out.println("shipping is saved");
		}
		else
		{
			System.out.println("shipping not saved");
		}
		
		
		
		
	}

}
