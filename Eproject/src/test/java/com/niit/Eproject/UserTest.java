package com.niit.Eproject;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Eproject.Dao.CartDao;
import com.niit.Eproject.Dao.CategoryDao;
import com.niit.Eproject.Dao.UserDao;
import com.niit.Eproject.Model.Cart;
import com.niit.Eproject.Model.Category;
import com.niit.Eproject.Model.User;

public class UserTest {

	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		User user=(User)ctx.getBean("user");
		UserDao userDao=(UserDao)ctx.getBean("userDao");
		
		Cart cart=(Cart)ctx.getBean("cart");
		CartDao cartdao=(CartDao)ctx.getBean("cartDao");
		
		user.setUserId("us101");
		user.setUserName("kiran");
		cart=cartdao.getcart("ct101");
		user.setCart(cart);
		
	
		
		
		if(userDao.saveorupdateauthentication(user)==true)
		{
			System.out.println("user is saved");
		}
		else
		{
			System.out.println("user not saved");
		}
		
		user.setUserId("us102");
		user.setUserName("kumar");
		
		if(userDao.saveorupdateauthentication(user)==true)
		{
			System.out.println("user is saved");
		}
		else
		{
			System.out.println("user not saved");
		}
		
		user=userDao.getUser("us102");
		if(user==null)
		{
			System.out.println("user not exists");
		}
		else
		{
			System.out.println("userID:"+user.getUserId());
			System.out.println("userName:"+user.getUserId());
		}
		
		List<User> userList=userDao.userList();
		for(User c:userList)
		{
			System.out.println("userID:\t"+c.getUserId());
			System.out.println("userName:\t"+c.getUserId());
		
		}
	}
}
