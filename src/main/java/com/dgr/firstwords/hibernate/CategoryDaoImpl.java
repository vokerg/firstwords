package com.dgr.firstwords.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.dgr.firstwords.dao.CategoryDao;
import com.dgr.firstwords.model.Category;

public class CategoryDaoImpl implements CategoryDao{
	
	private SessionFactory sessionFactory;
	
	public Category getCategoryByName(String name) {
		return (Category) getCurrentSession().createCriteria(Category.class)
			.add(Restrictions.eq("catName", name))
			.setMaxResults(1)
			.list()
			.get(0);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
