package com.niit.Eproject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Eproject.Dao.CartDao;
import com.niit.Eproject.Dao.CartItemsDao;
import com.niit.Eproject.Model.Authentication;
import com.niit.Eproject.Model.Billing;
import com.niit.Eproject.Model.CartItems;

@Transactional
@Repository("cartItemsDao")
public class CartItemsDaoImpl implements CartItemsDao {

	@Autowired
	SessionFactory sessionFactory;

	public CartItemsDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveorupdatecartitems(CartItems cartitems) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartitems);
		return true;
	}

	@Override
	public boolean deletecartitems(CartItems cartitems) {
		sessionFactory.getCurrentSession().delete(cartitems);
		return true;
	}

	@Override
	public List<CartItems> getcartitems(String cItemsId) {
		String hql = "from CartItems where cartId='" + cItemsId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<CartItems> list2 = (List<CartItems>) q.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} else {
			return list2;
		}
	}

	@Override
	public CartItems getcartitem(String cItemsId) {
		String hql = "from CartItems where cItemsId='" + cItemsId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<CartItems> list2 = (List<CartItems>) q.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} else {
			return list2.get(0);
		}
	}

	@Override
	public List<CartItems> cartitemsList() {
		List<CartItems> cartitemsList = (List<CartItems>) sessionFactory.getCurrentSession()
				.createCriteria(CartItems.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return cartitemsList;
	}

	@Override
	public List<CartItems> getCartItemsByProductId(String prodId) {
		String q1 = "from CartItems where prodId='" + prodId + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		List<CartItems> list = (List<CartItems>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list;
	}
   @Override
   public List<CartItems> cartitemsList(String cartID){
	   String q1 = "from CartItems where cartId='"+cartID +"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		List<CartItems> list = (List<CartItems>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list; 
   }
}
