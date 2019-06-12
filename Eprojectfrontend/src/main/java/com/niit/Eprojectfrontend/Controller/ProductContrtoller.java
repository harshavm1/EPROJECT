package com.niit.Eprojectfrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Eproject.Dao.CategoryDao;
import com.niit.Eproject.Dao.ProductDao;
import com.niit.Eproject.Dao.SupplierDao;
import com.niit.Eproject.Model.Product;
import com.niit.Eproject.Model.Supplier;
import com.niit.Eprojectfrontend.FileInput.FileInput;
import com.niit.Eproject.Model.Category;

@Controller
public class ProductContrtoller {

	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDao supplierDao;
	
	String path="C:\\eclipse workspace\\Eprojectfrontend\\src\\main\\webapp\\resources\\images\\";
	
	@RequestMapping("/Product")
	public ModelAndView Category()
	{
		ModelAndView mv= new ModelAndView();
		List<Product> prodlist= productDao.productList();
		List<Category> catlist= categoryDao.catlist();
		List<Supplier> supplierlist= supplierDao.supplierList();
		mv.addObject("supplier", new Supplier());		
		mv.addObject("suppliers", supplierlist);
		mv.addObject("product", new Product());
		mv.addObject("products", prodlist);
		mv.addObject("category", new Category());
		mv.addObject("categories", catlist);
		mv.setViewName("product");
		return mv;
		
	}
	
	@RequestMapping("/addprod")
	public ModelAndView addcat(@ModelAttribute("product")Product product)
	
	{
		ModelAndView mv= new ModelAndView("redirect:/Product");
		FileInput.upload(path, product.getPimg(), product.getProdId()+".jpg");
		if(productDao.savdeorupdateProduct(product)==true)
		{
			mv.addObject("msg1", "product saved successfully");
			System.out.println("product saved successfully");
		}
		else
		{
			mv.addObject("msg1", "product not saved successfully");
			System.out.println("product not saved successfully");
		}
		return mv;
	}
	
	@RequestMapping("/editProduct/{prodId}")
	public ModelAndView editCat(@PathVariable("prodId") String prodId) {
		ModelAndView mv = new ModelAndView();
		List<Category> catlist= categoryDao.catlist();		
		mv.addObject("category", new Category());			//category obj
		mv.addObject("categories", catlist);	
		List<Supplier> supplierlist= supplierDao.supplierList();
		mv.addObject("supplier", new Supplier());		// new supplier creation
		mv.addObject("suppliers", supplierlist);
		product=productDao.getProduct(prodId);
		mv.addObject("product", product);
		List<Product> products = productDao.productList();
		mv.addObject("products", products);
		mv.setViewName("product");
		return mv;

	}
	
	@RequestMapping("/deleteProduct/{prodId}")
	public ModelAndView deleteCat(@PathVariable("prodId") String prodId) {
		ModelAndView mv = new ModelAndView();
		product = productDao.getProduct(prodId);
		if (productDao.deleteProduct(product) == true) {
			System.out.println("product Deleted");
			mv.addObject("msg", "product Deleted");
		} else {
			System.out.println("Not Deleted ");
			mv.addObject("msg", "product not Deleted");

		}
		mv.setViewName("redirect:/Product");

		return mv;
	
	}
	
	@RequestMapping("/viewall/{prodId}")
	public ModelAndView viewProduct(@PathVariable("prodId")String prodId)
	{
		ModelAndView obj=new ModelAndView();
		product=productDao.getProduct(prodId);
		obj.addObject("product", product);
		return obj;
		
		
	}
	
	
	@RequestMapping("/viewall")
	public ModelAndView viewProduct()
	{
		ModelAndView obj=new ModelAndView("viewproducts");
		List<Product> products=productDao.productList();
		obj.addObject("product", products);
		return obj;
		
		
	}


}
