/**
 * 
 */
package org.task.mint.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.task.mint.entity.OrderedProduct;

import java.util.List;

/**
 * @author Christian
 *
 */
@Repository
public class OrderedProductDAOImpl implements OrderedProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	Session currentSession;

	private void init() {
		currentSession = sessionFactory.getCurrentSession();
	}

	@Override
	public OrderedProduct getOrderedProduct(int id) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// retrieve/read from database using the primary key
		OrderedProduct theOrderedProduct = currentSession.get(OrderedProduct.class, id);

		return theOrderedProduct;
	}

	@Override
	public List<OrderedProduct> getOrderedProducts() {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// create a query ... sort by order
		Query<OrderedProduct> theQuery = currentSession.createQuery("from OrderedProduct orderedProduct by order",
				OrderedProduct.class);

		// execute query and get result list
		List<OrderedProduct> orderedProducts = theQuery.getResultList();

		// return the results
		return orderedProducts;
	}

	@Override
	public void saveOrderedProduct(OrderedProduct theOrderedProductt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateOrderedProduct(OrderedProduct theOrderedProduct) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOrderedProduct(int theId) {
		// TODO Auto-generated method stub

	}

}
