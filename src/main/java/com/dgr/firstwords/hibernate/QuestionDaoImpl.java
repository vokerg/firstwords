package com.dgr.firstwords.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dgr.firstwords.dao.CategoryDao;
import com.dgr.firstwords.dao.QuestionDao;
import com.dgr.firstwords.model.Category;
import com.dgr.firstwords.model.Question;

public class QuestionDaoImpl implements QuestionDao{
	private SessionFactory sessionFactory;

	private CategoryDao categoryDao;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Question> getQuestionsByCategoryName(String categoryName) {
		Category category = categoryDao.getCategoryByName(categoryName);
		//return (List<Question>) 
		List<Question> questions = new ArrayList<Question>();		
		questions.addAll(category.getQuestions());
		return questions;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getAllQuiestions() {
		return getCurrentSession().createCriteria(Question.class).list();
	}
	
	@Override
	public void saveQuestion(Question question) {
		getCurrentSession().save(question);
		
	}
	@Override
	public void updateQuestion(Question question) {
		getCurrentSession().update(question);
	}
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

}
