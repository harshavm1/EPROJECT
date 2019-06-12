package com.niit.Eproject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Eproject.Dao.ProductDao;
import com.niit.Eproject.Model.OrderItems;
import com.niit.Eproject.Model.Pay;
import com.niit.Eproject.Model.Product;

@Transactional
@Repository("productDao")
public class ProductDaoImpl implements ProductDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean savdeorupdateProduct(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
	}

	@Override
	public boolean deleteProduct(Product product) {
		sessionFactory.getCurrentSession().delete(product);
		return true;
	}

	@Override
	public Product getProduct(String prodId) {
		String hql = "from Product where prodId='" +prodId+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> list2 =(List<Product>)q.list();
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
	public List<Product> productList() {
		List<Product> productList =(List<Product>)sessionFactory.getCurrentSession().createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return productList;
	}
	
	@Override
	public List<Product> getProductsById(String catId) {
	String c1="from Product where catId='"+catId+"'";
	Query w=sessionFactory.getCurrentSession().createQuery(c1);
	List<Product> list= (List<Product>)w.list();
	if(list==null || list.isEmpty())
	{
	return null;
	}

	return list;
	}

	@Override
	public List<Product> getProductsBySupplierId(String suppId)
	{
	String c="from Product where suppId='"+suppId+"'";
	Query w=sessionFactory.getCurrentSession().createQuery(c);
	List<Product> list= (List<Product>)w.list();
	if(list==null || list.isEmpty())
	{
	return null;
	}

	return list;
	}

}
