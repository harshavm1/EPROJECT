package com.niit.Eproject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Eproject.Dao.OrderDao;
import com.niit.Eproject.Dao.OrderItemsDao;
import com.niit.Eproject.Dao.PayDao;
import com.niit.Eproject.Dao.ShippingDao;
import com.niit.Eproject.Model.Order;
import com.niit.Eproject.Model.OrderItems;
import com.niit.Eproject.Model.Pay;
import com.niit.Eproject.Model.Shipping;

public class OrderItemsTest {
	
	public static void main(String args[])
			{
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
				ctx.refresh();
				
				OrderItems orderit=(OrderItems)ctx.getBean("orderItems");
				OrderItemsDao orderItemsDao=(OrderItemsDao)ctx.getBean("orderItemsDao");
				
				Shipping ship=(Shipping)ctx.getBean("shipping");
				ShippingDao shipDao=(ShippingDao)ctx.getBean("shippingDao");
				
				Pay pay=(Pay)ctx.getBean("pay");
				PayDao paydao=(PayDao)ctx.getBean("payDao");
				
				Order orders=(Order)ctx.getBean("order");
				OrderDao orderDao=(OrderDao)ctx.getBean("orderDao");
				
				orderit.setoItemId("otm101");
				orders=orderDao.getOrder("101");
				orderit.setOrder(orders);
				pay=paydao.getPay("p101");
				orderit.setPay(pay);
				ship=shipDao.getShipping("ship101");
				orderit.setShipping(ship);
				
				
			
				
				if(orderItemsDao.savdeorupdateOrderItems(orderit)==true)
				{
					System.out.println("order is saved");
				}
				else
				{
					System.out.println("order  not saved");
				}
				
				orderit.setoItemId("otm104");
			
				
				if(orderItemsDao.savdeorupdateOrderItems(orderit)==true)
				{
					System.out.println("order is saved");
				}
				else
				{
					System.out.println("order  not saved");
				}
				
				
				
				
		
		
		
		
		
		
			}

}
