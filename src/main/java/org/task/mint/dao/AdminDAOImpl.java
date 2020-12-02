/**
 * 
 */
package org.task.mint.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.task.mint.entity.Admin;

import java.util.List;

/**
 * @author Christian
 *
 */
@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SessionFactory sessionFactory;

	Session currentSession;

	private void init() {
		currentSession = sessionFactory.getCurrentSession();
	}

	@Override
	public Admin getAdmin(int id) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

	    //retrieve/read from database using the primary key
		Admin theAdmin = currentSession.get(Admin.class, id);

		return theAdmin;
	}

	@Override
	public List<Admin> getAdmins() {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// create a query ... sort by first name
		Query<Admin> theQuery = currentSession.createQuery("from Admin order by firstName", Admin.class);

		// execute query and get result list
		List<Admin> admins = theQuery.getResultList();

		// return the results
		return admins;
	}

	@Override
	public void saveAdmin(Admin theAdmin) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// save the admin
		currentSession.save(theAdmin);
	}

	@Override
	public void updateAdmin(Admin theAdmin) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// update the admin
		currentSession.update(theAdmin);
	}

	@Override
	public void deleteAdmin(int theId) {
		// TODO Auto-generated method stub

	}

}
