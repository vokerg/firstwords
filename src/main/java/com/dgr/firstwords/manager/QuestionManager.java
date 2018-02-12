package com.dgr.firstwords.manager;

import java.util.Map;

public interface QuestionManager {
	Map<String, Object> getQuestionList(String categoryName, int wordCount, int correctAnswers) throws InstantiationException, IllegalAccessException;
}