package com.niit.Eproject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Eproject.Dao.OrderItemsDao;
import com.niit.Eproject.Model.Authentication;
import com.niit.Eproject.Model.Billing;
import com.niit.Eproject.Model.OrderItems;

@Transactional
@Repository("orderItemsDao")
public class OrderItemsDaoImpl implements OrderItemsDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public OrderItemsDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean savdeorupdateOrderItems(OrderItems orderItems) {
		sessionFactory.getCurrentSession().saveOrUpdate(orderItems);
		return true;
	}

	@Override
	public boolean deleteOrderItems(OrderItems orderItems) {
		sessionFactory.getCurrentSession().delete(orderItems);
		return true;
	}

	@Override
	public OrderItems getOrderItems(String oItemId) {
		String hql = "from OrderItems where oItemId='" +oItemId+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<OrderItems> list2 =(List<OrderItems>)q.list();
		if (list2 == null || list2.isEmpty())
		{
		return null;
		}
		else {
			return list2.get(0);
		}
		
		
	
	}
	

	@Override
	public List<OrderItems> orderList() {
		List<OrderItems> orderList=(List<OrderItems>)sessionFactory.getCurrentSession().createCriteria(OrderItems.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return orderList;
	}

	
}
