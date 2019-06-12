package com.niit.Eproject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Eproject.Dao.CategoryDao;
import com.niit.Eproject.Model.Category;

@Transactional
@Repository("categoryDao")

public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean savdeorupdateCategory(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
	}

	@Override
	public boolean deleteCategory(Category category) {
		sessionFactory.getCurrentSession().delete(category);
		return true;
	}

	@Override
	public Category getCategory(String catId) {

		 String hql = "from Category where catId='" +catId+ "'";
			Query q = sessionFactory.getCurrentSession().createQuery(hql);
			List<Category> list2 =(List<Category>)q.list();
			if (list2 == null || list2.isEmpty()) {
				return null;
			} 
			else 
			{	    
				return list2.get(0);
				
			} 
	}

	@Override
	public List<Category> catlist() {
		List<Category> catlist=(List<Category>)sessionFactory.getCurrentSession().createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return catlist;
	}

}
