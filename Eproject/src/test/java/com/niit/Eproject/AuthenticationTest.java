package com.niit.Eproject;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Eproject.Dao.AuthenticationDao;
import com.niit.Eproject.Model.Authentication;
import com.niit.Eproject.Model.Category;

public class AuthenticationTest {

	public static void main(String args[])
	{
		
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
				ctx.refresh();
				
		Authentication role=(Authentication)ctx.getBean("authentication");
		AuthenticationDao roleDao=(AuthenticationDao)ctx.getBean("authenticationDao");
		
		role.setRoleId("r101");
		role.setRoleName("user");
		role.setUserName("rohit");
		
		if(roleDao.saveorupdateauthentication(role)==true)
		{
			System.out.println("role is saved");
		}
		else
		{
			System.out.println("role not not saved");
		}
		
		role.setRoleId("r102");
		role.setRoleName("admin");
		role.setUserName("mohit");
		
		if(roleDao.saveorupdateauthentication(role)==true)
		{
			System.out.println("role is saved");
		}
		else
		{
			System.out.println("role not not saved");
		}
		
		role.setRoleId("r103");
		role.setRoleName("user");
		role.setUserName("lohit");
		
		if(roleDao.saveorupdateauthentication(role)==true)
		{
			System.out.println("role is saved");
		}
		else
		{
			System.out.println("role not not saved");
		}

		role=roleDao.getAuthentication("r102");
		if(role==null)
		{
			System.out.println("role not exists");
		}
		else
		{
			System.out.println("roleId:"+role.getRoleId());
			System.out.println("Rolename:"+role.getRoleName());
		}
		
		List<Authentication> authenticationlist=roleDao.authenticationList();
		for(Authentication c:authenticationlist)
		{
			System.out.println("CatID:"+c.getRoleId());
			System.out.println("CatName:"+c.getRoleName());
		
		}
				
		
	}
}
