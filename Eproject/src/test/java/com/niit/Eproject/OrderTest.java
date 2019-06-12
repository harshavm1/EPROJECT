package com.niit.Eproject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Eproject.Dao.BillingDao;
import com.niit.Eproject.Dao.OrderDao;
import com.niit.Eproject.Dao.OrderItemsDao;
import com.niit.Eproject.Dao.PayDao;
import com.niit.Eproject.Dao.ShippingDao;
import com.niit.Eproject.Dao.UserDao;
import com.niit.Eproject.Model.Billing;
import com.niit.Eproject.Model.Order;
import com.niit.Eproject.Model.OrderItems;
import com.niit.Eproject.Model.Pay;
import com.niit.Eproject.Model.Shipping;
import com.niit.Eproject.Model.User;

public class OrderTest {
	
	public static void main(String args[])
	{
		
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
				ctx.refresh();
				
				Order order=(Order)ctx.getBean("order");
				OrderDao orderDao=(OrderDao)ctx.getBean("orderDao");
				
				Pay pay=(Pay)ctx.getBean("pay");
				PayDao paydao=(PayDao)ctx.getBean("payDao");
				
				User user=(User)ctx.getBean("user");
				UserDao userDao=(UserDao)ctx.getBean("userDao");
				
				Billing bill=(Billing)ctx.getBean("billing");
				BillingDao billingDao=(BillingDao)ctx.getBean("billingDao");
				
				Shipping ship=(Shipping)ctx.getBean("shipping");
				ShippingDao shipDao=(ShippingDao)ctx.getBean("shippingDao");
				
				
				
				order.setOrderId("101");
				order.setOrderGrandTotal("300");
				bill=billingDao.getBilling("b101");
				order.setBilliing(bill);
				user=userDao.getUser("us101"); 
				order.setUser(user);
				pay=paydao.getPay("p101");
				order.setPay(pay);
				ship=shipDao.getShipping("ship102");
				order.setShipping(ship);
				
		
						
			
				
				if(orderDao.savdeorupdateOrder(order)==true)
				{
					System.out.println("order is saved");
				}
				else
				{
					System.out.println("order  not saved");
				}
				
				order.setOrderId("102");
				order.setOrderGrandTotal("600");
				bill=billingDao.getBilling("b102");
				order.setBilliing(bill);
			
				
				if(orderDao.savdeorupdateOrder(order)==true)
				{
					System.out.println("order is saved");
				}
				else
				{
					System.out.println("order  not saved");
				}
		
	}

}
