package com.niit.Eproject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Eproject.Dao.OrderDao;
import com.niit.Eproject.Model.Authentication;
import com.niit.Eproject.Model.Billing;
import com.niit.Eproject.Model.Order;

@Transactional
@Repository("orderDao")
public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	SessionFactory sessionFactory;

	public OrderDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean savdeorupdateOrder(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		return true;
	}

	@Override
	public boolean deleteOrder(Order order) {
		sessionFactory.getCurrentSession().delete(order);
		return true;
	}

	@Override
	public Order getOrder(String orderId) {
		String hql = "from Order where orderId='" +orderId+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<Order> list2 =(List<Order>)q.list();
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
	public List<Order> orderlist() {
		List<Order> orderList=(List<Order>)sessionFactory.getCurrentSession().createCriteria(Order.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return orderList;
	}

}
