package com.niit.Eprojectfrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Eproject.Dao.CategoryDao;
import com.niit.Eproject.Model.Category ;

@Controller
public class CategoryController {
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDao;
	
	
	@RequestMapping("/Category")							//open the category pg
	public ModelAndView Category()							
	{														
		ModelAndView mv= new ModelAndView();						
		List<Category> catlist= categoryDao.catlist();		
		mv.addObject("category", new Category());			//category obj
		mv.addObject("categories", catlist);				//list category obj
		mv.setViewName("category");				            //jsp pg name
		return mv;
		
	}
										
	@RequestMapping("/addcat")								//save option
	public ModelAndView addcat(@ModelAttribute("category")Category category)
	
	{
		ModelAndView mv= new ModelAndView("redirect:/Category");			//after saving where it has to redirect
		if(categoryDao.savdeorupdateCategory(category)==true)				//saveorupdation
		{
			mv.addObject("msg1", "category saved successfully");
			System.out.println("category saved successfully");
		}
		else
		{
			mv.addObject("msg1", "category not saved successfully");
			System.out.println("category not saved successfully");
		}
		return mv;
	}
	
	@RequestMapping("/editCategory/{catId}")							//edit category
	public ModelAndView editCat(@PathVariable("catId") String catId) {
		ModelAndView mv = new ModelAndView();
		category=categoryDao.getCategory(catId);				//get category id
		mv.addObject("category", category);						//updation
		List<Category> Categories = categoryDao.catlist();
		mv.addObject("categories", Categories);
		mv.setViewName("category");									//jsp pg name
		return mv;

	}
	
	@RequestMapping("/deleteCategory/{catId}")
	public ModelAndView deleteCat(@PathVariable("catId") String catId) {
		ModelAndView mv = new ModelAndView();
		category = categoryDao.getCategory(catId);					//get catid
		if (categoryDao.deleteCategory(category) == true) {				//deletion
			System.out.println("Category Deleted");
			mv.addObject("msg", "Category Deleted");
		} else {
			System.out.println("Not Deleted ");
			mv.addObject("msg", "Category not Deleted");

		}
		mv.setViewName("redirect:/Category");						//redirect to the root category handler
		return mv;
	
	
	}
	

}
