package com.niit.Eproject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Eproject.Dao.UserDao;
import com.niit.Eproject.Model.Supplier;
import com.niit.Eproject.Model.User;

@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean saveorupdateauthentication(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
	}

	@Override
	public boolean deleteauthentication(User user) {
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

	@Override
	public User getUser(String userId) {
		String hql = "from User where userId='" +userId+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list2 =(List<User>)q.list();
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
	public List<User> userList() {
		List<User> userList =(List<User>)sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return userList;
	}

	@Override
	public User isvalidate(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getemail(String email) 
	{
		String hql = "from User where email='" +email+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list2 =(List<User>)q.list();
		if (list2 == null || list2.isEmpty())
		{
		return null;
		}
		else
		{
			return list2.get(0);
		}
	}

}
