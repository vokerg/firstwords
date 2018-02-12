package com.dgr.firstwords.model;

import java.util.HashSet;
import java.util.Set;

public class Category {
	private int id;
	private String catName;
	private Set<Question> questions = new HashSet<Question>(0);
	public int getId() {
		return id;
	}
	public void setId(int id) {
		System.out.println("category ID here");

		this.id = id;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
}
