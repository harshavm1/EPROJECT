package com.niit.Eproject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Eproject.Dao.PayDao;
import com.niit.Eproject.Model.Pay;

@Transactional
@Repository("payDao")
public class PayDaoImpl implements PayDao{

	@Autowired
	SessionFactory sessionFactory;
	public PayDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean savdeorupdatePay(Pay pay) {
		sessionFactory.getCurrentSession().saveOrUpdate(pay);
		return true;
	}

	@Override
	public boolean deleteOrderPay(Pay pay) {
		sessionFactory.getCurrentSession().delete(pay);
		return true;
	}

	@Override
	public Pay getPay(String payId) {
		String hql = "from Pay where payId='" +payId+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<Pay> list2 =(List<Pay>)q.list();
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
	public List<Pay> payList() {
		List<Pay> payList=(List<Pay>)sessionFactory.getCurrentSession().createCriteria(Pay.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return payList;
	}

}
