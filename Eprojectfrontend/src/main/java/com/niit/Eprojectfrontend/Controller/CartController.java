package com.niit.Eprojectfrontend.Controller;


import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.servlet.http.HttpSession;



import com.niit.Eproject.Dao.CartDao;
import com.niit.Eproject.Dao.CartItemsDao;
import com.niit.Eproject.Dao.CategoryDao;
import com.niit.Eproject.Dao.ProductDao;
import com.niit.Eproject.Dao.UserDao;
import com.niit.Eproject.Model.Cart;
import com.niit.Eproject.Model.CartItems;
import com.niit.Eproject.Model.Category;
import com.niit.Eproject.Model.Product;
import com.niit.Eproject.Model.User;



@Controller
public class CartController {
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	@Autowired
	CartItems cartItems;
	@Autowired
	CartItemsDao cartItemsDao;
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	HttpSession session;
	
	
	@RequestMapping(value="/addTocart/{ProductId}")
	public String addToCart(@PathVariable("ProductId")String id,Model model)
	{
	Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	if(!(authentication instanceof AnonymousAuthenticationToken))
	{
	     String currentUsername=authentication.getName();
	     System.out.println(currentUsername);
	     user=userDao.getemail(currentUsername);
	     if(user==null)
	   	 return "redirect:/login";
	     else
	     {
	   	 Cart c=user.getCart();
	   	 System.out.println(c.getCartId());
	   	 product=productDao.getProduct(id);
	   	 CartItems cartItems=new CartItems();
	   	 cartItems.setProduct(product);
	   	 cartItems.setCart(c);
	   	 cartItems.setcItemsPrice(product.getPrice());
	   	 if(cartItemsDao.saveorupdatecartitems(cartItems))
	   	 {
	   	 int t=c.getTotalItems()+1;
	   	 float p=c.getGrandTotal()+product.getPrice();
	   	 c.setGrandTotal(p);
	   	 c.setTotalItems(t);
	   	 cartDao.saveorupdatecartg(c);
	   	 }  
	   	 System.out.println(86875);

	   	 
	   	 return "redirect:/cart";
	     }
	}
	return "redirect:/cart";
	}

	
	@RequestMapping(value="/cart")
	public ModelAndView viewCart(HttpSession session)
	{
		System.out.println(123456798);
		ModelAndView obj = new ModelAndView("cart");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken))
		{
			System.out.println(123456789);
			String currUserName = authentication.getName();
			User u = userDao.getemail(currUserName);
			Cart c = u.getCart();
			List<CartItems> cartItems = cartItemsDao.getcartitems(c.getCartId());
			if(cartItems==null || cartItems.isEmpty())
			{
				session.setAttribute("items", 0);
				obj.addObject("gTotal",0.0);
				obj.addObject("msg","no items addded in the cart");
				return obj;
			}
			else
			{
				obj.addObject("allCartItems",cartItems);
				obj.addObject("gTotal",c.getGrandTotal());
				session.setAttribute("items", c.getTotalItems());
				return obj;
			}
		}
		else
		{
			return new ModelAndView("redirect:/");
		}
	}
	
	
	@RequestMapping(value="/removeItem/{cItemsId}")
	public ModelAndView removeItem(@PathVariable("cItemsId") String cItemsId)
	{
		ModelAndView obj = new ModelAndView("redirect:/cart");
		cartItems=cartItemsDao.getcartitem(cItemsId);
		Cart c = cartItems.getCart();
		c.setGrandTotal(c.getGrandTotal()-cartItems.getcItemsPrice());
		c.setTotalItems(c.getTotalItems()-1);
		cartDao.saveorupdatecartg(c);
		cartItemsDao.deletecartitems(cartItems);
		return obj;
	}
	
	
	/*
	@RequestMapping(value="/removeAllItems")
	{
		public ModelAndView removeAllItems(HttpSession session)
		{
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if(!(authentication instanceof AnonymousAuthenticationToken))
			{
				ModelAndView obj = new ModelAndView("redirect:/cart");
			String currUserName = authentication.getName();
			User u = userDao.getemail(currUserName);
				Cart c = cartDao.getcart(u.getCart().getCartId());
			List<CartItems> cartItems = cartItemsDao.getcartitems(u.getCart().getCartId());
			for(CartItems g:cartItems)
			{
					cartItemsDao.deletecartitems(g.getcItemsId());
				}
				c.setGrandTotal(0);
				c.setTotalItems(0);
				cartDao.saveorupdatecartg(c);
				return obj;
			}
			else
		{
				return new ModelAndView("redirect:/");
			}
	}
		*/
	}
	


	
	
	
