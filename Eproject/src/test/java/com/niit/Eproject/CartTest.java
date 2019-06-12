package com.niit.Eproject;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Eproject.Dao.CartDao;
import com.niit.Eproject.Dao.CartItemsDao;
import com.niit.Eproject.Dao.UserDao;
import com.niit.Eproject.Model.Authentication;
import com.niit.Eproject.Model.Cart;
import com.niit.Eproject.Model.CartItems;
import com.niit.Eproject.Model.User;

public class CartTest {
	
	public static void main(String args[])
	{
	AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.*");
			ctx.refresh();
			
			Cart cart=(Cart)ctx.getBean("cart");
			CartDao cartdao=(CartDao)ctx.getBean("cartDao");
			
			User user=(User)ctx.getBean("user");
			UserDao userDao=(UserDao)ctx.getBean("userDao");
			
			cart.setCartId("ct101");
			cart.setTotalItems(20);
			user=userDao.getUser("us101");
			cart.setUser(user);
	

			
			if(cartdao.saveorupdatecartg(cart)==true)
			{
				System.out.println("cart is saved");
			}
			else
			{
				System.out.println("cart not not saved");
			}
			
			cart.setCartId("ct102");
			cart.setTotalItems(30);
			
			if(cartdao.saveorupdatecartg(cart)==true)
			{
				System.out.println("cart is saved");
			}
			else
			{
				System.out.println("cart not not saved");
			}
			
			List<Cart> cartList=cartdao.cartList();
			for(Cart c:cartList)
			{
				System.out.println("CatID:"+c.getCartId());
				System.out.println("CatName:"+c.getTotalItems());
			
			}
			
			
	}
}
