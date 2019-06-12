package com.niit.Eproject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Eproject.Dao.BillingDao;
import com.niit.Eproject.Model.Authentication;
import com.niit.Eproject.Model.Billing;


@Transactional
@Repository("billingDao")
public class BillingDaoImpl implements BillingDao{

	@Autowired
	SessionFactory sessionFactory;

	
	public BillingDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean saveorupdatebilling(Billing billing) {
		sessionFactory.getCurrentSession().saveOrUpdate(billing);
		return true;
	}

	@Override
	public boolean deletebilling(Billing billing) {
		sessionFactory.getCurrentSession().delete(billing);
		return true;
	}

	@Override
	public Billing getBilling(String billId) {
		String hql = "from Billing where billId='" +billId+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<Billing> list2 =(List<Billing>)q.list();
		if (list2 == null || list2.isEmpty())
		{
		return null;
		}
		else
		{
			return list2.get(0);
		}
	}

	@Override
	public List<Billing> billingList() {
		List<Billing> billingList=(List<Billing>)sessionFactory.getCurrentSession().createCriteria(Billing.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return billingList;
	}
	

}
