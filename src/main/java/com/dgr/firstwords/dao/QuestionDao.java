package com.dgr.firstwords.dao;

import java.util.List;

import com.dgr.firstwords.model.Question;

public interface QuestionDao {
	public List<Question> getQuestionsByCategoryName (String categoryName);
	public List<Question> getAllQuiestions();
	public void saveQuestion(Question question);
	public void updateQuestion(Question question);
}
