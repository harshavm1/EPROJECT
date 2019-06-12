package com.niit.Eproject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Eproject.Dao.ShippingDao;
import com.niit.Eproject.Model.Product;
import com.niit.Eproject.Model.Shipping;

@Transactional
@Repository("shippingDao")
public class ShippingDaoImpl implements ShippingDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public ShippingDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean savdeorupdateProduct(Shipping shipping) {
		sessionFactory.getCurrentSession().saveOrUpdate(shipping);
		return true;
	}

	@Override
	public boolean deleteProduct(Shipping shipping) {
		sessionFactory.getCurrentSession().delete(shipping);
		return true;
	}

	@Override
	public Shipping getShipping(String shipId) {
		String hql = "from Shipping where shipId='" +shipId+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<Shipping> list2 =(List<Shipping>)q.list();
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
	public List<Shipping> shippingList() {
		List<Shipping> shippingList =(List<Shipping>)sessionFactory.getCurrentSession().createCriteria(Shipping.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return shippingList;
	}

}
