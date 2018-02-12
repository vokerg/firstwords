package com.dgr.firstwords.manager;

import java.util.List;

import com.dgr.firstwords.model.Question;

public interface QuestionStrategy {
	List<Integer> getIds(List<Question> questions, int wordCount, int correctAnswers);
	Integer getCorrectAnswer(List<Integer> ids);
}
