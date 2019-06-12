package com.niit.Eproject;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Eproject.Dao.BillingDao;
import com.niit.Eproject.Model.Billing;



public class BillingTest {
	

	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Billing bill=(Billing)ctx.getBean("billing");
		BillingDao billingDao=(BillingDao)ctx.getBean("billingDao");
		
		bill.setBillId("b101");
		bill.setAddress("india");
		bill.setBillName("rohit");
		bill.setEmail("rohit#@gmail.com");
		
		if(billingDao.saveorupdatebilling(bill)==true)
		{
			System.out.println("bill is saved");
		}
		else
		{
			System.out.println("bill not saved");
		}
		
		bill.setBillId("b102");
		bill.setAddress("afg");
		bill.setBillName("mohit");
		bill.setEmail("mohit#@gmail.com");
		
		if(billingDao.saveorupdatebilling(bill)==true)
		{
			System.out.println("bill is saved");
		}
		else
		{
			System.out.println("bill not saved");
		}
		
		
		
		bill=billingDao.getBilling("b101");
		if(bill==null)
		{
			System.out.println("bill not exists");
		}
		else
		{
			System.out.println("billid:"+bill.getBillId());
			System.out.println("billaddress:"+bill.getAddress());
		}
		
		
		
		
		List<Billing> billingList=billingDao.billingList();
		for(Billing b:billingList)
		{
			System.out.println("billid:"+b.getBillId());
			System.out.println("billaddress:"+b.getAddress());
		
		}
		
	}

}
