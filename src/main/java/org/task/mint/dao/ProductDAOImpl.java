/**
 * 
 */
package org.task.mint.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.task.mint.entity.Product;

import java.util.List;

/**
 * @author Christian
 *
 */
@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	Session currentSession;

	private void init() {
		currentSession = sessionFactory.getCurrentSession();
	}

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

	    //retrieve/read from database using the primary key
		Product theProduct = currentSession.get(Product.class, id);

		return theProduct;
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// create a query ... 
		Query<Product> theQuery = currentSession.createQuery("from Product order by id", Product.class);

		// execute query and get result list
		List<Product> products = theQuery.getResultList();

		// return the results
		return products;
	}

	@Override
	public void saveProduct(Product theProduct) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// save the product
		currentSession.save(theProduct);
	}

	@Override
	public void updateProduct(Product theProduct) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// update the product
		currentSession.update(theProduct);
	}

	@Override
	public void deleteProduct(int theId) {
		// TODO Auto-generated method stub

	}

}
