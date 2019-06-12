package com.niit.Eprojectfrontend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	@RequestMapping("/index")
	public String home1()
	{
		return "index";
	}
	
	@RequestMapping("/in")
	public String home5()
	{
		return "header";
	}
	
	@RequestMapping("/about")
	public String about()
	{
		return "about";
	}
	
	@RequestMapping("/contact")
	public String contact()
	{
		return "contact";
	}
	
	@RequestMapping("/category")
	public String category()
	{
		return "category";
	}
	
	@RequestMapping("/supplier")
	public String supplier()
	{
		return "supplier";
	}
	
	@RequestMapping("/viewproducts")
	public String viewproducts()
	{
		return "viewproducts";
	}
	
	@RequestMapping("/order")
	public String order()
	{
		return "order";
	}
	
//	@RequestMapping("/cart")
//	public String cart()
//	{
//		return "cart";
//	}
	
//	@RequestMapping("/login")
//	public String login()
//	{
//		return "login";
//	}
	
	
	
	
	
	

}
