package org.task.mint.dao;

import org.task.mint.entity.Category;

import java.util.List;


public interface CategoryDAO {
	
	List<Category> getCategories();

	void saveCategory(Category theCategory);

	void updateCategory(Category theCategory);
	
	Category getCategory(int theId);

	void deleteCategory(int theId);

}
