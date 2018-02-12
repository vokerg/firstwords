package com.dgr.firstwords.model;

import java.util.HashSet;
import java.util.Set;

public class Question {
	private int id;
	private String name;
	private String imgSrc;
	private String audioSrc;
	private Set<Category> categories = new HashSet<Category>(0);
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		System.out.println("question ID here");

		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public String getAudioSrc() {
		return audioSrc;
	}
	public void setAudioSrc(String audioSrc) {
		this.audioSrc = audioSrc;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
}
