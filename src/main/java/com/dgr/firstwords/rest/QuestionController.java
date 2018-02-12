package com.dgr.firstwords.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dgr.firstwords.dao.QuestionDao;
import com.dgr.firstwords.manager.QuestionManager;
import com.dgr.firstwords.model.Question;

@RestController
@RequestMapping("questions")
public class QuestionController {
	@Autowired
	QuestionDao questionDao;
	
	@Autowired
	QuestionManager questionManager;
	
	@RequestMapping(value="", method=RequestMethod.GET, produces="application/json")
	public List<Question> getAllQuestions() {
		return questionDao.getAllQuiestions();
	}
	
	@RequestMapping(value="/{categoryName}/{wordCount}/{correctAnswers}", method=RequestMethod.GET, produces="application/json")
	public Map<String, Object> getQuestionList(@PathVariable String categoryName, @PathVariable int wordCount, @PathVariable int correctAnswers) throws InstantiationException, IllegalAccessException {
		Map<String, Object> map = questionManager.getQuestionList(categoryName, wordCount, correctAnswers);
		
		return map;
	}
}
