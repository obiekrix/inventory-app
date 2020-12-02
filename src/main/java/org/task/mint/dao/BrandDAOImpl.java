/**
 * 
 */
package org.task.mint.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.task.mint.entity.Brand;

import java.util.List;

/**
 * @author Christian
 *
 */
@Repository
public class BrandDAOImpl implements BrandDAO {

	@Autowired
	private SessionFactory sessionFactory;

	Session currentSession;

	private void init() {
		currentSession = sessionFactory.getCurrentSession();
	}

	@Override
	public Brand getBrand(int id) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

	    //retrieve/read from database using the primary key
		Brand theBrand = currentSession.get(Brand.class, id);

		return theBrand;
	}

	@Override
	public List<Brand> getBrands() {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// create a query ... sort by name
		Query<Brand> theQuery = currentSession.createQuery("from Brand order by name", Brand.class);

		// execute query and get result list
		List<Brand> brands = theQuery.getResultList();

		// return the results
		return brands;
	}

	@Override
	public void saveBrand(Brand theBrand) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// save the brand
		currentSession.save(theBrand);
	}

	@Override
	public void updateBrand(Brand theBrand) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		init();

		// update the brand
		currentSession.update(theBrand);
	}

	@Override
	public void deleteBrand(int theId) {
		// TODO Auto-generated method stub

	}

}
