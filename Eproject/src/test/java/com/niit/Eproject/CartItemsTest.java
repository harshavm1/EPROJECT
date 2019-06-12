package com.niit.Eproject;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Eproject.Dao.AuthenticationDao;
import com.niit.Eproject.Dao.CartDao;
import com.niit.Eproject.Dao.CartItemsDao;
import com.niit.Eproject.Dao.ProductDao;
import com.niit.Eproject.Model.Authentication;
import com.niit.Eproject.Model.Cart;
import com.niit.Eproject.Model.CartItems;
import com.niit.Eproject.Model.Product;

public class CartItemsTest {

	
public static void main(String args[])
{
	AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.*");
			ctx.refresh();
			
			CartItems citems=(CartItems)ctx.getBean("cartItems");
			CartItemsDao citemsdao=(CartItemsDao)ctx.getBean("cartItemsDao");
			
			Cart cart=(Cart)ctx.getBean("cart");
			CartDao cartdao=(CartDao)ctx.getBean("cartDao");
			
			Product prod=(Product)ctx.getBean("product");
			ProductDao prodDao=(ProductDao)ctx.getBean("productDao");
			
			citems.setcItemsId("item101");
			citems.setcItemsPrice(50);
			cart=cartdao.getcart("ct101");
			citems.setCart(cart);
			prod=prodDao.getProduct("p1011");
			citems.setProduct(prod);
			
			
			if(citemsdao.saveorupdatecartitems(citems)==true)
			{
				System.out.println("cart is saved");
			}
			else
			{
				System.out.println("cart not not saved");
			}
			
			citems.setcItemsId("item102");
			citems.setcItemsPrice(4000);
			cart=cartdao.getcart("ct102");
			citems.setCart(cart);
			prod=prodDao.getProduct("p1012");
			citems.setProduct(prod);
			
			if(citemsdao.saveorupdatecartitems(citems)==true)
			{
				System.out.println("cart is saved");
			}
			else
			{
				System.out.println("cart not not saved");
			}

			// citems=citemsdao.getcartitems("item101");
			if(citems==null)
			{
				System.out.println("item not exists");
			}
			else
			{
				System.out.println("roleId:"+citems.getcItemsId());
				System.out.println("itemprice:"+citems.getcItemsPrice());
			}
			
			List<CartItems> cartitemsList=citemsdao.cartitemsList();
			for(CartItems c:cartitemsList)
			{
				System.out.println("CatID:"+c.getcItemsId());
				System.out.println("CatName:"+c.getcItemsPrice());
			
			}

}
}
