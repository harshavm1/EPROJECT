package com.niit.Eproject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Eproject.Dao.CartDao;
import com.niit.Eproject.Model.Authentication;
import com.niit.Eproject.Model.Billing;
import com.niit.Eproject.Model.Cart;


@Transactional
@Repository("cartDao")
public class CartDaoImpl implements CartDao{
	
	@Autowired
	SessionFactory sessionFactory;

	public CartDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean saveorupdatecartg(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
	}

	@Override
	public boolean deletecart(Cart cart) {
		sessionFactory.getCurrentSession().delete(cart);
		return true;
	}

	@Override
	public Cart getcart(String cartId) {
		String hql = "from Cart where cartId='" +cartId+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<Cart> list2 =(List<Cart>)q.list();
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
	public List<Cart> cartList() {
		List<Cart> cartList=(List<Cart>)sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();		
		return cartList;

	}
	

}
