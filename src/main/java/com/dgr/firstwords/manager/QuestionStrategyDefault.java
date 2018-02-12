package com.dgr.firstwords.manager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.dgr.firstwords.model.Question;

public class QuestionStrategyDefault implements QuestionStrategy {
	private Random rand = new Random();

	@Override
	public List<Integer> getIds(List<Question> questions, int wordCount, int correctAnswers) {
		return getRandomIds(getWordCoundForNextIteration(wordCount, correctAnswers), questions.size());
	}
	
	private List<Integer> getRandomIds(int size, int totalSize) {
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < size; i++) {
			int randInt = rand.nextInt(totalSize);
			while (set.contains(randInt)) {
				randInt = rand.nextInt(totalSize);
			}
			set.add(randInt);
		}
		
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(set);
		return list;
	}
	
	private int getWordCoundForNextIteration(int wordCount, int correctAnswers) {
		if (wordCount < 2) {
			return 2;
		}
		if ((wordCount < 6) && (correctAnswers > 2)) {
			return ++wordCount;
		} 
		else if ((wordCount == 6) && (correctAnswers > 2)) {
			return 6;
		}
		else if ((wordCount > 2) && (correctAnswers == -1)) {
			return --wordCount;
		}
		else {
			return wordCount;
		}
	}

	@Override
	public Integer getCorrectAnswer(List<Integer> ids) {
		return rand.nextInt(ids.size());
	}
}
