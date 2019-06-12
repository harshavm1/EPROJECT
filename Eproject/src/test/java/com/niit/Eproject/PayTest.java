package com.niit.Eproject;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Eproject.Dao.CategoryDao;
import com.niit.Eproject.Dao.PayDao;
import com.niit.Eproject.Model.Category;
import com.niit.Eproject.Model.Pay;

public class PayTest {
	
	public static void main(String args[])
	{
		
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Pay pay=(Pay)ctx.getBean("pay");
		PayDao paydao=(PayDao)ctx.getBean("payDao");
		
		pay.setPayId("p101");
		pay.setPayMethod("credit");
		pay.setPayStatus("success");
		
		if(paydao.savdeorupdatePay(pay)==true)
		{
			System.out.println("pay is saved");
		}
		else
		{
			System.out.println("pay not saved");
		}
		
		pay.setPayId("p102");
		pay.setPayMethod("debit");
		pay.setPayStatus("pending");
		
		if(paydao.savdeorupdatePay(pay)==true)
		{
			System.out.println("pay is saved");
		}
		else
		{
			System.out.println("pay not saved");
		}
		
		pay=paydao.getPay("p101");
		if(pay==null)
		{
			System.out.println("pay not exists");
		}
		else
		{
			System.out.println("payid:"+pay.getPayId());
			System.out.println("paymethod:"+pay.getPayMethod());
		}
		
		List<Pay> paylist=paydao.payList();
		for(Pay p:paylist)
		{
			System.out.println("payid:"+p.getPayId());
			System.out.println("paymethod:"+p.getPayMethod());
		
		}
			
	}

}
