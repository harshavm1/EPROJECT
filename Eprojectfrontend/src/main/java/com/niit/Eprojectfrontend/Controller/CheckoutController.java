package com.niit.Eprojectfrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.Eproject.Dao.CardDao;
import com.niit.Eproject.Dao.CartDao;
import com.niit.Eproject.Dao.CartItemsDao;
import com.niit.Eproject.Dao.OrderDao;
import com.niit.Eproject.Dao.OrderItemsDao;
import com.niit.Eproject.Dao.PayDao;
import com.niit.Eproject.Dao.ProductDao;
import com.niit.Eproject.Dao.ShippingDao;
import com.niit.Eproject.Dao.UserDao;
import com.niit.Eproject.Model.Card;
import com.niit.Eproject.Model.Cart;
import com.niit.Eproject.Model.CartItems;
import com.niit.Eproject.Model.Order;
import com.niit.Eproject.Model.OrderItems;
import com.niit.Eproject.Model.Pay;
import com.niit.Eproject.Model.Product;
import com.niit.Eproject.Model.Shipping;
import com.niit.Eproject.Model.User;

@Controller
public class CheckoutController 
{
	@Autowired
	Shipping shipping;
	@Autowired
	ShippingDao shippingDao;
	@Autowired
	Pay pay;
	@Autowired
	PayDao payDao;
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
	Card card;
	@Autowired
	CardDao cardDao;
	@Autowired
	Order order;
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderItems orderItems;
	@Autowired
	OrderItemsDao orderItemsDao;




	@RequestMapping(value="/checkout")
	public String checkOut(Model model)
	{
	Shipping s=new Shipping();
	model.addAttribute("shipping",s);


	Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	if(!(authentication instanceof AnonymousAuthenticationToken))
	{
	String currentUserName=authentication.getName();
	user=userDao.getemail(currentUserName);
	if(user==null)
	return "redirect:/login";
	else
	{

	model.addAttribute("cart",user.getCart());
	}
	}
	return "checkout";

	}

	@RequestMapping(value="/placeorder")
	public String placeOrder(@RequestParam("payment-method")String payment,@ModelAttribute("shipping")Shipping shipping,Model model)
	{

	this.shipping=shipping;
	if(payment.equalsIgnoreCase("card"))
	{
	System.out.println(1111);
	Card c=new Card();
	Pay pay= new Pay();
	pay.setPayMethod("Card");
	pay.setPayStatus("paid");
	payDao.savdeorupdatePay(pay);
	this.pay=pay;
	model.addAttribute("card",c);
	return "card";
	}
	else
	{
	Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	if(!(authentication instanceof AnonymousAuthenticationToken))
	{
	String currentUserName=authentication.getName();
	user=userDao.getemail(currentUserName);
	if(user==null)
	return "redirect:/login";
	else
	{
	System.out.println(123456789);
	Pay pay= new Pay();
	pay.setPayMethod("cash");
	pay.setPayStatus("not paid");
	payDao.savdeorupdatePay(pay);
	shipping.setUser(user);
	shippingDao.savdeorupdateProduct(shipping);
	Order o=new Order();
	o.setShipping(shipping);
	o.setPay(pay);
	o.setBilliing(user.getBilling());
	o.setOrderGrandTotal(String.valueOf(user.getCart().getGrandTotal()));
	o.setUser(user);
	orderDao.savdeorupdateOrder(o);
	List<CartItems> CartItems =cartItemsDao.cartitemsList(user.getCart().getCartId()); 
	               for(CartItems c1:CartItems)
	               {
	               	OrderItems oi=new OrderItems();
	               	oi.setOrder(o);
	               	oi.setProdId(c1.getProduct().getProdId());
	               	orderItemsDao.savdeorupdateOrderItems(oi);
	               	this.cart=user.getCart();
	               	this.cart.setTotalItems(this.cart.getTotalItems()-1);
	               	this.cart.setGrandTotal(this.cart.getGrandTotal()-c1.getcItemsPrice());
	               	cartItemsDao.deletecartitems(c1);
	               	cartDao.saveorupdatecartg(this.cart);
	               }
	}
	}
	return "redirect:/confirm";
	}
	}

	@RequestMapping(value="/addCard")
	public String addCard(@ModelAttribute("pay")Pay pay,@ModelAttribute("card")Card card,Model model)
	{

	if(cardDao.saveorupdate(card)==true)
	{
	Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	if(!(authentication instanceof AnonymousAuthenticationToken))
	{


	String currentUserName=authentication.getName();
	user=userDao.getemail(currentUserName);
	if(user==null)
	return "redirect:/login";
	else
	{
	System.out.println(123456789);
	card.setUser(user);
	cardDao.saveorupdate(card);
	Order o=new Order();
	this.shipping.setUser(user);
	shippingDao.savdeorupdateProduct(this.shipping);
	o.setShipping(this.shipping);
	o.setPay(this.pay);
	o.setBilliing(user.getBilling());
	o.setOrderGrandTotal(String.valueOf(user.getCart().getGrandTotal()));
	o.setUser(user);
	orderDao.savdeorupdateOrder(o);
	List<CartItems> CartItems =cartItemsDao.cartitemsList(user.getCart().getCartId()); 
	               for(CartItems c1:CartItems)
	               {
	               	System.out.println(c1.getcItemsId());
	               	OrderItems oi=new OrderItems();
	               	oi.setOrder(o);
	               	oi.setProdId(c1.getProduct().getProdId());
	               	System.out.println(c1.getProduct().getProdId());
	               	orderItemsDao.savdeorupdateOrderItems(oi);
	               	this.cart=user.getCart();
	               	this.cart.setTotalItems(this.cart.getTotalItems()-1);
	               	this.cart.setGrandTotal(this.cart.getGrandTotal()-c1.getcItemsPrice());
	               	cartItemsDao.deletecartitems(c1);
	               	cartDao.saveorupdatecartg(this.cart);
	               }
	               
	              
	}
	}
	System.out.println("yes i am done");
	return "redirect:/confirm";
	}
	else
	{
	return "redirect:/checkout";
	}
	  }

	@RequestMapping(value="/confirm")
	public String confirm(Model model)
	{
//		List<OrderItems> oi=orderItemsDao.orderitemslist();
//		model.addAttribute("orderItems",oi);
//		Orders o=ordersDao.getOrders(oi);
//		model.addAttribute("orders",o);
	return "confirm";
	}



}
