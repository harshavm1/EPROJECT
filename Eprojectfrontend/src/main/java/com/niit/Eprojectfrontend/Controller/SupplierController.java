package com.niit.Eprojectfrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Eproject.Dao.SupplierDao;
import com.niit.Eproject.Model.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping("/Supplier")
	public ModelAndView Supplier()
	{
		ModelAndView mv= new ModelAndView();
		List<Supplier> supplierlist= supplierDao.supplierList();
		mv.addObject("supplier", new Supplier());		// new supplier creation
		mv.addObject("suppliers", supplierlist);		//list of suppliers
		mv.setViewName("supplier");					//jsp pg name
		return mv;
	}
	
	
	@RequestMapping("/addsupp")
	public ModelAndView addcat(@ModelAttribute("supplier")Supplier supplier)
	
	{
		ModelAndView mv= new ModelAndView("redirect:/Supplier");
		if(supplierDao.saveorupdatesupplier(supplier)==true)
		{
			mv.addObject("msg1", "supplier saved successfully");
			System.out.println("supplier saved successfully");
		}
		else
		{
			mv.addObject("msg1", "supplier not saved successfully");
			System.out.println("supplier not saved successfully");
		}
		return mv;
	}
	
	
	@RequestMapping("/editSupplier/{suppId}")
	public ModelAndView editCat(@PathVariable("suppId") String suppId) {
		ModelAndView mv = new ModelAndView();
		supplier=supplierDao.getSupplier(suppId);
		mv.addObject("supplier", supplier);
		List<Supplier> suppliers = supplierDao.supplierList();
		mv.addObject("suppliers", suppliers);
		mv.setViewName("supplier");
		return mv;

	}
	
	
	@RequestMapping("/deleteSupplier/{suppId}")
	public ModelAndView deleteCat(@PathVariable("suppId") String suppId) {
		ModelAndView mv = new ModelAndView();
		supplier = supplierDao.getSupplier(suppId);
		if (supplierDao.deletesupplier(supplier) == true) {
			System.out.println("supplier Deleted");
			mv.addObject("msg", "supplier Deleted");
		} else {
			System.out.println("Not Deleted ");
			mv.addObject("msg", "supplier not Deleted");

		}
		mv.setViewName("redirect:/Supplier");

		return mv;
	
	
	}

}
