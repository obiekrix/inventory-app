/**
 * 
 */
package org.task.mint.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.task.mint.entity.Category;

import java.util.List;

/**
 * @author Christian
 *
 */
@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	Session currentSession;

	private void init() {
		currentSession = sessionFactory.getCurrentSession();
	}

	@Override
	public Category getCategory(int id) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

	    //retrieve/read from database using the primary key
		Category theCategory = currentSession.get(Category.class, id);

		return theCategory;
	}

	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// create a query ... sort by name
		Query<Category> theQuery = currentSession.createQuery("from Category order by name", Category.class);

		// execute query and get result list
		List<Category> getCategories = theQuery.getResultList();

		// return the results
		return getCategories;
	}

	@Override
	public void saveCategory(Category theCategory) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// save the category
		currentSession.save(theCategory);
	}

	@Override
	public void updateCategory(Category theCategory) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// update the category
		currentSession.update(theCategory);
	}

	@Override
	public void deleteCategory(int theId) {
		// TODO Auto-generated method stub

	}

}
