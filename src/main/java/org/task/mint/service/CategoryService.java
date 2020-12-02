package org.task.mint.service;

import org.task.mint.entity.Category;
import org.task.mint.model.CategoryModel;

import java.util.List;

/**
 * @author Christian
 *
 */
public interface CategoryService {
	
	List<Category> getCategories();

	void saveCategory(CategoryModel model);

	void updateCategory(Category theCategory);

	Category getCategory(int theId);

	void deleteCategory(int theId);
}
