package com.niit.Eprojectfrontend.Controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Eproject.Dao.BillingDao;
import com.niit.Eproject.Dao.CartDao;
import com.niit.Eproject.Dao.UserDao;
import com.niit.Eproject.Model.Authentication;
import com.niit.Eproject.Model.Billing;
import com.niit.Eproject.Model.Cart;
import com.niit.Eproject.Model.User;

@Controller
@Transactional

public class UserController {

	@Autowired
	User user;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	Billing billing;
	
	@Autowired
	BillingDao billingDao;
	
	@Autowired
	Cart cart;
	
	@Autowired
	CartDao cartDao;
	
	
	@RequestMapping("/user")
	public String user(Model model)
	{
		model.addAttribute("user", new User());
		return "user";
	}
	
	
	
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public ModelAndView adduser(@ModelAttribute("user")User user)
	{
		ModelAndView obj=new ModelAndView("redirect:/user");
		Cart cart=new Cart();
		cartDao.saveorupdatecartg(cart);
		user.setCart(cart);
		Authentication a =new Authentication();
		a.setUserName(user.getEmail());
		user.setAuthentication(a);
		
		if(userDao.saveorupdateauthentication(user)==true)
		{
			obj.addObject("msg","user added successfully please login");
			System.out.println("user added successfully please login");
		}
		else
		{
			obj.addObject("msg2","sorry not able to add user");
			System.out.println("sorry not able to add user");
		}
		return obj;
	}
	
}
