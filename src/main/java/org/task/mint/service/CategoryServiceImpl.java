package org.task.mint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.task.mint.dao.AdminDAO;
import org.task.mint.dao.CategoryDAO;
import org.task.mint.entity.Admin;
import org.task.mint.entity.Category;
import org.task.mint.model.CategoryModel;

import java.util.List;

/**
 * @author Christian
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private AdminDAO adminDAO;

	@Override
	@Transactional
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return categoryDAO.getCategories();
	}

	@Override
	@Transactional
	public void saveCategory(CategoryModel model) {
		// TODO Auto-generated method stub

		// get the admin
		Admin admin = adminDAO.getAdmin(model.getAdminId());
				
		// build up the category
		Category category = new Category();
		
		category.setCreationDate(model.getCreationDate());
		category.setDescription(model.getDescription());
		category.setEnabled(model.getEnabled());
		category.setName(model.getName());
		category.setAdmin(admin);
		
		// save the category
		categoryDAO.saveCategory(category);
	}

	@Override
	@Transactional
	public void updateCategory(Category theCategory) {
		// TODO Auto-generated method stub

		categoryDAO.updateCategory(theCategory);
	}

	@Override
	@Transactional
	public Category getCategory(int theId) {
		// TODO Auto-generated method stub

		return categoryDAO.getCategory(theId);
	}

	@Override
	public void deleteCategory(int theId) {
		// TODO Auto-generated method stub

	}

}
