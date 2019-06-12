package com.niit.Eproject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Eproject.Dao.SupplierDao;
import com.niit.Eproject.Model.Supplier;

@Transactional
@Repository("supplierDao")
public class SuppplierDaoImpl implements SupplierDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public SuppplierDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean saveorupdatesupplier(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;
	}

	@Override
	public boolean deletesupplier(Supplier supplier) {
		sessionFactory.getCurrentSession().delete(supplier);
		return true;
	}

	@Override
	public Supplier getSupplier(String suppId) {
		String hql = "from Supplier where suppId='" +suppId+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> list2 =(List<Supplier>)q.list();
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
	public List<Supplier> supplierList() {
		List<Supplier> supplierList =(List<Supplier>)sessionFactory.getCurrentSession().createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return supplierList;
	}

}
