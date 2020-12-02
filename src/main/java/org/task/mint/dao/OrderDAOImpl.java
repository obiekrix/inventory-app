/**
 * 
 */
package org.task.mint.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.task.mint.entity.Order;

import java.util.List;

/**
 * @author Christian
 *
 */
@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	Session currentSession;

	private void init() {
		currentSession = sessionFactory.getCurrentSession();
	}

	@Override
	public Order getOrder(int id) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

	    //retrieve/read from database using the primary key
		Order theOrder = currentSession.get(Order.class, id);

		return theOrder;
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// create a query ... sort by name
		Query<Order> theQuery = currentSession.createQuery("from Order order by name", Order.class);

		// execute query and get result list
		List<Order> orders = theQuery.getResultList();

		// return the results
		return orders;
	}

	@Override
	public void saveOrder(Order theOrder) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// save the order
		currentSession.save(theOrder);
	}

	@Override
	public void updateOrder(Order theOrder) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// update the order
		currentSession.update(theOrder);
	}

	@Override
	public void deleteOrder(int theId) {
		// TODO Auto-generated method stub

	}

}
