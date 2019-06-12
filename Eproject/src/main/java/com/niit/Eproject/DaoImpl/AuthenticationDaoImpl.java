package com.niit.Eproject.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Eproject.Dao.AuthenticationDao;
import com.niit.Eproject.Model.Authentication;


@Transactional
@Repository("authenticationDao")
public class AuthenticationDaoImpl implements AuthenticationDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public AuthenticationDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean saveorupdateauthentication(Authentication authentication) {
		sessionFactory.getCurrentSession().saveOrUpdate(authentication);
		return true;
	}

	@Override
	public boolean deleteauthentication(Authentication authentication) {
		sessionFactory.getCurrentSession().delete(authentication);
		return true;
	}

	@Override
	public Authentication getAuthentication(String roleId) {
		String hql = "from Authentication where roleId='" +roleId+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<Authentication> list2 =(List<Authentication>)q.list();
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
	public List<Authentication> authenticationList() {
		List<Authentication> authenticationList =(List<Authentication>)sessionFactory.getCurrentSession().createCriteria(Authentication.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return authenticationList;
	}

}
