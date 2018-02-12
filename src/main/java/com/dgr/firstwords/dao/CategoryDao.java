package com.dgr.firstwords.dao;

import com.dgr.firstwords.model.Category;

public interface CategoryDao {
	public Category getCategoryByName(String name);
}
